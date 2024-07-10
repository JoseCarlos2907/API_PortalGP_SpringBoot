package com.app.api.DTO;

import java.util.ArrayList;
import java.util.List;

public class DTOFechaYHoraLibre{
    public String tipo;
    public String fecha;
    public String hora;
    public int numeroLibre;
    public List<DTOResultadoTop> tiempos = new ArrayList<DTOResultadoTop>();
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public int getNumeroLibre() {
        return numeroLibre;
    }
    public void setNumeroLibre(int numeroLibre) {
        this.numeroLibre = numeroLibre;
    }
    public List<DTOResultadoTop> getTiempos() {
        return tiempos;
    }
    public void setTiempos(List<DTOResultadoTop> tiempos) {
        this.tiempos = tiempos;
    }

    
}
