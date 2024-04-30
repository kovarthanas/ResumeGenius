package com.example.ResumeGenius.service;

import com.example.ResumeGenius.entity.Role;
import com.example.ResumeGenius.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService
{

    private  RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveUserRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllUserRole() {
        return roleRepository.findAll();
    }
    public Optional<Role> getUserRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }
    public Role updateUserRole(Long roleId, Role updatedRole) {
        Optional<Role> existingUserRole = roleRepository.findById(roleId);
        if (existingUserRole.isPresent()) {
            Role role = existingUserRole.get();


            return roleRepository.save(role);
        } else {
            throw new RuntimeException("UserRole not found");
        }
    }

    public void deleteUser(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}
