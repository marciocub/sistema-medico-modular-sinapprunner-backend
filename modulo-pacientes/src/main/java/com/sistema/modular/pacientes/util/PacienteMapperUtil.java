package com.sistema.modular.pacientes.util;

import com.sistema.modular.pacientes.dto.PacienteResponse;
import com.sistema.modular.pacientes.internal.entity.PacienteEntity;

public class PacienteMapperUtil {

    public static PacienteResponse toResponse(PacienteEntity entity) {
        if (entity == null) {
            return null;
        }
        return new PacienteResponse(
            entity.getId(),
            entity.getUsuarioId(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getDni(),
            entity.getFechaNacimiento(),
            entity.getTelefono(),
            entity.getDireccion(),
            entity.isActivo()
        );
    }
}