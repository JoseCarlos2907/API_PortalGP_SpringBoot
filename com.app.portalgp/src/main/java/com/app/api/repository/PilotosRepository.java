package com.app.api.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.DTO.DTOBasicoPerfilPiloto;
import com.app.api.DTO.DTOClasificacionPilotosComunidad;
import com.app.api.DTO.DTOClasificacionPilotosOficial;
import com.app.api.DTO.DTOComentarios;
import com.app.api.DTO.DTOUltimasPosicionesPiloto;
import com.app.api.DTO.DTOUltimosTiemposPiloto;
import com.app.api.entity.Coche;
import com.app.api.entity.Pais;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;

@Repository
public interface PilotosRepository extends JpaRepository<Piloto, Long>{
    
    @Query("SELECT * FROM Paises WHERE IdPais = (SELECT IdPais FROM Pilotos WHERE IdPiloto = :idPiloto)")
    Pais getPaisPiloto(Long idPiloto);

    @Query("SELECT * FROM Coches WHERE IdCoche = (SELECT IdCoche FROM Pilotos WHERE IdPiloto = :idPiloto)")
    Coche getCochePiloto(Long idPiloto);

    @Query("LECT * FROM Usuarios_Siguen_Pilotos USP JOIN Usuarios U ON USP.idUsuario = U.idUsuario WHERE USP.idPiloto = :idPiloto")
    List<Usuarios> getUsuariosSeguidoresPiloto(Long idPiloto);

    @Query("SELECT * FROM Comentarios_Usuarios_Pilotos_Carreras WHERE idPiloto = :idPiloto")
    List<DTOComentarios> getComentariosPiloto(Long idPiloto);

    @Query("SELECT P.idPiloto AS idPiloto, P.Nombre AS nombre, P.Apellido AS apellido, P.ImgPerfil AS imgPerfil, P.Puntuacion AS puntosTotales, E.Nombre AS nombreEscuderia, PA.CountryCode AS paisCC, PA.Nombre AS nombrePais FROM  Pilotos P JOIN  Coches C ON P.idCoche = C.idCoche JOIN  Escuderias E ON C.idEscuderia = E.idEscuderia JOIN  Paises PA ON P.idPais = PA.idPais ORDER BY puntosTotales DESC")
    List<DTOClasificacionPilotosOficial> getDatosClasificacion();

    @Query("SELECT P.idPiloto AS idPiloto, P.Nombre AS nombre, P.Apellido AS apellido, P.ImgPerfil AS imgPerfil, COUNT(CM.Comentario) AS votosTotales, E.Nombre AS nombreEscuderia, PA.CountryCode AS paisCC FROM Pilotos P JOIN Coches C ON P.idCoche = C.idCoche JOIN Escuderias E ON C.idEscuderia = E.idEscuderia JOIN Paises PA ON P.idPais = PA.idPais LEFT JOIN Comentarios_Usuarios_Pilotos_Carreras CM ON P.idPiloto = CM.idPiloto GROUP BY P.idPiloto, P.Nombre, P.Apellido, P.ImgPerfil, E.Nombre, PA.CountryCode ORDER BY votosTotales DESC")
    List<DTOClasificacionPilotosComunidad> getDatosClasificacionComunidad();

    @Query("SELECT R.PosicionFinal FROM Carreras C JOIN Pilotos_Corren_Carreras R ON C.idCarrera = R.idCarrera WHERE R.idPiloto = :idPiloto")
    List<Integer> getPuntuacionesPiloto(Long idPiloto);

    @Query("SELECT P.ImgPerfil AS imgPerfil, C.ImgPrincipal AS imgCoche, CONCAT(P.Nombre, ' ', P.Apellido) AS nombreCompleto, P.FechaNac AS fechaNac, P.Altura AS altura, P.Peso AS peso, P.Numero AS numero, E.Nombre AS nombreEscuderia FROM Pilotos P JOIN Coches C ON C.idCoche = P.idCoche JOIN Escuderias E ON E.idEscuderia = (SELECT idEscuderia FROM Coches C WHERE C.idCoche = P.idCoche) WHERE P.idPiloto = :idPiloto")
    Optional<DTOBasicoPerfilPiloto> getDatosBasicoPerfilPiloto(Long idPiloto);

