package com.sistema.modular.seguridad.dto;

public record LoginRequest(
    String username,
    String password
) {}