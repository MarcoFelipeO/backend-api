package com.backend.service;

import com.backend.dto.UsuarioDTO;
import com.backend.entity.Telefono;
import com.backend.entity.Usuario;
import com.backend.mapper.UsuarioMapper;
import com.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper usuarioMapper;


    private final PasswordEncoder passwordEncoder;
    // Constructor
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioDTO> traerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO traerPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el id: " +id));
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(guardado);
    }

    public void eliminarPorId(Long id) {
        if (!usuarioRepository.existsById(id)){
           throw new RuntimeException("Usuario no encontrado para eliminar" + id);
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO modificarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));

        // Usa MapStruct para actualizar los campos del DTO sobre la entidad existente
        usuarioMapper.updateUsuarioFromDto(usuarioDTO, usuarioExistente);

        // Si los teléfonos deben ser reemplazados completamente:
        if (usuarioDTO.getTelefonos() != null) {
            usuarioExistente.setTelefonos(
                    usuarioDTO.getTelefonos().stream()
                            .map(dto -> {
                                Telefono telefono = new Telefono();
                                telefono.setNumero(dto.getNumero());
                                telefono.setTipo(dto.getTipo());
                                telefono.setUsuario(usuarioExistente); // establecer relación
                                return telefono;
                            })
                            .collect(Collectors.toList())
            );
        }

        Usuario actualizado = usuarioRepository.save(usuarioExistente);
        return usuarioMapper.toDTO(actualizado);
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
