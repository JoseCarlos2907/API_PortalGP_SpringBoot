package com.app.api.DTO;

import java.util.ArrayList;
import java.util.List;

public class DTOFechaYHora{
    private String fecha;
    private String hora;
    private List<DTOResultadoTop> tiempos = new ArrayList<DTOResultadoTop>();
    
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
    public List<DTOResultadoTop> getTiempos() {
        return tiempos;
    }
    public void setTiempos(List<DTOResultadoTop> tiempos) {
        this.tiempos = tiempos;
    }
}