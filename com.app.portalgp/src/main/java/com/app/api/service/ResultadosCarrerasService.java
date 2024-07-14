package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosCarreras;
import com.app.api.repository.ResultadosCarrerasRepository;

@Service
public class ResultadosCarrerasService{

    @Autowired
    private ResultadosCarrerasRepository resultadosCarrerasRepository;

    public List<ResultadosCarreras> getResultadosCarrreraByIdCarrera(Long idCarrera) {
        return this.resultadosCarrerasRepository.findAll();
    }

    public Optional<ResultadosCarreras> getResultadoCarreraByIdPiloto(Long idCarrera, Long idPiloto) {
        return this.resultadosCarrerasRepository.findById(idPiloto);
    }

    public DTOFechaYHora getFechaYHoraTopPilotos(Long idCarrera) {
        return this.resultadosCarrerasRepository.getFechaYHoraTopPilotos(idCarrera);
    }

    public List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera) {
        return this.resultadosCarrerasRepository.getResultadosTopPilotos(idCarrera);
    }
    
}
