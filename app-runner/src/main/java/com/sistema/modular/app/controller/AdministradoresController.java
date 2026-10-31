package com.sistema.modular.app.controller;

import com.sistema.modular.seguridad.SeguridadApi;
import com.sistema.modular.seguridad.dto.Rol;
import com.sistema.modular.seguridad.dto.UsuarioRegistroRequest;
import com.sistema.modular.seguridad.dto.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/administradores")
public class AdministradoresController {

    private final SeguridadApi seguridadApi;

    public AdministradoresController(SeguridadApi seguridadApi) {
        this.seguridadApi = seguridadApi;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioResponse> crearAdministrador(@RequestBody UsuarioRegistroRequest request) {
        UsuarioRegistroRequest adminRequest = new UsuarioRegistroRequest(
                request.username(), request.password(), Rol.ADMIN,
                request.nombre(), request.apellido());
        return ResponseEntity.ok(seguridadApi.registrarUsuario(adminRequest));
    }
}