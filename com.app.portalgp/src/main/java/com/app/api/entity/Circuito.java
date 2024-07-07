package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Circuitos")
public class Circuito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCircuito")
    private Long idCircuito;

    @Column(name = "ImgCircuito")
    private String imgCircuito;

    @Column(name = "ImgSiluetaCircuito")
    private String imgSiluetaCircuito;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Longitud")
    private Double longitud;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "idPais")
    private Long idPais;

    public Circuito(Long idCircuito, String imgCircuito, String imgSiluetaCircuito, String nombre, Double longitud, String tipo, Long idPais) {
        this.idCircuito = idCircuito;
        this.imgCircuito = imgCircuito;
        this.imgSiluetaCircuito = imgSiluetaCircuito;
        this.nombre = nombre;
        this.longitud = longitud;
        this.tipo = tipo;
        this.idPais = idPais;
    }

    public Long getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(Long idCircuito) {
        this.idCircuito = idCircuito;
    }

    public String getImgCircuito() {
        return imgCircuito;
    }

    public void setImgCircuito(String imgCircuito) {
        this.imgCircuito = imgCircuito;
    }

    public String getImgSiluetaCircuito() {
        return imgSiluetaCircuito;
    }

    public void setImgSiluetaCircuito(String imgSiluetaCircuito) {
        this.imgSiluetaCircuito = imgSiluetaCircuito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    
}
