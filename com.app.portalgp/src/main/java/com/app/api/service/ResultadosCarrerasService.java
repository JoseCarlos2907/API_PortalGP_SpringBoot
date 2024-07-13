package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosCarreras;

public interface ResultadosCarrerasService {
    
    List<ResultadosCarreras> getResultadosCarrreraByIdCarrera(Long idCarrera);

    Optional<ResultadosCarreras> getResultadoCarreraByIdPiloto(Long idCarrera, Long idPiloto);

    DTOFechaYHora getFechaYHoraTopPilotos(Long idCarrera);
    
    List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera);
}
