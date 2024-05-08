package com.resume.genius.service.impl;

import com.resume.genius.entity.Role;
import com.resume.genius.repo.RoleRepository;
import com.resume.genius.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(String id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(String id, Role role) {
        if (roleRepository.existsById(id)) {
            role.setId(id);
            return roleRepository.save(role);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}
