package com.sistema.modular.seguridad;

import com.sistema.modular.seguridad.dto.UsuarioRegistroRequest;
import com.sistema.modular.seguridad.dto.UsuarioResponse;
import com.sistema.modular.seguridad.dto.LoginRequest;
import com.sistema.modular.seguridad.dto.AuthResponse;

public interface SeguridadApi {
    UsuarioResponse registrarUsuario(UsuarioRegistroRequest request);
    AuthResponse autenticar(LoginRequest request);
    UsuarioResponse obtenerUsuarioPorUsername(String username);
    boolean existeUsuario(String username);
    UsuarioResponse asignarRol(String username, String rol);
}