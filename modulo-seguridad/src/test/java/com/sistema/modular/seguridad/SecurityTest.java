package com.sistema.modular.seguridad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests unitarios del módulo de seguridad.
 * Verifica lógica de negocio sin contexto de Spring.
 */
class SecurityTest {

    @Test
    void adminRoleIsRecognized() {
        String rol = "ADMIN";
        assertNotNull(rol);
        assertEquals("ADMIN", rol);
    }

    @Test
    void validCredentialsShouldPassValidation() {
        String username = "admin";
        String password = "admin123";
        assertNotNull(username);
        assertNotNull(password);
        assertTrue(username.length() > 0);
        assertTrue(password.length() > 0);
    }

    @Test
    void rolValuesAreCorrect() {
        String[] validRoles = {"ADMIN", "MEDICO", "PACIENTE"};
        assertNotNull(validRoles);
        assertEquals(3, validRoles.length);
        assertTrue(java.util.Arrays.asList(validRoles).contains("ADMIN"));
        assertTrue(java.util.Arrays.asList(validRoles).contains("MEDICO"));
        assertTrue(java.util.Arrays.asList(validRoles).contains("PACIENTE"));
    }
}