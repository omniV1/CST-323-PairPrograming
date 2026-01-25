package com.gcu.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for UserEntity model class.
 * Tests all getters, setters, and constructors.
 */
public class UserEntityTest {

    @Test
    public void testDefaultConstructor() {
        UserEntity user = new UserEntity();
        assertNotNull(user);
    }

    @Test
    public void testParameterizedConstructor() {
        UserEntity user = new UserEntity(1, "testuser", "password123", "ROLE_USER", true);
        
        assertEquals(1, user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
        assertTrue(user.isEnabled());
    }

    @Test
    public void testSettersAndGetters() {
        UserEntity user = new UserEntity();
        
        user.setId(5);
        user.setUsername("newuser");
        user.setPassword("securepass");
        user.setRole("ROLE_ADMIN");
        user.setEnabled(false);
        
        assertEquals(5, user.getId());
        assertEquals("newuser", user.getUsername());
        assertEquals("securepass", user.getPassword());
        assertEquals("ROLE_ADMIN", user.getRole());
        assertFalse(user.isEnabled());
    }

    @Test
    public void testEnabledFlagToggle() {
        UserEntity user = new UserEntity();
        
        user.setEnabled(true);
        assertTrue(user.isEnabled());
        
        user.setEnabled(false);
        assertFalse(user.isEnabled());
    }

    @Test
    public void testRoleAssignment() {
        UserEntity user = new UserEntity();
        
        user.setRole("ROLE_USER");
        assertEquals("ROLE_USER", user.getRole());
        
        user.setRole("ROLE_ADMIN");
        assertEquals("ROLE_ADMIN", user.getRole());
    }
}
