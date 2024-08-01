package com.app.api.entity;

import jakarta.persistence.*;

@Table(name = "Pilotos_Corren_Libres")
public class ResultadosLibres {
    @Column(name = "idPiloto")
    private Long idPiloto;

    @Column(name = "idLibre")
    private Long idLibre;

    @Column(name = "TiempoVueltaMasRapida")
    private String tiempoVueltaMasRapida;

    @Column(name = "PosicionFinal")
    private int posicionFinal;

    public ResultadosLibres(Long idPiloto, Long idLibre, String tiempoVueltaMasRapida, int posicionFinal) {
        this.idPiloto = idPiloto;
        this.idLibre = idLibre;
        this.tiempoVueltaMasRapida = tiempoVueltaMasRapida;
        this.posicionFinal = posicionFinal;
    }

    public Long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public Long getIdLibre() {
        return idLibre;
    }

    public void setIdLibre(Long idLibre) {
        this.idLibre = idLibre;
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
