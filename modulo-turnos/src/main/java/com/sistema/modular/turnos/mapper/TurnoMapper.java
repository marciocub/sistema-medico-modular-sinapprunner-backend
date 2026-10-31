package com.sistema.modular.turnos.mapper;

import com.sistema.modular.turnos.internal.entity.TurnoEntity;
import com.sistema.modular.turnos.dto.TurnoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TurnoMapper {
    TurnoResponse toResponse(TurnoEntity entity);
}