package com.sistema.modular.seguridad.mapper;

import com.sistema.modular.seguridad.internal.entity.UsuarioEntity;
import com.sistema.modular.seguridad.dto.UsuarioResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponse toResponse(UsuarioEntity entity);
}