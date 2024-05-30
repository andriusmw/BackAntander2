package com.example.models;
public class Cliente {

    private String nombre;
    private String tipoCliente;
    private String numeroDocumento;

    public Cliente() {}

    public Cliente(String nombre, String tipoCliente, String numeroDocumento) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.numeroDocumento = numeroDocumento;
    }

    // Getter para el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre del cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para el tipo de cliente
    public String getTipoCliente() {
        return tipoCliente;
    }

    // Setter para el tipo de cliente
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    // Getter para el número de documento
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    // Setter para el número de documento
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}