package com.app.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosCarreras;

@Repository
public interface ResultadosCarrerasRepository extends JpaRepository<ResultadosCarreras, Long> {
    
    @Query("SELECT * FROM Pilotos_Corren_Carreras WHERE idCarrera = :idCarrera")
    List<ResultadosCarreras> getResultadosCarrreraByIdCarrera(Long idCarrera);

    @Query("SELECT * FROM Pilotos_Corren_Carreras WHERE idCarrera = :idCarrera AND idPiloto = :idPiloto")
    Optional<ResultadosCarreras> getResultadoCarreraByIdPiloto(Long idCarrera, Long idPiloto);

    @Query("SELECT C.HoraInicio AS hora, C.Fecha AS fecha FROM Carreras AS C WHERE C.idCarrera = :idCarrera")
    DTOFechaYHora getFechaYHoraTopPilotos(Long idCarrera);

    @Query("SELECT P.Nombre AS nombre, P.Apellido AS apellido, PCC.PosicionFinal AS posicionFinal, PCC.TiempoTotalEnCarrera AS tiempo FROM Pilotos_Corren_Carreras PCC JOIN Pilotos P ON P.idPiloto = PCC.idPiloto WHERE PCC.idCarrera = :idCarrera AND PCC.PosicionFinal != 0 ORDER BY CAST(PCC.PosicionFinal AS UNSIGNED) LIMIT 3")
    List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera);
}
