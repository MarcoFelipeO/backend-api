package com.backend.service;

import com.backend.dto.TelefonoDTO;
import com.backend.dto.UsuarioDTO;
import com.backend.entity.Telefono;
import com.backend.mapper.TelefonoMapper;
import com.backend.mapper.UsuarioMapper;
import com.backend.repository.TelefonoRepository;
import com.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefonoService {

    private final TelefonoRepository telefonoRepository;
    private final TelefonoMapper telefonoMapper;

    public TelefonoService(TelefonoRepository telefonoRepository, TelefonoMapper telefonoMapper) {
        this.telefonoRepository = telefonoRepository;
        this.telefonoMapper = telefonoMapper;
    }

    public List<TelefonoDTO> traerTelefonos() {
        return telefonoRepository.findAll()
                .stream()
                .map(telefonoMapper::toDTO)
                .collect(Collectors.toList());
    }


}
