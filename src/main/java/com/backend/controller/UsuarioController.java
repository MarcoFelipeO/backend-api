package com.backend.controller;

import com.backend.entity.Usuario;
import com.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private  UsuarioService usuarioService;



    @GetMapping
    public List<Usuario> traerTodos() {
        return usuarioService.traerTodos();
    }
}
