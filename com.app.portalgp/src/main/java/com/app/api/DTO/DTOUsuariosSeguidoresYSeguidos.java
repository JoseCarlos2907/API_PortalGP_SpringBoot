package com.app.api.DTO;

public class DTOUsuariosSeguidoresYSeguidos{
    public Long idUsuario;
    public String nombreUsuario;
    public int numComentarios;
    public String imgPerfil;
    
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
    public int getNumComentarios() {
        return numComentarios;
    }
    public void setNumComentarios(int numComentarios) {
        this.numComentarios = numComentarios;
    }
    public String getImgPerfil() {
        return imgPerfil;
    }
    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    
}
