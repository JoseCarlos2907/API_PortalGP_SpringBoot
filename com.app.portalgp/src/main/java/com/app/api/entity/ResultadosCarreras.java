package com.app.api.entity;

import jakarta.persistence.*;

@Table(name = "Pilotos_Corren_Carreras")
public class ResultadosCarreras {
    
    @Column(name = "idPiloto")
    private Long idPiloto;

    @Column(name = "idCarrera")
    private Long idCarrera;

    @Column(name = "TiempoTotalEnCarrera")
    private String tiempoTotalEnCarrera;

    @Column(name = "PosicionFinal")
    private int posicionFinal;

    public ResultadosCarreras(Long idPiloto, Long idCarrera, String tiempoTotalEnCarrera, int posicionFinal) {
        this.idPiloto = idPiloto;
        this.idCarrera = idCarrera;
        this.tiempoTotalEnCarrera = tiempoTotalEnCarrera;
        this.posicionFinal = posicionFinal;
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

    public String getTiempoTotalEnCarrera() {
        return tiempoTotalEnCarrera;
    }

    public void setTiempoTotalEnCarrera(String tiempoTotalEnCarrera) {
        this.tiempoTotalEnCarrera = tiempoTotalEnCarrera;
    }

    public int getPosicionFinal() {
        return posicionFinal;
    }

    public void setPosicionFinal(int posicionFinal) {
        this.posicionFinal = posicionFinal;
    }

    
}
