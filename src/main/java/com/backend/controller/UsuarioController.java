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
    public ResponseEntity<UsuarioDTO> modificarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO actualizado = usuarioService.modificarUsuario(id, usuarioDTO);
            return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> traerUnUsuario(@PathVariable Long id){
       UsuarioDTO usuarioDTO = usuarioService.traerPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

}
