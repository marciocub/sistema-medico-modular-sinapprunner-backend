package com.sistema.modular.profesionales;

import com.sistema.modular.profesionales.dto.EspecialidadRequest;
import com.sistema.modular.profesionales.dto.EspecialidadResponse;
import java.util.List;

public interface EspecialidadesApi {
    EspecialidadResponse crearEspecialidad(EspecialidadRequest request);
    EspecialidadResponse obtenerEspecialidadPorId(Long id);
    EspecialidadResponse actualizarEspecialidad(Long id, EspecialidadRequest request);
    void eliminarEspecialidad(Long id);
    List<EspecialidadResponse> listarEspecialidades();
    boolean existeEspecialidad(String nombre);
}
