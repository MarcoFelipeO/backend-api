package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telefono_id;

    private String numero;
    private String tipo;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name= "usuario_id")
    private Usuario usuario;


    //constructores getter y setter, contructor vacio y contructor con valores.


    public Telefono() {
    }

    public Telefono(Long telefono_id, String numero, String tipo, Usuario usuario) {
        this.telefono_id = telefono_id;
        this.numero = numero;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Long getTelefono_id() {
        return telefono_id;
    }

    public void setTelefono_id(Long telefono_id) {
        this.telefono_id = telefono_id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
