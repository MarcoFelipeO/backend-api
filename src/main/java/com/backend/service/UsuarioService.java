package com.backend.service;

import com.backend.entity.Usuario;
import com.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    private final PasswordEncoder passwordEncoder;
    // Constructor
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public List<Usuario> traerTodos() {
        return usuarioRepository.findAll();
    }

    public void eliminarPorId(Long id) {
        usuarioRepository.deleteById(id); //metodo eliminar
    }

    public Optional<Usuario> traerPorId(Long id){

        return usuarioRepository.findById(id);   //buscar por un id
    }

    /*
            public Usuario guardarUsuario(Usuario usuario){
            return usuarioRepository.save(usuario);
            }
    */
    public Usuario modificarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    public void registrar(Usuario usuario) {
        // Importante: Encriptar la contraseña antes de guardar
        usuario.setRol("USER");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    public Usuario autenticar(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        return usuario;
    }


    public Usuario buscarPorCorreo(String correo) {

        return usuarioRepository.findByCorreo(correo).orElse(null);
    }


    public void registrarAdmin(Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol("ADMIN");
        usuarioRepository.save(usuario);
    }

}
