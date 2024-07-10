package com.app.api.DTO;

public class DTOClasificacionPilotosComunidad{
    public Long idPiloto;
    public String nombre;
    public String apellido;
    public String imgPerfil;
    public int votosTotales;
    public String nombreEscuderia;
    public String paisCC;
    
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
    public int getVotosTotales() {
        return votosTotales;
    }
    public void setVotosTotales(int votosTotales) {
        this.votosTotales = votosTotales;
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

    
}
