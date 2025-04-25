package com.backend.controller;

import com.backend.entity.Telefono;
import com.backend.entity.Usuario;
import com.backend.service.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/telefonos")
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;


    @GetMapping
    public List<Telefono> traerTelefonos(){
        return telefonoService.traerTelefonos();
    }
}
