package com.sistema.modular.app.config;

import com.sistema.modular.profesionales.internal.entity.EspecialidadEntity;
import com.sistema.modular.profesionales.internal.repository.EspecialidadRepository;
import com.sistema.modular.seguridad.dto.Rol;
import com.sistema.modular.seguridad.internal.entity.UsuarioEntity;
import com.sistema.modular.seguridad.internal.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initAdminUser(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            if (!usuarioRepository.existsByUsername("admin")) {
                UsuarioEntity admin = UsuarioEntity.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .rol(Rol.ADMIN)
                        .enabled(true)
                        .build();
                usuarioRepository.save(admin);
                System.out.println(">>> Usuario admin creado: username=admin, password=admin123");
            }
        };
    }

    @Bean
    CommandLineRunner initEspecialidades(EspecialidadRepository especialidadRepository) {
        return args -> {
            String[] especialidadesDefault = {"Cardiología", "Pediatría", "Traumatología", "Dermatología", "Neurología", "Ginecología", "Oftalmología"};
            for (String nombre : especialidadesDefault) {
                if (!especialidadRepository.existsByNombreIgnoreCase(nombre)) {
                    especialidadRepository.save(EspecialidadEntity.builder()
                            .nombre(nombre)
                            .activo(true)
                            .build());
                    System.out.println(">>> Especialidad creada: " + nombre);
                }
            }
        };
    }
}

