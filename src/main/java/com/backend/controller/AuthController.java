package com.backend.controller;

import com.backend.dto.LoginRequest;
import com.backend.entity.Telefono;
import com.backend.entity.Usuario;
import com.backend.service.JwtService;
import com.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    public AuthController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        usuarioService.registrar(usuario);

        for (Telefono tel : usuario.getTelefonos()) {
            tel.setUsuario(usuario);
        }
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioService.autenticar(loginRequest.getCorreo(), loginRequest.getPassword());
        String token = jwtService.generateToken(usuario);
        return ResponseEntity.ok(token);
    }


    @PostMapping("/registrar-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> registrarAdmin(@RequestBody Usuario usuario){
        usuarioService.registrarAdmin(usuario);
        return ResponseEntity.ok("Administrador creado exitosamente");
    }

}
