package com.app.api.DTO;

public class DTOClasificacionPilotosOficial{
    public Long idPiloto;
    public String nombre;
    public String apellido;
    public String imgPerfil;
    public int puntostotales;
    public String nombreEscuderia;
    public String paisCC;
    public String nombrePais;
    
    public Long getIdPiloto() {
        return idPiloto;
    }
    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
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
    public String getImgPerfil() {
        return imgPerfil;
    }
    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }
    public int getPuntostotales() {
        return puntostotales;
    }
    public void setPuntostotales(int puntostotales) {
        this.puntostotales = puntostotales;
    }
    public String getNombreEscuderia() {
        return nombreEscuderia;
    }
    public void setNombreEscuderia(String nombreEscuderia) {
        this.nombreEscuderia = nombreEscuderia;
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
