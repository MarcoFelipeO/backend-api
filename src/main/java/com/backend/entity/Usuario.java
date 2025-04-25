package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String password;



    @OneToMany(mappedBy = "usuario", cascade= CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference //para no devolver un json con recursividad infinita
    private List<Telefono> telefonos = new ArrayList<>();


    public Usuario() {
    }

    public Usuario(Long usuario_id, String nombres, String apellidos, String correo, String password, List<Telefono> telefonos) {
        this.usuario_id = usuario_id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
}
