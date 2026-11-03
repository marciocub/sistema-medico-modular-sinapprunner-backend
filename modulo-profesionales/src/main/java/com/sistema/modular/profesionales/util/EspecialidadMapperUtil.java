package com.sistema.modular.profesionales.util;

import com.sistema.modular.profesionales.dto.EspecialidadResponse;
import com.sistema.modular.profesionales.internal.entity.EspecialidadEntity;

public class EspecialidadMapperUtil {

    public static EspecialidadResponse toResponse(EspecialidadEntity entity) {
        if (entity == null) {
            return null;
        }
        return new EspecialidadResponse(
            entity.getId(),
            entity.getNombre()
        );
    }
}