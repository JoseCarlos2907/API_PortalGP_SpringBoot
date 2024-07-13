package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.DTO.DTOFechaYHoraLibre;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.DTO.DTOResultadosLibres;
import com.app.api.repository.ResultadosLibresRepository;

public class ResultadosLibresImplService implements ResultadosLibresService{

    @Autowired
    private ResultadosLibresRepository resultadosLibresRepository;

    @Override
    public int getTipoLibre(Long idLibre) {
        return this.resultadosLibresRepository.getTipoLibre(idLibre);
    }

    @Override
    public List<DTOResultadosLibres> getResultadosLibres(Long idLibre) {
        return this.resultadosLibresRepository.getResultadosLibres(idLibre);
    }

    @Override
    public Optional<DTOResultadosLibres> getResultadoLibreByIdPiloto(Long idLibre, Long idPiloto) {
        return this.resultadosLibresRepository.getResultadoLibreByIdPiloto(idLibre, idPiloto);
    }

    @Override
    public List<DTOFechaYHoraLibre> getFechaYHoraLibresTopPilotos(Long idCarrera) {
        return this.resultadosLibresRepository.getFechaYHoraLibresTopPilotos(idCarrera);
    }

    @Override
    public List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera, int numeroLibre) {
        return this.resultadosLibresRepository.getResultadosTopPilotos(idCarrera, numeroLibre);
    }
    
}
