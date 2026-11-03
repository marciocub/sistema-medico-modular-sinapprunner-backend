package com.sistema.modular.profesionales.internal.service;

import com.sistema.modular.profesionales.EspecialidadesApi;
import com.sistema.modular.profesionales.dto.EspecialidadRequest;
import com.sistema.modular.profesionales.dto.EspecialidadResponse;
import com.sistema.modular.profesionales.internal.entity.EspecialidadEntity;
import com.sistema.modular.profesionales.internal.repository.EspecialidadRepository;
import com.sistema.modular.profesionales.util.EspecialidadMapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadesApi {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    @Transactional
    public EspecialidadResponse crearEspecialidad(EspecialidadRequest request) {
        if (especialidadRepository.existsByNombreIgnoreCase(request.nombre())) {
            throw new IllegalArgumentException("La especialidad ya existe: " + request.nombre());
        }
        EspecialidadEntity entity = EspecialidadEntity.builder()
                .nombre(request.nombre().trim())
                .activo(true)
                .build();
        return EspecialidadMapperUtil.toResponse(especialidadRepository.save(entity));
    }

    @Override
    public EspecialidadResponse obtenerEspecialidadPorId(Long id) {
        return especialidadRepository.findById(id)
                .map(EspecialidadMapperUtil::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada: " + id));
    }

    @Override
    @Transactional
    public EspecialidadResponse actualizarEspecialidad(Long id, EspecialidadRequest request) {
        EspecialidadEntity entity = especialidadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada: " + id));
        entity.setNombre(request.nombre().trim());
        return EspecialidadMapperUtil.toResponse(especialidadRepository.save(entity));
    }

    @Override
    @Transactional
    public void eliminarEspecialidad(Long id) {
        if (!especialidadRepository.existsById(id)) {
            throw new IllegalArgumentException("Especialidad no encontrada: " + id);
        }
        especialidadRepository.deleteById(id);
    }

    @Override
    public List<EspecialidadResponse> listarEspecialidades() {
        return especialidadRepository.findAll().stream()
                .map(EspecialidadMapperUtil::toResponse)
                .toList();
    }

    @Override
    public boolean existeEspecialidad(String nombre) {
        return especialidadRepository.existsByNombreIgnoreCase(nombre);
    }
}
