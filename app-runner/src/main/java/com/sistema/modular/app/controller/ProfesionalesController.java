package com.sistema.modular.app.controller;

import com.sistema.modular.profesionales.ProfesionalesApi;
import com.sistema.modular.profesionales.dto.ProfesionalRequest;
import com.sistema.modular.profesionales.dto.ProfesionalResponse;
import com.sistema.modular.profesionales.dto.EspecialidadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfesionalesController {

    private final ProfesionalesApi profesionalesApi;

    public ProfesionalesController(ProfesionalesApi profesionalesApi) {
        this.profesionalesApi = profesionalesApi;
    }

    @PostMapping("/medicos")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProfesionalResponse> crearMedico(@RequestBody ProfesionalRequest request) {
        return ResponseEntity.ok(profesionalesApi.crearProfesional(request));
    }

    @GetMapping("/profesionales")
    public ResponseEntity<List<ProfesionalResponse>> listarProfesionales() {
        return ResponseEntity.ok(profesionalesApi.listarProfesionales());
    }

    @GetMapping("/profesionales/{id}")
    public ResponseEntity<ProfesionalResponse> obtenerProfesional(@PathVariable Long id) {
        return ResponseEntity.ok(profesionalesApi.obtenerProfesionalPorId(id));
    }

    @GetMapping("/especialidades")
    public ResponseEntity<List<EspecialidadResponse>> listarEspecialidades() {
        return ResponseEntity.ok(profesionalesApi.listarEspecialidades());
    }
}