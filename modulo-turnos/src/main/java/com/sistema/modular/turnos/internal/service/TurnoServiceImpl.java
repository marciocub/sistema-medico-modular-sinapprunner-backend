package com.sistema.modular.turnos.internal.service;

import com.sistema.modular.turnos.*;
import com.sistema.modular.turnos.dto.*;
import com.sistema.modular.turnos.internal.entity.TurnoEntity;
import com.sistema.modular.turnos.internal.repository.TurnoRepository;
import com.sistema.modular.turnos.mapper.TurnoMapper;
import com.sistema.modular.pacientes.PacientesApi;
import com.sistema.modular.profesionales.ProfesionalesApi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurnoServiceImpl implements TurnosApi {

    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;
    private final PacientesApi pacientesApi;
    private final ProfesionalesApi profesionalesApi;

    public TurnoServiceImpl(TurnoRepository turnoRepository,
                            TurnoMapper turnoMapper,
                            PacientesApi pacientesApi,
                            ProfesionalesApi profesionalesApi) {
        this.turnoRepository = turnoRepository;
        this.turnoMapper = turnoMapper;
        this.pacientesApi = pacientesApi;
        this.profesionalesApi = profesionalesApi;
    }

    @Override
    @Transactional
    public TurnoResponse crearTurno(TurnoRequest request) {
        if (!pacientesApi.existePacienteActivo(request.pacienteId())) {
            throw new IllegalArgumentException("Paciente no existe o no esta activo: " + request.pacienteId());
        }
        if (!profesionalesApi.existeProfesionalActivo(request.profesionalId())) {
            throw new IllegalArgumentException("Profesional no existe o no esta activo: " + request.profesionalId());
        }

        // Validar disponibilidad del profesional
        if (!turnoRepository.findByProfesionalIdAndFechaHora(request.profesionalId(), request.fechaHora()).isEmpty()) {
            throw new IllegalArgumentException("El profesional no tiene disponibilidad en ese horario");
        }

        TurnoEntity entity = TurnoEntity.builder()
                .pacienteId(request.pacienteId())
                .profesionalId(request.profesionalId())
                .fechaHora(request.fechaHora())
                .motivo(request.motivo())
                .estado(EstadoTurno.PENDIENTE)
                .build();
        return turnoMapper.toResponse(turnoRepository.save(entity));
    }

    @Override
    public TurnoResponse obtenerTurnoPorId(Long id) {
        return turnoRepository.findById(id)
                .map(turnoMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado: " + id));
    }

    @Override
    public java.util.List<TurnoResponse> listarTurnosPorPaciente(Long pacienteId) {
        return turnoRepository.findAll().stream()
                .filter(t -> t.getPacienteId().equals(pacienteId))
                .map(turnoMapper::toResponse)
                .toList();
    }

    @Override
    public java.util.List<TurnoResponse> listarTurnos() {
        return turnoRepository.findAll().stream()
                .map(turnoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void cancelarTurno(Long id) {
        TurnoEntity turno = turnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado: " + id));
        turno.setEstado(EstadoTurno.CANCELADO);
        turnoRepository.save(turno);
    }
}