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

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarPorId(id);
    }

    @PutMapping
    public Usuario modificarUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }
}
