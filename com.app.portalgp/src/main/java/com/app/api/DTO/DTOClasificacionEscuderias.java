package com.app.api.DTO;

public class DTOClasificacionEscuderias{
    public Long idEscuderia;
    public String imgLogo;
    public String nombre;
    public int puntosTotales;
    public String paisCC;
    public String nombrePais;
    
    public Long getIdEscuderia() {
        return idEscuderia;
    }
    public void setIdEscuderia(Long idEscuderia) {
        this.idEscuderia = idEscuderia;
    }
    public String getImgLogo() {
        return imgLogo;
    }
    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPuntosTotales() {
        return puntosTotales;
    }
    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }
    public String getPaisCC() {
        return paisCC;
    }
    public void setPaisCC(String paisCC) {
        this.paisCC = paisCC;
    }
    public String getNombrePais() {
        return nombrePais;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    
}


