package com.example.ResumeGenius.controller;


import com.example.ResumeGenius.entity.Role;
import com.example.ResumeGenius.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RoleController {
    private  RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/userRole")
    public ResponseEntity<Role> saveUserRole(@RequestBody Role role) {
        Role newRole = roleService.saveUserRole(role);
        return ResponseEntity.ok(newRole);
    }

    @GetMapping("/userRoles")
    public List<Role> getAllUserRole() {
        return roleService.getAllUserRole();
    }


    @GetMapping("/userRoles/{roleId}")
    public ResponseEntity<Role> getUserById(@PathVariable Long roleId) {
        Optional<Role> userRole = roleService.getUserRoleById(roleId);
        return userRole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/userRoles/{roleId}")
    public ResponseEntity<Role> updateUserRole(@PathVariable Long roleId, @RequestBody Role role) {
        Role updatedRole = roleService.updateUserRole(roleId, role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/userRoles/{roleId}")
    public ResponseEntity<String> deleteUserRole(@PathVariable Long roleId) {
        roleService.deleteUser(roleId);
        return ResponseEntity.ok("User Role deleted successfully");
    }
}
