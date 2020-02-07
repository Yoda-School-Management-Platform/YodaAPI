package com.yoda.YodaApi.repository;

import com.yoda.YodaApi.models.ERole;
import com.yoda.YodaApi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
