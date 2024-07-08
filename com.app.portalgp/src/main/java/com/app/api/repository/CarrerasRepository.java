package com.app.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Carrera;
import com.app.api.entity.Comentario;
import com.app.api.entity.Libre;

@Repository
public interface CarrerasRepository extends JpaRepository<Carrera, Long>{
    
    @Query("SELECT COM.idUsuario AS idUsuario, COM.idPiloto AS idPiloto, COM.idCarrera AS idCarrera, COM.Comentario AS Comentario, U.NombreUsuario AS nombreUsuario, U.ImgPerfil AS imgPerfilUsuario, CONCAT(P.Nombre, ' ', P.Apellido) AS nombrePiloto, P.ImgPerfil AS imgPerfilPiloto, PA.Nombre AS nombrePais FROM Comentarios_Usuarios_Pilotos_Carreras COM JOIN Usuarios U ON COM.idUsuario = U.idUsuario JOIN Pilotos P ON COM.idPiloto = P.idPiloto JOIN Carreras C ON COM.idCarrera = C.idCarrera JOIN Circuitos Cir ON Cir.idCircuito = C.idCircuito JOIN Paises PA ON Cir.idPais = PA.idPais WHERE COM.idCarrera = :idCarrera")
    List<Comentario> getComentariosCarrera(Long idCarrera);

    @Query("SELECT * FROM Libres WHERE idCarrera = :idCarrera")
    List<Libre> getLibresCarrera(Long idCarrera);

    @Query("SELECT * FROM Circuitos WHERE idCircuito = (SELECT idCircuito FROM Carreras WHERE idCarrera = :idCarrera)")
    List<Libre> getCircuitoCarrera(Long idCarrera);

    @Query("SELECT Fecha FROM Carreras")
    List<String> getAllFechas();

    @Query("SELECT C.idCarrera AS id, Ci.ImgSiluetaCircuito AS imgSiluetaCircuito, P.Nombre AS nombrePais, C.Fecha AS fecha, C.HoraInicio AS horaInicio, C.Estado AS estado FROM Carreras C JOIN Circuitos Ci ON Ci.idCircuito = C.idCircuito JOIN Paises P ON P.idPais = Ci.idPais")
    List<Carrera> getListaCarreras();

    @Query("SELECT * FROM Comentarios_Usuarios_Pilotos_Carreras WHERE idUsuario = :idUsuario AND idCarrera = :idCarrera")
    Optional<Comentario> existeComentario(Long idUsuario, Long idCarrera);

    @Query("INSERT INTO Comentarios_Usuarios_Pilotos_Carreras (idPiloto, idCarrera, idUsuario, Comentario) VALUES(:idPiloto, :idCarrera, :idUsuario, :comentario)")
    void comentarEnCarrera(Long idPiloto, Long idCarrera, Long idUsuario, String comentario);
}
