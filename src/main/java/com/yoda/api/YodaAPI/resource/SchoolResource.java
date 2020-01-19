package com.yoda.api.YodaAPI.resource;

import com.yoda.api.YodaAPI.model.School;
import com.yoda.api.YodaAPI.repository.SchoolRepository;
import com.yoda.api.YodaAPI.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schools")
public class SchoolResource {

    @Autowired
    SchoolService schoolService;


    @GetMapping("/register")
    public School register(@RequestParam String name, @RequestParam String password){
        return schoolService.createSchool(name,password);
    }


}