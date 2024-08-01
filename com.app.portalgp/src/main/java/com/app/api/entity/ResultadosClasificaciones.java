package com.app.api.entity;

import jakarta.persistence.*;

@Table(name = "Pilotos_Corren_Clasificacion")
public class ResultadosClasificaciones {

    @Column(name = "idPiloto")
    private Long idPiloto;

    @Column(name = "idClasificacion")
    private Long idClasificacion;

    @Column(name = "TiempoVueltaMasRapida")
    private String tiempoVueltaMasRapida;

    @Column(name = "PosicionFinal")
    private int posicionFinal;

    public ResultadosClasificaciones(Long idPiloto, Long idClasificacion, String tiempoVueltaMasRapida, int posicionFinal) {
        this.idPiloto = idPiloto;
        this.idClasificacion = idClasificacion;
        this.tiempoVueltaMasRapida = tiempoVueltaMasRapida;
        this.posicionFinal = posicionFinal;
    }

    public Long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public Long getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getTiempoVueltaMasRapida() {
        return tiempoVueltaMasRapida;
    }

    public void setTiempoVueltaMasRapida(String tiempoVueltaMasRapida) {
        this.tiempoVueltaMasRapida = tiempoVueltaMasRapida;
    }

    public int getPosicionFinal() {
        return posicionFinal;
    }

    public void setPosicionFinal(int posicionFinal) {
        this.posicionFinal = posicionFinal;
    }

    
}
