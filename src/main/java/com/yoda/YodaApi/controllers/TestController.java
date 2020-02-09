package com.yoda.YodaApi.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
