package com.yoda.api.YodaAPI.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class ErrorResource {
  // @GetMapping
    public HttpStatus error(){
        return HttpStatus.FORBIDDEN;
    }
}
