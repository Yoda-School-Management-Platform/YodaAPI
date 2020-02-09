package com.yoda.YodaApi.controllers;

import com.yoda.YodaApi.models.ERole;
import com.yoda.YodaApi.models.Role;
import com.yoda.YodaApi.models.School;
import com.yoda.YodaApi.models.User;
import com.yoda.YodaApi.payload.request.SchoolRegisterRequest;
import com.yoda.YodaApi.payload.response.MessageResponse;
import com.yoda.YodaApi.repository.RoleRepository;
import com.yoda.YodaApi.repository.SchoolRepository;
import com.yoda.YodaApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/school/")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerSchool(@Valid @RequestBody SchoolRegisterRequest schoolRegisterRequest){

        if (schoolRepository.existsByName(schoolRegisterRequest.getName())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Name is already taken!"));
        }

        if (userRepository.existsByEmail(schoolRegisterRequest.getSuperuser_email())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        School school = new School (schoolRegisterRequest.getName(),
                                    schoolRegisterRequest.getEmail(),
                                    schoolRegisterRequest.getStreet(),
                                    schoolRegisterRequest.getHouseNumber(),
                                    schoolRegisterRequest.getZipCode(),
                                    schoolRegisterRequest.getCity(),
                                    schoolRegisterRequest.getState(),
                                    schoolRegisterRequest.getCountry());

        User superuser = new User (schoolRegisterRequest.getSuperuser_name(),
                                   schoolRegisterRequest.getSuperuser_email(),
                                   encoder.encode(schoolRegisterRequest.getSuperuser_password()),
                                   school);

        Set<Role> roles = new HashSet<>();

        Role superuserRole = roleRepository.findByName(ERole.ROLE_SUPERUSER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(superuserRole);

        schoolRepository.save(school);
        superuser.setRoles(roles);
        userRepository.save(superuser);

        return ResponseEntity.ok(new MessageResponse("School & Superuser registered successfully!"));

    }

}
