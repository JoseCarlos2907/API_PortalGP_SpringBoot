package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosClasificaciones;
import com.app.api.repository.ResultadosClasificacionesRepository;

public class ResultadosClasificacionesImplService implements ResultadosClasificacionesService{

    @Autowired
    private ResultadosClasificacionesRepository resultadosClasificacionesRepository;
    
    @Override
    public List<ResultadosClasificaciones> getResultadosClasifiacionesByIdClasificacion(Long idClasificacion) {
        return resultadosClasificacionesRepository.findAll();
    }

    @Override
    public Optional<ResultadosClasificaciones> getResultadoClasificacionByIdPiloto(Long idClasificacion, Long idPiloto) {
        return resultadosClasificacionesRepository.findById(idPiloto);
    }

    @Override
    public DTOFechaYHora getFechaYHoraTopPilotos(Long idCarrera) {
        return resultadosClasificacionesRepository.getFechaYHoraTopPilotos(idCarrera);
    }

    @Override
    public List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera) {
        return resultadosClasificacionesRepository.getResultadosTopPilotos(idCarrera);
    }
    
}
