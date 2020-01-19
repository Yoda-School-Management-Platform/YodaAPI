package com.yoda.api.YodaAPI.repository;

import com.yoda.api.YodaAPI.model.School;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends Neo4jRepository<School,Long> {
}