    @Query("SELECT 'Carrera' AS tipo, PCC.idPiloto, C.fecha, C.HoraInicio, NULL AS numeroLibre, CONCAT(C.fecha, ' ', C.HoraInicio) AS fecha_hora, PCC.TiempoTotalEnCarrera AS tiempo, P.nombre AS nombre_pais FROM  Pilotos_Corren_Carreras PCC JOIN  Carreras C ON PCC.idCarrera = C.idCarrera JOIN  Circuitos CI ON C.idCircuito = CI.idCircuito JOIN  Paises P ON CI.idPais = P.idPais WHERE  PCC.idPiloto = 0 UNION ALL SELECT 'Libres' AS tipo,PCL.idPiloto,L.fecha,L.HoraInicio,L.NumeroLibre AS numeroLibre,CONCAT(L.fecha, ' ', L.HoraInicio) AS fecha_hora,PCL.TiempoVueltaMasRapida AS tiempo, P.nombre AS nombre_pais FROM  Pilotos_Corren_Libres PCL JOIN  Libres L ON PCL.idLibre = L.idLibre JOIN  Carreras C ON L.idCarrera = C.idCarrera JOIN  Circuitos CI ON C.idCircuito = CI.idCircuito JOIN  Paises P ON CI.idPais = P.idPais WHERE  PCL.idPiloto = 0 UNION ALL SELECT 'Clasificacion' AS tipo,PCCL.idPiloto,CL.fecha,CL.HoraInicio,NULL AS numeroLibre,CONCAT(CL.fecha, ' ', CL.HoraInicio) AS fecha_hora,PCCL.TiempoVueltaMasRapida AS tiempo,P.nombre AS nombre_pais FROM  Pilotos_Corren_Clasificacion PCCL JOIN  Clasificaciones CL ON PCCL.idClasificacion = CL.idClasificacion JOIN  Carreras C ON CL.idCarrera = C.idCarrera JOIN Circuitos CI ON C.idCircuito = CI.idCircuito JOIN Paises P ON CI.idPais = P.idPais WHERE  PCCL.idPiloto = :idPiloto ORDER BY  STR_TO_DATE(fecha_hora, '%d-%m-%Y %H:%i:%s') DESC LIMIT 3")
    List<DTOUltimosTiemposPiloto> getUltimosTiemposPiloto(Long idPiloto);

    @Query("SELECT 'Carrera' AS tipo, PCC.idPiloto, C.fecha, C.HoraInicio, NULL AS numeroLibre, CONCAT(C.fecha, ' ', C.HoraInicio) AS fecha_hora, PCC.PosicionFinal AS ultima_posicion, P.nombre AS nombre_pais FROM  Pilotos_Corren_Carreras PCC JOIN  Carreras C ON PCC.idCarrera = C.idCarrera JOIN  Circuitos CI ON C.idCircuito = CI.idCircuito JOIN  Paises P ON CI.idPais = P.idPais WHERE  PCC.idPiloto = $id UNION ALL SELECT  'Libres' AS tipo, PCL.idPiloto, L.fecha, L.HoraInicio, L.NumeroLibre AS numeroLibre, CONCAT(L.fecha, ' ', L.HoraInicio) AS fecha_hora, PCL.PosicionFinal AS ultima_posicion, P.nombre AS nombre_pais FROM  Pilotos_Corren_Libres PCL JOIN  Libres L ON PCL.idLibre = L.idLibre JOIN  Carreras C ON L.idCarrera = C.idCarrera JOIN  Circuitos CI ON C.idCircuito = CI.idCircuito JOIN  Paises P ON CI.idPais = P.idPais WHERE  PCL.idPiloto = $id UNION ALL SELECT  'Clasificacion' AS tipo, PCCL.idPiloto, CL.fecha, CL.HoraInicio, NULL AS numeroLibre, CONCAT(CL.fecha, ' ', CL.HoraInicio) AS fecha_hora, PCCL.PosicionFinal AS ultima_posicion, P.nombre AS nombre_pais FROM  Pilotos_Corren_Clasificacion PCCL JOIN  Clasificaciones CL ON PCCL.idClasificacion = CL.idClasificacion JOIN  Carreras C ON CL.idCarrera = C.idCarrera JOIN  Circuitos CI ON C.idCircuito = CI.idCircuito JOIN  Paises P ON CI.idPais = P.idPais WHERE  PCCL.idPiloto = :idPiloto ORDER BY  STR_TO_DATE(fecha_hora, '%d-%m-%Y %H:%i:%s') DESC LIMIT 3")
    List<DTOUltimasPosicionesPiloto> getUltimasPosicionesPiloto(Long idPiloto);

    @Query("INSERT INTO Usuarios_Siguen_Pilotos (idUsuario, idPiloto) VALUES (:idSeguidor, :idPiloto)")
    HashMap<String, String> seguirPiloto(Long idPiloto, Long idSeguidor);

    @Query("DELETE FROM Usuarios_Siguen_Pilotos WHERE idUsuario = :idSeguidor AND idPiloto = :idPiloto")
    HashMap<String, String> dejarDeSeguirPiloto(Long idPiloto, Long idSeguidor);

    @Query("SELECT * FROM Pilotos WHERE Nombre LIKE '%:cadena%' OR Apellido LIKE '%:cadena%' ORDER BY Nombre ASC, Apellido ASC LIMIT 5")
    List<Piloto> getPilotosBarraBusqueda(String cadena);
}
