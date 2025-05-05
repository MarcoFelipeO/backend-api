package com.backend.dto;

public class TelefonoDTO {

    private Long telefono_id;
    private String numero;
    private String tipo;

    public TelefonoDTO() {
    }

    public TelefonoDTO(Long telefono_id, String numero, String tipo) {
        this.telefono_id = telefono_id;
        this.numero = numero;
        this.tipo = tipo;
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

}
