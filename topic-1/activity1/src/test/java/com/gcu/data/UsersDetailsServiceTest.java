package com.gcu.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gcu.models.UserEntity;

/**
 * Unit tests for UsersDetailsService.
 * Tests Spring Security UserDetailsService implementation with mocked repository.
 */
@ExtendWith(MockitoExtension.class)
public class UsersDetailsServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersDetailsService usersDetailsService;

    private UserEntity testUser;

    @BeforeEach
    public void setUp() {
        testUser = new UserEntity(1, "testuser", "encodedPassword", "ROLE_USER", true);
    }

    @Test
    public void testLoadUserByUsername_UserFound() {
        // Arrange
        when(usersRepository.findByUsername("testuser")).thenReturn(testUser);

        // Act
        UserDetails userDetails = usersDetailsService.loadUserByUsername("testuser");

        // Assert
        assertNotNull(userDetails);
        assertEquals("testuser", userDetails.getUsername());
        assertEquals("encodedPassword", userDetails.getPassword());
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER")));
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Arrange
        when(usersRepository.findByUsername("nonexistent")).thenReturn(null);

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            usersDetailsService.loadUserByUsername("nonexistent");
        });
    }

    @Test
    public void testLoadUserByUsername_AdminRole() {
        // Arrange
        UserEntity adminUser = new UserEntity(2, "admin", "adminPass", "ROLE_ADMIN", true);
        when(usersRepository.findByUsername("admin")).thenReturn(adminUser);

        // Act
        UserDetails userDetails = usersDetailsService.loadUserByUsername("admin");

        // Assert
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
    }

    @Test
    public void testLoadUserByUsername_DisabledUser() {
        // Arrange
        UserEntity disabledUser = new UserEntity(3, "disabled", "pass", "ROLE_USER", false);
        when(usersRepository.findByUsername("disabled")).thenReturn(disabledUser);

        // Act
        UserDetails userDetails = usersDetailsService.loadUserByUsername("disabled");

        // Assert
        assertFalse(userDetails.isEnabled());
    }

    @Test
    public void testRepositoryCalledWithCorrectUsername() {
        // Arrange
        when(usersRepository.findByUsername("specificuser")).thenReturn(testUser);

        // Act
        usersDetailsService.loadUserByUsername("specificuser");

        // Assert - verify repository was called with exact username
        verify(usersRepository, times(1)).findByUsername("specificuser");
    }
}
