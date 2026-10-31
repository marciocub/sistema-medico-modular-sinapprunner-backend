package com.sistema.modular.turnos.dto;

import java.time.LocalDateTime;

public record TurnoResponse(
    Long id,
    Long pacienteId,
    Long profesionalId,
    LocalDateTime fechaHora,
    String estado,
    String motivo,
    LocalDateTime createdAt
) {}