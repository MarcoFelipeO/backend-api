package com.backend.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long usuario_id;
    private String nombres;
    private String apellidos;
    private String correo;


}

