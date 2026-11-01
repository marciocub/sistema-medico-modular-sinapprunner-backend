package com.sistema.modular.profesionales.mapper;

import com.sistema.modular.profesionales.dto.EspecialidadResponse;
import com.sistema.modular.profesionales.internal.entity.EspecialidadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EspecialidadMapper {
    EspecialidadMapper INSTANCE = Mappers.getMapper(EspecialidadMapper.class);

    EspecialidadResponse toResponse(EspecialidadEntity entity);
}
