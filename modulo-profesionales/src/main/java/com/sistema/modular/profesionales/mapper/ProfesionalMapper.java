package com.sistema.modular.profesionales.mapper;

import com.sistema.modular.profesionales.internal.entity.ProfesionalEntity;
import com.sistema.modular.profesionales.dto.ProfesionalResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesionalMapper {
    ProfesionalResponse toResponse(ProfesionalEntity entity);
}