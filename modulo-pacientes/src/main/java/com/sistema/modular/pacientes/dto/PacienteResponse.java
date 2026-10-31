package com.sistema.modular.pacientes.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PacienteResponse(
    Long id,
    Long usuarioId,
    String nombre,
    String apellido,
    String dni,
    LocalDate fechaNacimiento,
    String telefono,
    String direccion,
    boolean activo
) {}