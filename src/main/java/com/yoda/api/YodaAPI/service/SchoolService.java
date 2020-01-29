package com.yoda.api.YodaAPI.service;

import com.yoda.api.YodaAPI.model.School;
import com.yoda.api.YodaAPI.repository.SchoolRepository;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
   @Autowired
    SchoolRepository schoolRepository;

    public School createSchool(String name, String password){
        School newSchool = new School(name, password);
        return schoolRepository.save(newSchool);
    }
}
