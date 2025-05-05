package com.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {

    private Long usuario_id;
    private String nombres;
    private String apellidos;
    private String correo;
    private List<TelefonoDTO> telefonos;



}

