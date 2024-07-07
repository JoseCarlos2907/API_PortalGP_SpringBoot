package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comentarios_usuarios_pilotos_carreras")
public class Comentario {
    
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "idPiloto")
    private Long idPiloto;

    @Column(name = "idCarrera")
    private Long idCarrera;

    @Column(name = "Comentario")
    private String comentario;

    public Comentario(Long idUsuario, Long idPiloto, Long idCarrera, String comentario) {
        this.idUsuario = idUsuario;
        this.idPiloto = idPiloto;
        this.idCarrera = idCarrera;
        this.comentario = comentario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
}
