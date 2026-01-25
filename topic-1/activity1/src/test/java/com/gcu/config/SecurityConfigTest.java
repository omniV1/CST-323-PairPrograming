package com.gcu.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Unit tests for SecurityConfig.
 * Tests BCrypt password encoding behavior.
 */
public class SecurityConfigTest {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testPasswordEncoderNotNull() {
        SecurityConfig config = new SecurityConfig();
        assertNotNull(config.passwordEncoder());
    }

    @Test
    public void testPasswordEncoderReturnsBCrypt() {
        SecurityConfig config = new SecurityConfig();
        PasswordEncoder encoder = config.passwordEncoder();
        assertTrue(encoder instanceof BCryptPasswordEncoder);
    }

    @Test
    public void testPasswordEncoding() {
        String rawPassword = "mySecurePassword123";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        // Encoded password should be different from raw
        assertNotEquals(rawPassword, encodedPassword);
        // Encoded password should start with BCrypt identifier
        assertTrue(encodedPassword.startsWith("$2a$") || encodedPassword.startsWith("$2b$"));
    }

    @Test
    public void testPasswordMatches() {
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        // Password should match when verified
        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
    }

    @Test
    public void testPasswordDoesNotMatchWrongPassword() {
        String rawPassword = "correctPassword";
        String wrongPassword = "wrongPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        // Wrong password should not match
        assertFalse(passwordEncoder.matches(wrongPassword, encodedPassword));
    }

    @Test
    public void testDifferentEncodingsForSamePassword() {
        String password = "samePassword";
        String encoded1 = passwordEncoder.encode(password);
        String encoded2 = passwordEncoder.encode(password);
        
        // Each encoding should be different (due to random salt)
        assertNotEquals(encoded1, encoded2);
        // But both should still match the original password
        assertTrue(passwordEncoder.matches(password, encoded1));
        assertTrue(passwordEncoder.matches(password, encoded2));
    }
}
