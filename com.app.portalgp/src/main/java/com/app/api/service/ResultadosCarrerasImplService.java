package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosCarreras;
import com.app.api.repository.ResultadosCarrerasRepository;

public class ResultadosCarrerasImplService implements ResultadosCarrerasService{

    @Autowired
    private ResultadosCarrerasRepository resultadosCarrerasRepository;

    @Override
    public List<ResultadosCarreras> getResultadosCarrreraByIdCarrera(Long idCarrera) {
        return this.resultadosCarrerasRepository.findAll();
    }

    @Override
    public Optional<ResultadosCarreras> getResultadoCarreraByIdPiloto(Long idCarrera, Long idPiloto) {
        return this.resultadosCarrerasRepository.findById(idPiloto);
    }

    @Override
    public DTOFechaYHora getFechaYHoraTopPilotos(Long idCarrera) {
        return this.resultadosCarrerasRepository.getFechaYHoraTopPilotos(idCarrera);
    }

    @Override
    public List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera) {
        return this.resultadosCarrerasRepository.getResultadosTopPilotos(idCarrera);
    }
    
}
