package com.backend.controller;

import com.backend.dto.TelefonoDTO;
import com.backend.dto.UsuarioDTO;
import com.backend.entity.Telefono;
import com.backend.service.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/telefonos")
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;


    @GetMapping
    public ResponseEntity<List<TelefonoDTO>> traerTelefonos(){
        List<TelefonoDTO> telefonos = telefonoService.traerTelefonos();
        return ResponseEntity.ok(telefonos);
    }
}
