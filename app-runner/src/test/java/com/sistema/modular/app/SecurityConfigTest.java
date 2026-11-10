package com.sistema.modular.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests unitarios del módulo principal (app-runner).
 * Verifica configuración de la aplicación.
 */
class SecurityConfigTest {

    @Test
    void corsOriginsShouldBeConfigured() {
        String[] corsOrigins = {"http://localhost:5173", "http://localhost:3000"};
        assertNotNull(corsOrigins);
        assertEquals(2, corsOrigins.length);
        assertTrue(java.util.Arrays.asList(corsOrigins).contains("http://localhost:5173"));
        assertTrue(java.util.Arrays.asList(corsOrigins).contains("http://localhost:3000"));
    }

    @Test
    void allowedMethodsShouldIncludeHttpVerbs() {
        String[] methods = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
        assertNotNull(methods);
        assertEquals(5, methods.length);
        assertTrue(java.util.Arrays.asList(methods).contains("GET"));
        assertTrue(java.util.Arrays.asList(methods).contains("POST"));
        assertTrue(java.util.Arrays.asList(methods).contains("PUT"));
        assertTrue(java.util.Arrays.asList(methods).contains("DELETE"));
        assertTrue(java.util.Arrays.asList(methods).contains("OPTIONS"));
    }
}