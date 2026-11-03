package com.sistema.modular.pacientes.internal.service;

import com.sistema.modular.pacientes.*;
import com.sistema.modular.pacientes.dto.*;
import com.sistema.modular.pacientes.internal.entity.PacienteEntity;
import com.sistema.modular.pacientes.internal.repository.PacienteRepository;
import com.sistema.modular.pacientes.util.PacienteMapperUtil;
import com.sistema.modular.seguridad.SeguridadApi;
import com.sistema.modular.seguridad.dto.Rol;
import com.sistema.modular.seguridad.dto.UsuarioRegistroRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteServiceImpl implements PacientesApi {

    private final PacienteRepository pacienteRepository;
    private final SeguridadApi seguridadApi;

    public PacienteServiceImpl(PacienteRepository pacienteRepository,
                               SeguridadApi seguridadApi) {
        this.pacienteRepository = pacienteRepository;
        this.seguridadApi = seguridadApi;
    }

    @Override
    @Transactional
    public PacienteResponse crearPaciente(PacienteRequest request) {
        com.sistema.modular.seguridad.dto.UsuarioResponse usuario = seguridadApi.registrarUsuario(
                new UsuarioRegistroRequest(request.username(), request.password(), Rol.PACIENTE, request.nombre(), request.apellido()));

        PacienteEntity entity = PacienteEntity.builder()
                .usuarioId(usuario.id())
                .nombre(request.nombre())
                .apellido(request.apellido())
                .dni(request.dni())
                .fechaNacimiento(request.fechaNacimiento())
                .telefono(request.telefono())
                .direccion(request.direccion())
                .activo(true)
                .build();
        return PacienteMapperUtil.toResponse(pacienteRepository.save(entity));
    }

    @Override
    public PacienteResponse obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id)
                .map(PacienteMapperUtil::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado: " + id));
    }

    @Override
    public boolean existePacienteActivo(Long id) {
        return pacienteRepository.findById(id)
                .map(PacienteEntity::isActivo)
                .orElse(false);
    }

    @Override
    public java.util.List<PacienteResponse> listarPacientes() {
        return pacienteRepository.findAll().stream()
                .map(PacienteMapperUtil::toResponse)
                .toList();
    }
}