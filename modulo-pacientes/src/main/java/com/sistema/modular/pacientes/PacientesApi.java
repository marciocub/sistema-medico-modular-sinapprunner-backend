package com.sistema.modular.pacientes;

import com.sistema.modular.pacientes.dto.PacienteRequest;
import com.sistema.modular.pacientes.dto.PacienteResponse;

public interface PacientesApi {
    PacienteResponse crearPaciente(PacienteRequest request);
    PacienteResponse obtenerPacientePorId(Long id);
    boolean existePacienteActivo(Long id);
    java.util.List<PacienteResponse> listarPacientes();
}