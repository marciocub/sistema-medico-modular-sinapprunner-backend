package com.sistema.modular.turnos.util;

import com.sistema.modular.turnos.dto.TurnoResponse;
import com.sistema.modular.turnos.internal.entity.TurnoEntity;

public class TurnoMapperUtil {

    public static TurnoResponse toResponse(TurnoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new TurnoResponse(
            entity.getId(),
            entity.getPacienteId(),
            entity.getProfesionalId(),
            entity.getFechaHora(),
            entity.getEstado().toString(),
            entity.getMotivo(),
            entity.getCreatedAt()
        );
    }
}