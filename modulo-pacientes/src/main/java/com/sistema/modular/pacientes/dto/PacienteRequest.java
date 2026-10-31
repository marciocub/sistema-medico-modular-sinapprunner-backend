package com.sistema.modular.pacientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

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