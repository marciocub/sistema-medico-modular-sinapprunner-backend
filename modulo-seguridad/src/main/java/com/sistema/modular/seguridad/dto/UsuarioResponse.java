package com.sistema.modular.seguridad.dto;

import java.time.LocalDateTime;

public record UsuarioResponse(
    Long id,
    String username,
    Rol rol,
    boolean enabled,
    LocalDateTime createdAt
) {}