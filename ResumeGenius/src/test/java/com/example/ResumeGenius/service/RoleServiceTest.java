package com.example.ResumeGenius.service;

import com.example.ResumeGenius.entity.Role;
import com.example.ResumeGenius.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    public void testSaveUserRole() {
        // Prepare test data
        Role role = new Role();
        when(roleRepository.save(role)).thenReturn(role);

        // Call the method under test
        Role savedRole = roleService.saveUserRole(role);

        // Verify the result
        assertEquals(role, savedRole);
        verify(roleRepository).save(role);
    }

    @Test
    public void testGetAllUserRole() {
        // Prepare test data
        Role role = new Role();
        when(roleRepository.findAll()).thenReturn(Collections.singletonList(role));

        // Call the method under test
        List<Role> roles = roleService.getAllUserRole();

        // Verify the result
        assertEquals(1, roles.size());
        assertEquals(role, roles.get(0));
        verify(roleRepository).findAll();
    }

    @Test
    public void testGetUserRoleById() {
        // Prepare test data
        Long roleId = 1L;
        Role role = new Role();
        when(roleRepository.findById(roleId)).thenReturn(Optional.of(role));

        // Call the method under test
        Optional<Role> result = roleService.getUserRoleById(roleId);

        // Verify the result
        assertEquals(Optional.of(role), result);
        verify(roleRepository).findById(roleId);
    }

    @Test
    public void testUpdateUserRole() {
        // Prepare test data
        Long roleId = 1L;
        Role existingRole = new Role();
        when(roleRepository.findById(roleId)).thenReturn(Optional.of(existingRole));
        when(roleRepository.save(existingRole)).thenReturn(existingRole);

        // Call the method under test
        Role updatedRole = roleService.updateUserRole(roleId, existingRole);

        // Verify the result
        assertEquals(existingRole, updatedRole);
        verify(roleRepository).findById(roleId);
        verify(roleRepository).save(existingRole);
    }

    @Test
    public void testDeleteUser() {
        // Prepare test data
        Long roleId = 1L;

        // Call the method under test
        roleService.deleteUser(roleId);

        // Verify the result
        verify(roleRepository).deleteById(roleId);
    }
}
