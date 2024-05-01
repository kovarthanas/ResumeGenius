package com.example.ResumeGenius.controller;

import com.example.ResumeGenius.controller.RoleController;
import com.example.ResumeGenius.entity.Role;
import com.example.ResumeGenius.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoleControllerTest {

    @Mock
    private RoleService roleService;

    @InjectMocks
    private RoleController roleController;

    private Role testRole;

    @Before
    public void setup() {
        testRole = new Role();
        // Initialize testRole as needed
    }

    @Test
    public void testSaveUserRole() {
        when(roleService.saveUserRole(testRole)).thenReturn(testRole);

        ResponseEntity<Role> responseEntity = roleController.saveUserRole(testRole);

        assertEquals(testRole, responseEntity.getBody());
    }

    @Test
    public void testGetAllUserRole() {
        List<Role> roleList = new ArrayList<>();
        roleList.add(testRole);

        when(roleService.getAllUserRole()).thenReturn(roleList);

        List<Role> returnedRoles = roleController.getAllUserRole();

        assertEquals(roleList, returnedRoles);
    }

    @Test
    public void testGetUserRoleById() {
        Long roleId = 1L;

        when(roleService.getUserRoleById(roleId)).thenReturn(Optional.of(testRole));

        ResponseEntity<Role> responseEntity = roleController.getUserById(roleId);

        assertEquals(testRole, responseEntity.getBody());
    }

    @Test
    public void testUpdateUserRole() {
        Long roleId = 1L;

        when(roleService.updateUserRole(roleId, testRole)).thenReturn(testRole);

        ResponseEntity<Role> responseEntity = roleController.updateUserRole(roleId, testRole);

        assertEquals(testRole, responseEntity.getBody());
    }

    @Test
    public void testDeleteUserRole() {
        Long roleId = 1L;

        ResponseEntity<String> responseEntity = roleController.deleteUserRole(roleId);

        assertEquals("User Role deleted successfully", responseEntity.getBody());
        verify(roleService, times(1)).deleteUser(roleId);
    }
}
