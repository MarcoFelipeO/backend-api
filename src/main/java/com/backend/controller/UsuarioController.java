package com.backend.controller;

import com.backend.entity.Usuario;
import com.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public Usuario modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.modificarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> traerUnUsuario(@PathVariable Long id){
        return usuarioService.traerPorId(id);
    }

}
