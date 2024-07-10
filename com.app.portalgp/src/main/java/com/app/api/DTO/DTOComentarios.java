package com.app.api.DTO;

public class DTOComentarios{
    public Long idCarrera;
    public String nombrePais;
    public Long idUsuario;
    public String nombreUsuario;
    public Long idPiloto;
    public String nombrePiloto;
    public String comentario;
    public String imgPefilUsuario;
    public String imgPerfilPiloto;
    
    public Long getIdCarrera() {
        return idCarrera;
    }
    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }
    public String getNombrePais() {
        return nombrePais;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public Long getIdPiloto() {
        return idPiloto;
    }
    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }
    public String getNombrePiloto() {
        return nombrePiloto;
    }
    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getImgPefilUsuario() {
        return imgPefilUsuario;
    }
    public void setImgPefilUsuario(String imgPefilUsuario) {
        this.imgPefilUsuario = imgPefilUsuario;
    }
    public String getImgPerfilPiloto() {
        return imgPerfilPiloto;
    }
    public void setImgPerfilPiloto(String imgPerfilPiloto) {
        this.imgPerfilPiloto = imgPerfilPiloto;
    }

    
}
