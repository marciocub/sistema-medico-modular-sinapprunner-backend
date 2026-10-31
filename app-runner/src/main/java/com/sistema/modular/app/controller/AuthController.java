package com.sistema.modular.app.controller;

import com.sistema.modular.app.service.TokenService;
import com.sistema.modular.seguridad.SeguridadApi;
import com.sistema.modular.seguridad.dto.LoginRequest;
import com.sistema.modular.seguridad.dto.UsuarioResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final SeguridadApi seguridadApi;
    private final TokenService tokenService;

    public AuthController(SeguridadApi seguridadApi, TokenService tokenService) {
        this.seguridadApi = seguridadApi;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        try {
            var authResponse = seguridadApi.autenticar(request);
            // Need to get user details for role
            UsuarioResponse usuario = seguridadApi.obtenerUsuarioPorUsername(request.username());
            String token = tokenService.generarToken(usuario.username(), usuario.rol().name());

            Cookie cookie = new Cookie("SESSION_TOKEN", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(false); // set to true in production with HTTPS
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            cookie.setAttribute("SameSite", "Strict");
            response.addCookie(cookie);

            return ResponseEntity.ok(Map.of(
                "username", usuario.username(),
                "rol", usuario.rol().name()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales invalidas"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("SESSION_TOKEN", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok(Map.of("message", "Logout exitoso"));
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@org.springframework.security.core.annotation.AuthenticationPrincipal String username) {
        if (username == null) {
            return ResponseEntity.status(401).body(Map.of("error", "No autenticado"));
        }
        UsuarioResponse usuario = seguridadApi.obtenerUsuarioPorUsername(username);
        return ResponseEntity.ok(Map.of(
            "id", usuario.id(),
            "username", usuario.username(),
            "rol", usuario.rol().name()
        ));
    }
}