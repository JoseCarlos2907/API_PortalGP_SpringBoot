package com.app.api.DTO;

import java.util.ArrayList;
import java.util.List;

import com.app.api.entity.Escuderia;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;

public class DTOBusqueda {
    public List<Piloto> pilotos;
    public List<Usuarios> usuarios;
    public List<Escuderia> escuderias;

    public DTOBusqueda() {
        this.pilotos = new ArrayList<Piloto>();
        this.usuarios = new ArrayList<Usuarios>();
        this.escuderias = new ArrayList<Escuderia>();
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }
    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }
    public List<Usuarios> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
    public List<Escuderia> getEscuderias() {
        return escuderias;
    }
    public void setEscuderias(List<Escuderia> escuderias) {
        this.escuderias = escuderias;
    }
}
