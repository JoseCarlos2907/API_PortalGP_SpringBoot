package com.app.api.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.DTO.DTOFechaYHoraLibre;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.DTO.DTOResultadosLibres;
import com.app.api.entity.ResultadosLibres;

@Repository
public interface ResultadosLibresRepository extends JpaRepository<ResultadosLibres, Long>{
    
    @Query("SELECT NumeroLibre FROM Libres WHERE idLibre = :idLibre")
    int getTipoLibre(Long idLibre);

    @Query("SELECT * FROM Pilotos_Corren_Libres WHERE idLibre = :idLibre")
    List<DTOResultadosLibres> getResultadosLibres(Long idLibre);

    @Query("SELECT * FROM Pilotos_Corren_Libres WHERE idLibre = :idLibre AND idPiloto = :idPiloto")
    Optional<DTOResultadosLibres> getResultadoLibreByIdPiloto(Long idLibre, Long idPiloto);

    @Query("SELECT L.NumeroLibre AS numero, L.Fecha AS fecha, L.HoraInicio AS hora, CASE  WHEN L.NumeroLibre = 1 THEN 'Libre - 1' WHEN L.NumeroLibre = 2 THEN 'Libre - 2' WHEN L.NumeroLibre = 3 THEN 'Libre - 3' WHEN L.NumeroLibre = 4 THEN 'Cla. Sprint' WHEN L.NumeroLibre = 5 THEN 'Sprint' ELSE 'Desconocido' END AS tipo FROM Libres L WHERE idCarrera = :idCarrera")
    List<DTOFechaYHoraLibre> getFechaYHoraLibresTopPilotos(Long idCarrera); 

    @Query("SELECT PCL.PosicionFinal AS posicion, P.Nombre AS nombrePiloto, P.Apellido AS apellidoPiloto, PCL.TiempoVueltaMasRapida AS tiempo FROM Pilotos_Corren_Libres PCL JOIN Pilotos P ON P.idPiloto = PCL.idPiloto JOIN Libres L ON L.idLibre = PCL.idLibre JOIN Carreras C ON C.idCarrera = L.idCarrera WHERE C.idCarrera = :idCarrera AND L.NumeroLibre = :numeroLibre AND PCL.PosicionFinal != 0 AND PCL.TiempoVueltaMasRapida != '+0 vueltas' AND PCL.TiempoVueltaMasRapida != 'DNF' ORDER BY STR_TO_DATE(PCL.TiempoVueltaMasRapida, '%i:%s:%f') LIMIT 3")
    List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera, int numeroLibre);
}
