package com.sistema.modular.seguridad.internal.service;

import com.sistema.modular.seguridad.*;
import com.sistema.modular.seguridad.dto.*;
import com.sistema.modular.seguridad.internal.entity.UsuarioEntity;
import com.sistema.modular.seguridad.internal.repository.UsuarioRepository;
import com.sistema.modular.seguridad.mapper.UsuarioMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements SeguridadApi {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              UsuarioMapper usuarioMapper,
                              BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UsuarioResponse registrarUsuario(UsuarioRegistroRequest request) {
        if (usuarioRepository.existsByUsername(request.username())) {
            throw new IllegalArgumentException("El usuario ya existe: " + request.username());
        }
        UsuarioEntity entity = UsuarioEntity.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .rol(request.rol())
                .enabled(true)
                .build();
        return usuarioMapper.toResponse(usuarioRepository.save(entity));
    }

    @Override
    public AuthResponse autenticar(LoginRequest request) {
        UsuarioEntity usuario = usuarioRepository.findByUsername(request.username())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales invalidas"));
        if (!passwordEncoder.matches(request.password(), usuario.getPassword())) {
            throw new IllegalArgumentException("Credenciales invalidas");
        }
        if (!usuario.isEnabled()) {
            throw new IllegalArgumentException("Usuario deshabilitado");
        }
        return new AuthResponse(null, usuario.getUsername(), usuario.getRol().name());
    }

    @Override
    public UsuarioResponse obtenerUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .map(usuarioMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + username));
    }

    @Override
    public boolean existeUsuario(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    @Transactional
    public UsuarioResponse asignarRol(String username, String rol) {
        UsuarioEntity usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + username));
        usuario.setRol(Rol.valueOf(rol.toUpperCase()));
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }
}