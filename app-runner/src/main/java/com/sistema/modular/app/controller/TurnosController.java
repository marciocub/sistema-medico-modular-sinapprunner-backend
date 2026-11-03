package com.sistema.modular.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.modular.turnos.TurnosApi;
import com.sistema.modular.turnos.dto.TurnoRequest;
import com.sistema.modular.turnos.dto.TurnoResponse;

@RestController
@RequestMapping("/api/turnos")
public class TurnosController {

    private final TurnosApi turnosApi;

    public TurnosController(TurnosApi turnosApi) {
        this.turnosApi = turnosApi;
    }

    @PostMapping
    public ResponseEntity<TurnoResponse> crearTurno(@RequestBody TurnoRequest request) {
        return ResponseEntity.ok(turnosApi.crearTurno(request));
    }

    @GetMapping
    public ResponseEntity<List<TurnoResponse>> listarTurnos() {
        return ResponseEntity.ok(turnosApi.listarTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponse> obtenerTurno(@PathVariable Long id) {
        return ResponseEntity.ok(turnosApi.obtenerTurnoPorId(id));
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TurnoResponse>> listarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(turnosApi.listarTurnosPorPaciente(pacienteId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarTurno(@PathVariable Long id) {
        turnosApi.cancelarTurno(id);
        return ResponseEntity.noContent().build();
    }
}