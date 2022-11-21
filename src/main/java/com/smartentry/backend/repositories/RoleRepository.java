package com.smartentry.backend.repositories;

import com.smartentry.backend.domain.Role;
import com.smartentry.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
