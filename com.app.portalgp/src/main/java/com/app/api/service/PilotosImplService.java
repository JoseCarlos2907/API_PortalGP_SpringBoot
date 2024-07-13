package com.app.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

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

public class PilotosImplService implements PilotosService{

    @Autowired
    private PilotosRepository pilotosRepository;

    @Override
    public List<Piloto> getAllPilotos() {
        return this.pilotosRepository.findAll();
    }

    @Override
    public Optional<Piloto> getPilotoById(Long idPiloto) {
        return this.pilotosRepository.findById(idPiloto);
    }

    @Override
    public Pais getPaisPiloto(Long idPiloto) {
        return this.pilotosRepository.getPaisPiloto(idPiloto);
    }

    @Override
    public Coche getCochePiloto(Long idPiloto) {
        return this.pilotosRepository.getCochePiloto(idPiloto);
    }

    @Override
    public List<Usuarios> getUsuariosSeguidoresPiloto(Long idPiloto) {
        return this.pilotosRepository.getUsuariosSeguidoresPiloto(idPiloto);
    }

    @Override
    public List<DTOComentarios> getComentariosPiloto(Long idPiloto) {
        return this.pilotosRepository.getComentariosPiloto(idPiloto);
    }

    @Override
    public List<DTOClasificacionPilotosOficial> getDatosClasificacionOficial() {
        return this.pilotosRepository.getDatosClasificacionOficial();
    }

    @Override
    public List<DTOClasificacionPilotosComunidad> getDatosClasificacionComunidad() {
        return this.pilotosRepository.getDatosClasificacionComunidad();
    }

    @Override
    public List<Integer> getPuntuacionesPiloto(Long idPiloto) {
        return this.pilotosRepository.getPuntuacionesPiloto(idPiloto);
    }

    @Override
    public Optional<DTOBasicoPerfilPiloto> getDatosBasicoPerfilPiloto(Long idPiloto) {
        return this.pilotosRepository.getDatosBasicoPerfilPiloto(idPiloto);
    }

    @Override
    public List<DTOUltimosTiemposPiloto> getUltimosTiemposPiloto(Long idPiloto) {
        return this.pilotosRepository.getUltimosTiemposPiloto(idPiloto);
    }

    @Override
    public List<DTOUltimasPosicionesPiloto> getUltimasPosicionesPiloto(Long idPiloto) {
        return this.pilotosRepository.getUltimasPosicionesPiloto(idPiloto);
    }

    @Override
    public HashMap<String, String> seguirPiloto(Long idPiloto, Long idSeguidor) {
        return this.pilotosRepository.seguirPiloto(idPiloto, idSeguidor);
    }

    @Override
    public HashMap<String, String> dejarDeSeguirPiloto(Long idPiloto, Long idSeguidor) {
        return this.pilotosRepository.dejarDeSeguirPiloto(idPiloto, idSeguidor);
    }

    @Override
    public List<Piloto> getPilotosBarraBusqueda(String cadena) {
        return this.pilotosRepository.getPilotosBarraBusqueda(cadena);
    }
    
}
