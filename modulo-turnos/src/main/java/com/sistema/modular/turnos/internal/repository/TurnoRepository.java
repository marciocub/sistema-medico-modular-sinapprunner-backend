package com.sistema.modular.turnos.internal.repository;

import com.sistema.modular.turnos.internal.entity.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {
    List<TurnoEntity> findByPacienteId(Long pacienteId);
    List<TurnoEntity> findByProfesionalIdAndFechaHora(Long profesionalId, LocalDateTime fechaHora);
}