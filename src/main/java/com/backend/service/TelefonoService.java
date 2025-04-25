package com.backend.service;

import com.backend.entity.Telefono;
import com.backend.repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoService {


    @Autowired
    private TelefonoRepository telefonoRepository;


    public List<Telefono> traerTelefonos(){
        return telefonoRepository.findAll();
    }


}
