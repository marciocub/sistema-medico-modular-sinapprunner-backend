package com.sistema.modular.app.controller;

import com.sistema.modular.turnos.TurnosApi;
import com.sistema.modular.turnos.dto.TurnoRequest;
import com.sistema.modular.turnos.dto.TurnoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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