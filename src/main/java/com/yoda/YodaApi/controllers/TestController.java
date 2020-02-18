package com.yoda.YodaApi.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/apprentice")
	@PreAuthorize("hasRole('APPRENTICE')")
	public String userAccess() {
		return "APPRENTICE";
	}

	@GetMapping("/teacher")
	@PreAuthorize("hasRole('TEACHER')")
	public String teacherAccess() {
		return "TEACHER";
	}

	@GetMapping("/superuser")
	@PreAuthorize("hasRole('SUPERUSER')")
	public String superuserAccess() {
		return "SUPERUSER";
	}

	@GetMapping("/getRole")
	@PreAuthorize("permitAll()")
	public String getRole(HttpServletRequest request){
		if (request.isUserInRole("APPRENTICE")){
			return "You are logged in as role: APPRENTICE";
		} else if (request.isUserInRole("TEACHER")){
			return "You are logged in as role: TEACHER";
		} else if (request.isUserInRole("SUPERUSER")){
			return "You are logged in as role: SUPERUSER";
		}
		return "You are not logged in!";
	}
}
