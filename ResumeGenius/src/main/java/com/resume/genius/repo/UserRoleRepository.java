package com.resume.genius.repo;

import com.resume.genius.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}