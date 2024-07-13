package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosClasificaciones;

public interface ResultadosClasificacionesService {
    
    List<ResultadosClasificaciones> getResultadosClasifiacionesByIdClasificacion(Long idClasificacion);
    
    Optional<ResultadosClasificaciones> getResultadoClasificacionByIdPiloto(Long idClasificacion, Long idPiloto);
    
    DTOFechaYHora getFechaYHoraTopPilotos(Long idCarrera);
    
    List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera);
    
    
}
