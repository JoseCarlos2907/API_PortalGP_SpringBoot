package com.app.api.DTO;

public class DTOUltimosTiemposPiloto{
    public String tipo;
    public int numeroLibre;
    public String tiempo;
    public String nombrePais;
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getNumeroLibre() {
        return numeroLibre;
    }
    public void setNumeroLibre(int numeroLibre) {
        this.numeroLibre = numeroLibre;
    }
    public String getTiempo() {
        return tiempo;
    }
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    public String getNombrePais() {
        return nombrePais;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    
}
