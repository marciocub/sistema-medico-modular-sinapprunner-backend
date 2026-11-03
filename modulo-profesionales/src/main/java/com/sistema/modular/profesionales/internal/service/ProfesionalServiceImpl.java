package com.sistema.modular.profesionales.internal.service;

import com.sistema.modular.profesionales.*;
import com.sistema.modular.profesionales.dto.*;
import com.sistema.modular.profesionales.internal.entity.ProfesionalEntity;
import com.sistema.modular.profesionales.internal.repository.ProfesionalRepository;
import com.sistema.modular.profesionales.util.ProfesionalMapperUtil;
import com.sistema.modular.seguridad.SeguridadApi;
import com.sistema.modular.seguridad.dto.Rol;
import com.sistema.modular.seguridad.dto.UsuarioRegistroRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesionalServiceImpl implements ProfesionalesApi {

    private final ProfesionalRepository profesionalRepository;
    private final SeguridadApi seguridadApi;

    public ProfesionalServiceImpl(ProfesionalRepository profesionalRepository,
                                  SeguridadApi seguridadApi) {
        this.profesionalRepository = profesionalRepository;
        this.seguridadApi = seguridadApi;
    }

    @Override
    @Transactional
    public ProfesionalResponse crearProfesional(ProfesionalRequest request) {
        com.sistema.modular.seguridad.dto.UsuarioResponse usuario = seguridadApi.registrarUsuario(
                new UsuarioRegistroRequest(request.username(), request.password(), Rol.MEDICO, request.nombre(), request.apellido()));

        ProfesionalEntity entity = ProfesionalEntity.builder()
                .usuarioId(usuario.id())
                .nombre(request.nombre())
                .apellido(request.apellido())
                .matricula(request.matricula())
                .especialidad(request.especialidad())
                .activo(true)
                .build();
        return ProfesionalMapperUtil.toResponse(profesionalRepository.save(entity));
    }

    @Override
    public ProfesionalResponse obtenerProfesionalPorId(Long id) {
        return profesionalRepository.findById(id)
                .map(ProfesionalMapperUtil::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Profesional no encontrado: " + id));
    }

    @Override
    public boolean existeProfesionalActivo(Long id) {
        return profesionalRepository.findById(id)
                .map(ProfesionalEntity::isActivo)
                .orElse(false);
    }

    @Override
    public boolean existeEspecialidad(String especialidad) {
        return profesionalRepository.findAll().stream()
                .anyMatch(p -> p.getEspecialidad().equalsIgnoreCase(especialidad));
    }

    @Override
    public java.util.List<ProfesionalResponse> listarProfesionales() {
        return profesionalRepository.findAll().stream()
                .map(ProfesionalMapperUtil::toResponse)
                .toList();
    }

    @Override
    public java.util.List<EspecialidadResponse> listarEspecialidades() {
        return profesionalRepository.findAll().stream()
                .map(p -> new EspecialidadResponse(null, p.getEspecialidad()))
                .distinct()
                .toList();
    }
}