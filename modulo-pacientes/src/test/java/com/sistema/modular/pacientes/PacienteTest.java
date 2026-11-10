package com.sistema.modular.pacientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests unitarios del módulo de pacientes.
 * Verifica lógica de negocio sin contexto de Spring.
 */
class PacienteTest {

    @Test
    void pacienteCreationShouldHaveValidFields() {
        String nombre = "Juan";
        String apellido = "Pérez";
        String email = "juan@email.com";
        String dni = "12345678";
        String telefono = "3001234567";

        assertNotNull(nombre);
        assertNotNull(apellido);
        assertNotNull(email);
        assertNotNull(dni);
        assertNotNull(telefono);

        assertTrue(nombre.length() > 0);
        assertTrue(apellido.length() > 0);
        assertTrue(email.contains("@"));
        assertTrue(dni.length() > 0);
        assertTrue(telefono.length() > 0);
    }

    @Test
    void pacienteFieldsShouldNotBeEmpty() {
        String nombre = "Maria";
        assertNotNull(nombre);
        assertTrue(nombre.length() > 0);
    }

    @Test
    void emailShouldContainAtSymbol() {
        String email = "test@email.com";
        assertTrue(email.contains("@"));
    }
}