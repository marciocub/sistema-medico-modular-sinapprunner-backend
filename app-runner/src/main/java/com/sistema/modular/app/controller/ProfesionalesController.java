package com.sistema.modular.app.controller;

import com.sistema.modular.profesionales.EspecialidadesApi;
import com.sistema.modular.profesionales.ProfesionalesApi;
import com.sistema.modular.profesionales.dto.EspecialidadRequest;
import com.sistema.modular.profesionales.dto.EspecialidadResponse;
import com.sistema.modular.profesionales.dto.ProfesionalRequest;
import com.sistema.modular.profesionales.dto.ProfesionalResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfesionalesController {

    private final ProfesionalesApi profesionalesApi;
    private final EspecialidadesApi especialidadesApi;

    public ProfesionalesController(ProfesionalesApi profesionalesApi,
                                   EspecialidadesApi especialidadesApi) {
        this.profesionalesApi = profesionalesApi;
        this.especialidadesApi = especialidadesApi;
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
        return ResponseEntity.ok(especialidadesApi.listarEspecialidades());
    }

    @PostMapping("/especialidades")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EspecialidadResponse> crearEspecialidad(@RequestBody EspecialidadRequest request) {
        return ResponseEntity.ok(especialidadesApi.crearEspecialidad(request));
    }

    @PutMapping("/especialidades/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EspecialidadResponse> actualizarEspecialidad(@PathVariable Long id, @RequestBody EspecialidadRequest request) {
        return ResponseEntity.ok(especialidadesApi.actualizarEspecialidad(id, request));
    }

    @DeleteMapping("/especialidades/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminarEspecialidad(@PathVariable Long id) {
        especialidadesApi.eliminarEspecialidad(id);
        return ResponseEntity.noContent().build();
    }
}