package com.yoda.YodaApi.repository;

import com.yoda.YodaApi.models.School;
import com.yoda.YodaApi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndSchool(String username, School school);

	Boolean existsByUsername(String username);

	Boolean existsByUsernameAndSchool(String username, School school);

	Boolean existsByEmail(String email);
}
