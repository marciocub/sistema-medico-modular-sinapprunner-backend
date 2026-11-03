package com.sistema.modular.pacientes.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record PacienteRequest(
    @NotBlank String username,
    @NotBlank String password,
    @NotBlank String nombre,
    @NotBlank String apellido,
    @NotBlank String dni,
    LocalDate fechaNacimiento,
    String telefono,
    String direccion
) {}