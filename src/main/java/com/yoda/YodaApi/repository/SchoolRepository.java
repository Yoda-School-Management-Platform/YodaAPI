package com.yoda.YodaApi.repository;

import com.yoda.YodaApi.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
    School findSchoolByName(String name);

    Boolean existsByName(String name);

}
