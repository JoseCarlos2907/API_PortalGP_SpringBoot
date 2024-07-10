package com.app.api.DTO;

public class DTOUltimasPosicionesPiloto{
    public String tipo;
    public int numeroLibre;
    public int ultimaPosicion;
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
    public int getUltimaPosicion() {
        return ultimaPosicion;
    }
    public void setUltimaPosicion(int ultimaPosicion) {
        this.ultimaPosicion = ultimaPosicion;
    }
    public String getNombrePais() {
        return nombrePais;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    
}

