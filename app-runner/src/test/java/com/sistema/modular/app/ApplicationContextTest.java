package com.sistema.modular.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test de contexto de aplicación principal (app-runner).
 * Verifica que Spring Boot se inicia correctamente con todos los módulos cargados.
 */
@SpringBootTest(classes = com.sistema.modular.app.SistemaMedicoApplication.class)
class ApplicationContextTest {

    @Test
    void contextLoads() {
        // Verifica que el contexto de Spring se cargue sin errores
    }
}