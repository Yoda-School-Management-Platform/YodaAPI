package com.yoda.YodaApi.controllers;

import com.yoda.YodaApi.models.ERole;
import com.yoda.YodaApi.models.Role;
import com.yoda.YodaApi.models.User;
import com.yoda.YodaApi.payload.request.LoginRequest;
import com.yoda.YodaApi.payload.request.SignupRequest;
import com.yoda.YodaApi.payload.response.JwtResponse;
import com.yoda.YodaApi.payload.response.MessageResponse;
import com.yoda.YodaApi.repository.RoleRepository;
import com.yoda.YodaApi.repository.SchoolRepository;
import com.yoda.YodaApi.repository.UserRepository;
import com.yoda.YodaApi.security.jwt.JwtUtils;
import com.yoda.YodaApi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user/auth")
public class AuthController {
	@Autowired
    AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	SchoolRepository schoolRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
    PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/token")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/register")
	@PreAuthorize("hasRole('SUPERUSER')")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 schoolRepository.findSchoolByName(signUpRequest.getSchoolName()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();


		if (strRoles == null) {
			throw new RuntimeException("Error: Role is not found.");
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "superuser":
					Role superuserRole = roleRepository.findByName(ERole.ROLE_SUPERUSER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(superuserRole);

					break;
				case "apprentice":
					Role apprenticeRole = roleRepository.findByName(ERole.ROLE_APPRENTICE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(apprenticeRole);

					break;
				case "teacher":
					Role teacherRole = roleRepository.findByName(ERole.ROLE_TEACHER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(teacherRole);
					break;
				default:
					throw new RuntimeException("Error: Role is not found.");
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
