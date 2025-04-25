package com.backend.service;

import com.backend.entity.Usuario;
import com.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    public List<Usuario> traerTodos() {
        return usuarioRepository.findAll();
    }

    public void eliminarPorId(Long id) {
        usuarioRepository.deleteById(id); //metodo eliminar
    }

    public Optional<Usuario> traerPorId(Long id){
        return usuarioRepository.findById(id);   //buscar por un id
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }



}
