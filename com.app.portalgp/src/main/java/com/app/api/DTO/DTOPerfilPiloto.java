package com.app.api.DTO;

import java.util.List;
import java.util.Optional;

public class DTOPerfilPiloto {
    public Optional<DTOBasicoPerfilPiloto> datosBasicos;
    public List<DTOUltimosTiemposPiloto> ultimosTiempos;
    public List<DTOUltimasPosicionesPiloto> ultimasPosiciones;

    public DTOPerfilPiloto(Optional<DTOBasicoPerfilPiloto> datosBasicos, List<DTOUltimosTiemposPiloto> ultimosTiempos, List<DTOUltimasPosicionesPiloto> ultimasPosiciones) {
        this.datosBasicos = datosBasicos;
        this.ultimosTiempos = ultimosTiempos;
        this.ultimasPosiciones = ultimasPosiciones;
    }

    public Optional<DTOBasicoPerfilPiloto> getDatosBasicos() {
        return datosBasicos;
    }

    public void setDatosBasicos(Optional<DTOBasicoPerfilPiloto> datosBasicos) {
        this.datosBasicos = datosBasicos;
    }

    public List<DTOUltimosTiemposPiloto> getUltimosTiempos() {
        return ultimosTiempos;
    }

    public void setUltimosTiempos(List<DTOUltimosTiemposPiloto> ultimosTiempos) {
        this.ultimosTiempos = ultimosTiempos;
    }

    public List<DTOUltimasPosicionesPiloto> getUltimasPosiciones() {
        return ultimasPosiciones;
    }

    public void setUltimasPosiciones(List<DTOUltimasPosicionesPiloto> ultimasPosiciones) {
        this.ultimasPosiciones = ultimasPosiciones;
    }
}
