package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Pilotos_Corren_Libres")
public class ResultadosLibres {
    @Column(name = "idPiloto")
    private Long idPiloto;

    @Column(name = "idCarrera")
    private Long idCarrera;

    @Column(name = "TiempoVueltaMasRapida")
    private String tiempoVueltaMasRapida;

    @Column(name = "PosicionFinal")
    private int posicionFinal;

    public ResultadosLibres(Long idPiloto, Long idCarrera, String tiempoVueltaMasRapida, int posicionFinal) {
        this.idPiloto = idPiloto;
        this.idCarrera = idCarrera;
        this.tiempoVueltaMasRapida = tiempoVueltaMasRapida;
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
