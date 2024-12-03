package com.cajero_backend.cajero_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cajero {

    @Id
    private Long id;
    private String tipo;
    private int cantidad;
    private double denominacion;

    // Constructor vacío
    public Cajero() {}

    // Constructor con parámetros
    public Cajero(Long id, String tipo, int cantidad, double denominacion) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.denominacion = denominacion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(double denominacion) {
        this.denominacion = denominacion;
    }
}