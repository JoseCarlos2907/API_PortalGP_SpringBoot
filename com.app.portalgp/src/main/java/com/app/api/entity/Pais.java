package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Paises")
public class Pais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPais")
    private Long idPais;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "CoutryCode")
    private String countryCode;

    public Pais(Long idPais, String nombre, String countryCode) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.countryCode = countryCode;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    
}
