package com.sistema.modular.turnos.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public enum EstadoTurno {
    PENDIENTE, CONFIRMADO, CANCELADO, COMPLETADO
}