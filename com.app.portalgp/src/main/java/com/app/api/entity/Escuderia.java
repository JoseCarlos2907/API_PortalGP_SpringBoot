package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Escuderias")
public class Escuderia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEscuderia")
    private Long idEscdueria;

    @Column(name = "ImgLogo")
    private String imgLogo;

    @Column(name = "ImgEscuderia")
    private String imgEscuderia;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Puntuacion")
    private int puntuacion;

    @Column(name = "idPais")
    private Long idPais;

    public Escuderia(Long idEscdueria, String imgLogo, String imgEscuderia, String nombre, String descripcion,
            int puntuacion, Long idPais) {
        this.idEscdueria = idEscdueria;
        this.imgLogo = imgLogo;
        this.imgEscuderia = imgEscuderia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.idPais = idPais;
    }

    public Long getIdEscdueria() {
        return idEscdueria;
    }

    public void setIdEscdueria(Long idEscdueria) {
        this.idEscdueria = idEscdueria;
    }

    public String getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }

    public String getImgEscuderia() {
        return imgEscuderia;
    }

    public void setImgEscuderia(String imgEscuderia) {
        this.imgEscuderia = imgEscuderia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    
}
