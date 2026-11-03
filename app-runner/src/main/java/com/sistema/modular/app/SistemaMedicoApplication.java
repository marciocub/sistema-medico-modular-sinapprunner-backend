package com.sistema.modular.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.sistema.modular.app",
    "com.sistema.modular.seguridad",
    "com.sistema.modular.pacientes",
    "com.sistema.modular.profesionales",
    "com.sistema.modular.turnos"
})
@EnableJpaRepositories(basePackages = {
    "com.sistema.modular.seguridad.internal.repository",
    "com.sistema.modular.pacientes.internal.repository",
    "com.sistema.modular.profesionales.internal.repository",
    "com.sistema.modular.turnos.internal.repository"
})
@EntityScan(basePackages = {
    "com.sistema.modular.seguridad.internal.entity",
    "com.sistema.modular.pacientes.internal.entity",
    "com.sistema.modular.profesionales.internal.entity",
    "com.sistema.modular.turnos.internal.entity"
})
public class SistemaMedicoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaMedicoApplication.class, args);
    }
}