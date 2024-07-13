package com.app.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

public interface PilotosService {
    
    public List<Piloto> getAllPilotos();

    public Optional<Piloto> getPilotoById(Long idPiloto);

    public Pais getPaisPiloto(Long idPiloto);

    Coche getCochePiloto(Long idPiloto);
    
    List<Usuarios> getUsuariosSeguidoresPiloto(Long idPiloto);
    
    List<DTOComentarios> getComentariosPiloto(Long idPiloto);
    
    List<DTOClasificacionPilotosOficial> getDatosClasificacionOficial();
    
    List<DTOClasificacionPilotosComunidad> getDatosClasificacionComunidad();
    
    List<Integer> getPuntuacionesPiloto(Long idPiloto);
    
    Optional<DTOBasicoPerfilPiloto> getDatosBasicoPerfilPiloto(Long idPiloto);
    
    List<DTOUltimosTiemposPiloto> getUltimosTiemposPiloto(Long idPiloto);
    
    List<DTOUltimasPosicionesPiloto> getUltimasPosicionesPiloto(Long idPiloto);
    
    HashMap<String, String> seguirPiloto(Long idPiloto, Long idSeguidor);
    
    HashMap<String, String> dejarDeSeguirPiloto(Long idPiloto, Long idSeguidor);    
    
    List<Piloto> getPilotosBarraBusqueda(String cadena);
}
