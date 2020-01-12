package com.yoda.api.YodaAPI.repository;

import com.yoda.api.YodaAPI.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) Return u")
    Collection<User> getAllUsers();
}
