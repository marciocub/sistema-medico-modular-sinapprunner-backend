package com.sistema.modular.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.modular.pacientes.PacientesApi;
import com.sistema.modular.pacientes.dto.PacienteRequest;
import com.sistema.modular.pacientes.dto.PacienteResponse;

@RestController
@RequestMapping("/api/pacientes")
public class PacientesController {

    private final PacientesApi pacientesApi;

    public PacientesController(PacientesApi pacientesApi) {
        this.pacientesApi = pacientesApi;
    }

    @PostMapping("/registro")
    public ResponseEntity<PacienteResponse> registro(@RequestBody PacienteRequest request) {
        return ResponseEntity.ok(pacientesApi.crearPaciente(request));
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listar() {
        return ResponseEntity.ok(pacientesApi.listarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(pacientesApi.obtenerPacientePorId(id));
    }
}