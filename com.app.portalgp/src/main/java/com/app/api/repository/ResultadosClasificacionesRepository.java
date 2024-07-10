package com.app.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.DTO.DTOResultadoTop;
import com.app.api.entity.ResultadosClasificaciones;


@Repository
public interface ResultadosClasificacionesRepository extends JpaRepository<ResultadosClasificaciones, Long>{
    
    @Query("SELECT * FROM Pilotos_Corren_Clasificacion WHERE idClasificacion = :idClasificacion")
    List<ResultadosClasificaciones> getResultadosClasifiacionesByIdClasificacion(Long idClasificacion);

    @Query("SELECT * FROM Pilotos_Corren_Clasificacion WHERE idClasificacion = :idClasificacion AND idPiloto = :idPiloto")
    Optional<ResultadosClasificaciones> getResultadoClasificacionByIdPiloto(Long idClasificacion, Long idPiloto);

    @Query("SELECT C.HoraInicio AS hora, C.Fecha AS fecha FROM Clasificaciones AS C JOIN Carreras Car ON Car.idCarrera = C.idCarrera WHERE C.idCarrera = :idCarrera")
    DTOFechaYHora getFechaYHoraTopPilotos(Long idCarrera);

    @Query("SELECT P.Nombre AS nombre, P.Apellido AS apellido, PCC.PosicionFinal AS posicionFinal, PCC.TiempoVueltaMasRapida AS tiempo FROM Pilotos_Corren_Clasificacion PCC JOIN Pilotos P ON P.idPiloto = PCC.idPiloto JOIN Clasificaciones C ON PCC.idClasificacion = C.idClasificacion WHERE C.idCarrera = :idCarrera AND PCC.PosicionFinal <> 0 ORDER BY CAST(PCC.PosicionFinal AS UNSIGNED) LIMIT 3")
    List<DTOResultadoTop> getResultadosTopPilotos(Long idCarrera);
}
