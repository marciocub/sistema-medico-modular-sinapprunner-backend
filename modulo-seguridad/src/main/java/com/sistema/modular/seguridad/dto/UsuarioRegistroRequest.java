package com.sistema.modular.seguridad.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRegistroRequest(
    @NotBlank String username,
    @NotBlank @Size(min = 6) String password,
    @NotNull Rol rol,
    String nombre,
    String apellido
) {}