package com.sistema.modular.seguridad.dto;

public record AuthResponse(
    String token,
    String username,
    String rol
) {}