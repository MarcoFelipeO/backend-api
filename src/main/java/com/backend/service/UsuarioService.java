package com.backend.service;

import com.backend.entity.Usuario;
import com.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    public List<Usuario> traerTodos() {
        return usuarioRepository.findAll();
    }
}
