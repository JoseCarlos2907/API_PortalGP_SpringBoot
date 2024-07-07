package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Coches")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCoche")
    private Long idCoche;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "ImgPrincipal")
    private String imgPrincipal;

    @Column(name = "SegundaImg")
    private String segundaImg;

    @Column(name = "TerceraImg")
    private String terceraImg;

    @Column(name = "CuartaImg")
    private String cuartaImg;

    @Column(name = "idEscuderia")
    private Long idEscuderia;

    public Coche(Long idCoche, String modelo, String imgPrincipal, String segundaImg, String terceraImg,String cuartaImg, Long idEscuderia) {
        this.idCoche = idCoche;
        this.modelo = modelo;
        this.imgPrincipal = imgPrincipal;
        this.segundaImg = segundaImg;
        this.terceraImg = terceraImg;
        this.cuartaImg = cuartaImg;
        this.idEscuderia = idEscuderia;
    }

    public Long getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(Long idCoche) {
        this.idCoche = idCoche;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImgPrincipal() {
        return imgPrincipal;
    }

    public void setImgPrincipal(String imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }

    public String getSegundaImg() {
        return segundaImg;
    }

    public void setSegundaImg(String segundaImg) {
        this.segundaImg = segundaImg;
    }

    public String getTerceraImg() {
        return terceraImg;
    }

    public void setTerceraImg(String terceraImg) {
        this.terceraImg = terceraImg;
    }

    public String getCuartaImg() {
        return cuartaImg;
    }

    public void setCuartaImg(String cuartaImg) {
        this.cuartaImg = cuartaImg;
    }

    public Long getIdEscuderia() {
        return idEscuderia;
    }

    public void setIdEscuderia(Long idEscuderia) {
        this.idEscuderia = idEscuderia;
    }
}
