package com.resume.genius.service;

import com.resume.genius.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getAllRoles();

    Optional<Role> getRoleById(String id);

    Role createRole(Role role);

    Role updateRole(String id, Role role);

    void deleteRole(String id);
}
