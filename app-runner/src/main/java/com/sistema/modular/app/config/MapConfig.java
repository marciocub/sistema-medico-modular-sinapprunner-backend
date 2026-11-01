package com.sistema.modular.app.config;

import com.sistema.modular.profesionales.mapper.EspecialidadMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapConfig {

    @Bean
    public EspecialidadMapper especialidadMapper() {
        return com.sistema.modular.profesionales.mapper.EspecialidadMapper.INSTANCE;
    }
}