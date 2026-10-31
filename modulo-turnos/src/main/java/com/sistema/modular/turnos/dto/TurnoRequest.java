package com.sistema.modular.turnos.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record TurnoRequest(
    @NotNull Long pacienteId,
    @NotNull Long profesionalId,
    @NotNull LocalDateTime fechaHora,
    String motivo
) {}