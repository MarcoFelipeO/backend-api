package com.backend.controller;

import com.backend.dto.UsuarioDTO;
import com.backend.entity.Telefono;
import com.backend.entity.Usuario;
import com.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private  UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> traerTodos() {
        List<UsuarioDTO> usuarios = usuarioService.traerTodos();
        return ResponseEntity.ok(usuarios);
    }

    //*METODO POST:traemos aqui con el para el objeto telefono, luego con el objeto usuario gracias al join, podemos
    // traer nuestro metodo .getTelefonos y tel.setUsuario(usuario) sin esto no guarda nuestra union
    // de manera correcta*//

    /*
            @PostMapping
            public Usuario guardarUsuario(@RequestBody Usuario usuario){
                for (Telefono tel : usuario.getTelefonos()) {
                    tel.setUsuario(usuario);
                }
                return usuarioService.guardarUsuario(usuario);
            }
    */

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
