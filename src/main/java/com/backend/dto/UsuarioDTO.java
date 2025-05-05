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


    //constructor vacio
    public UsuarioDTO() {
    }

    public UsuarioDTO(Long usuario_id, String nombres, String apellidos, String correo, List<TelefonoDTO> telefonos) {
        this.usuario_id = usuario_id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefonos = telefonos;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<TelefonoDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
    }
}

