package com.sistema.modular.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.sistema.modular.app",
    "com.sistema.modular.seguridad",
    "com.sistema.modular.pacientes",
    "com.sistema.modular.profesionales",
    "com.sistema.modular.turnos"
})
public class SistemaMedicoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaMedicoApplication.class, args);
    }
}