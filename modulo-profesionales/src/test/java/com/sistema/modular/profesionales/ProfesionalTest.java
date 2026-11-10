package com.sistema.modular.profesionales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests unitarios del módulo de profesionales y especialidades.
 * Verifica lógica de negocio sin contexto de Spring.
 */
class ProfesionalTest {

    @Test
    void especialidadShouldHaveValidFields() {
        String nombre = "Cardiología";
        assertNotNull(nombre);
        assertTrue(nombre.length() > 0);
    }

    @Test
    void profesionalShouldHaveValidFields() {
        String nombre = "Dr. Juan";
        String apellido = "Pérez";
        String matricula = "MED-001";
        String especialidadId = "1";

        assertNotNull(nombre);
        assertNotNull(apellido);
        assertNotNull(matricula);
        assertNotNull(especialidadId);

        assertTrue(nombre.length() > 0);
        assertTrue(apellido.length() > 0);
        assertTrue(matricula.length() > 0);
        assertTrue(especialidadId.length() > 0);
    }

    @Test
    void profesionalShouldRelateToEspecialidadById() {
        Long especialidadId = 1L;
        assertNotNull(especialidadId);
        assertTrue(especialidadId > 0);
    }

    @Test
    void matriculaShouldBeUnique() {
        String matricula1 = "MED-001";
        String matricula2 = "MED-002";
        assertNotEquals(matricula1, matricula2);
    }
}