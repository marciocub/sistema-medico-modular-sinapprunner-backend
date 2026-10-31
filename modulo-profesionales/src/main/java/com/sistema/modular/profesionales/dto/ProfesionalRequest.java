package com.sistema.modular.profesionales.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfesionalRequest(
    @NotBlank String username,
    @NotBlank String password,
    @NotBlank String nombre,
    @NotBlank String apellido,
    @NotBlank String matricula,
    @NotBlank String especialidad
) {}