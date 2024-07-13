package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.DTO.DTOFechaYHoraLibre;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.DTO.DTOResultadosLibres;

public interface ResultadosLibresService {
    
    int getTipoLibre(Long idLibre);
    
    List<DTOResultadosLibres> getResultadosLibres(Long idLibre);
    
    Optional<DTOResultadosLibres> getResultadoLibreByIdPiloto(Long idLibre, Long idPiloto);
    
    List<DTOFechaYHoraLibre> getFechaYHoraLibresTopPilotos(Long idCarrera); 
    
    List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera, int numeroLibre);
}
