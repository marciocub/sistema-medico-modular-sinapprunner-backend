package com.sistema.modular.pacientes.mapper;

import com.sistema.modular.pacientes.internal.entity.PacienteEntity;
import com.sistema.modular.pacientes.dto.PacienteResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteResponse toResponse(PacienteEntity entity);
}