package com.sistema.modular.profesionales;

import com.sistema.modular.profesionales.dto.ProfesionalRequest;
import com.sistema.modular.profesionales.dto.ProfesionalResponse;
import com.sistema.modular.profesionales.dto.EspecialidadResponse;

public interface ProfesionalesApi {
    ProfesionalResponse crearProfesional(ProfesionalRequest request);
    ProfesionalResponse obtenerProfesionalPorId(Long id);
    boolean existeProfesionalActivo(Long id);
    boolean existeEspecialidad(String especialidad);
    java.util.List<ProfesionalResponse> listarProfesionales();
    java.util.List<EspecialidadResponse> listarEspecialidades();
}