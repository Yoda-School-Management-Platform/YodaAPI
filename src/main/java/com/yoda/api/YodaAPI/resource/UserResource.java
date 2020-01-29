package com.yoda.api.YodaAPI.resource;

import com.yoda.api.YodaAPI.model.User;
import com.yoda.api.YodaAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(name= "/api/v1/users", produces = {"application/json"})
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<User> getAll(){
        return userService.getAll();
    }
}

