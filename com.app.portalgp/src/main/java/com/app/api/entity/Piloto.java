package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Pilotos")
public class Piloto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPiloto")
    private Long idPiloto;

    @Column(name = "ImgPerfil")
    private String imgPerfil;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "FechaNac")
    private String fechaNac;

    @Column(name = "Peso")
    private Double peso;

    @Column(name = "Altura")
    private Double altura;

    @Column(name = "Numero")
    private int numero;

    @Column(name = "Puntuacion")
    private int puntuacion;

    @Column(name = "idPais")
    private int idPais;

    @Column(name = "idCoche")
    private int idCoche;

    public Piloto(Long idPiloto, String imgPerfil, String nombre, String apellido, String fechaNac, Double peso,
            Double altura, int numero, int puntuacion, int idPais, int idCoche) {
        this.idPiloto = idPiloto;
        this.imgPerfil = imgPerfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.peso = peso;
        this.altura = altura;
        this.numero = numero;
        this.puntuacion = puntuacion;
        this.idPais = idPais;
        this.idCoche = idCoche;
    }

    public Long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    
}