package com.sistema.modular.profesionales.dto;

import jakarta.validation.constraints.NotBlank;

public record ProfesionalRequest(
    @NotBlank String username,
    @NotBlank String password,
    @NotBlank String nombre,
    @NotBlank String apellido,
    @NotBlank String matricula,
    @NotBlank String especialidad
) {}