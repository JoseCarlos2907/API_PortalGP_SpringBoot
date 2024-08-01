package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosClasificaciones;
import com.app.api.repository.ResultadosClasificacionesRepository;

@Service
public class ResultadosClasificacionesService{

    @Autowired
    private ResultadosClasificacionesRepository resultadosClasificacionesRepository;
    
    public List<ResultadosClasificaciones> getResultadosClasifiacionesByIdClasificacion(Long idClasificacion) {
        return resultadosClasificacionesRepository.findAll();
    }

    public Optional<ResultadosClasificaciones> getResultadoClasificacionByIdPiloto(Long idClasificacion, Long idPiloto) {
        return resultadosClasificacionesRepository.findById(idPiloto);
    }

    public Optional<DTOFechaYHora> getFechaYHoraTopPilotos(Long idCarrera) {
        return resultadosClasificacionesRepository.getFechaYHoraTopPilotos(idCarrera);
    }

    public List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera) {
        return resultadosClasificacionesRepository.getResultadosTopPilotos(idCarrera);
    }
    
}
