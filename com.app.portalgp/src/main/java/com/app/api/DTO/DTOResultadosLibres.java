package com.app.api.DTO;

public class DTOResultadosLibres {

    public Long idPiloto;
    public Long idLibre;
    public String tiempoVueltaMasRapida;
    public int posicionFinal;
    public int numeroLibre = 0;
    
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
    public int getNumeroLibre() {
        return numeroLibre;
    }
    public void setNumeroLibre(int numeroLibre) {
        this.numeroLibre = numeroLibre;
    }

    
}
