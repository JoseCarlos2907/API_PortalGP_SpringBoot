package com.app.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.DTO.DTOBasicoPerfilPiloto;
import com.app.api.DTO.DTOClasificacionPilotosComunidad;
import com.app.api.DTO.DTOClasificacionPilotosOficial;
import com.app.api.DTO.DTOComentarios;
import com.app.api.DTO.DTOUltimasPosicionesPiloto;
import com.app.api.DTO.DTOUltimosTiemposPiloto;
import com.app.api.entity.Coche;
import com.app.api.entity.Pais;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;
import com.app.api.repository.PilotosRepository;

@Service
public class PilotosService{

    @Autowired
    private PilotosRepository pilotosRepository;

    public List<Piloto> getAllPilotos() {
        return this.pilotosRepository.findAll();
    }

    public Optional<Piloto> getPilotoById(Long idPiloto) {
        return this.pilotosRepository.findById(idPiloto);
    }

    public Pais getPaisPiloto(Long idPiloto) {
        return this.pilotosRepository.getPaisPiloto(idPiloto);
    }

    public Coche getCochePiloto(Long idPiloto) {
        return this.pilotosRepository.getCochePiloto(idPiloto);
    }

    public List<Usuarios> getUsuariosSeguidoresPiloto(Long idPiloto) {
        return this.pilotosRepository.getUsuariosSeguidoresPiloto(idPiloto);
    }

    public List<DTOComentarios> getComentariosPiloto(Long idPiloto) {
        return this.pilotosRepository.getComentariosPiloto(idPiloto);
    }

    public List<DTOClasificacionPilotosOficial> getDatosClasificacionOficial() {
        return this.pilotosRepository.getDatosClasificacionOficial();
    }

    public List<DTOClasificacionPilotosComunidad> getDatosClasificacionComunidad() {
        return this.pilotosRepository.getDatosClasificacionComunidad();
    }

    public List<Integer> getPuntuacionesPiloto(Long idPiloto) {
        return this.pilotosRepository.getPuntuacionesPiloto(idPiloto);
    }

    public Optional<DTOBasicoPerfilPiloto> getDatosBasicoPerfilPiloto(Long idPiloto) {
        return this.pilotosRepository.getDatosBasicoPerfilPiloto(idPiloto);
    }

    public List<DTOUltimosTiemposPiloto> getUltimosTiemposPiloto(Long idPiloto) {
        return this.pilotosRepository.getUltimosTiemposPiloto(idPiloto);
    }

    public List<DTOUltimasPosicionesPiloto> getUltimasPosicionesPiloto(Long idPiloto) {
        return this.pilotosRepository.getUltimasPosicionesPiloto(idPiloto);
    }

    public HashMap<String, String> seguirPiloto(Long idPiloto, Long idSeguidor) {
        return this.pilotosRepository.seguirPiloto(idPiloto, idSeguidor);
    }

    public HashMap<String, String> dejarDeSeguirPiloto(Long idPiloto, Long idSeguidor) {
        return this.pilotosRepository.dejarDeSeguirPiloto(idPiloto, idSeguidor);
    }

    public List<Piloto> getPilotosBarraBusqueda(String cadena) {
        return this.pilotosRepository.getPilotosBarraBusqueda(cadena);
    }
    
}
