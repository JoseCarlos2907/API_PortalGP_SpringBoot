package com.app.api.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.DTO.DTOComentarios;
import com.app.api.DTO.DTOUsuariosSeguidoresYSeguidos;
import com.app.api.entity.Pais;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{

    Optional<Usuarios> getUsuarioByEmail(String email);
    
    @Query("SELECT * FROM Paises WHERE IdPais = (SELECT IdPais FROM Usuarios WHERE IdUsuario = :idUsuario")
    Pais getPaisUsuario(Long idUsuario);

    @Query("SELECT * FROM Usuarios_Siguen_Usuarios USU JOIN Usuarios U ON USU.idUsuario1 = U.idUsuario WHERE USU.idUsuario2 = :idUsuario")
    List<DTOUsuariosSeguidoresYSeguidos> getSeguidoresUsuario(Long idUsuario);

    @Query("SELECT COUNT(Comentario) AS numComentarios FROM Comentarios_Usuarios_Pilotos_Carreras WHERE idUsuario = :idUsuario")
    int getNumSeguidores(Long idUsuario);

    @Query("SELECT * FROM Usuarios_Siguen_Usuarios USU JOIN Usuarios U ON USU.idUsuario2 = U.idUsuario WHERE USU.idUsuario1 = :idUsuario")
    List<DTOUsuariosSeguidoresYSeguidos> getSeguidosUsuario(Long idUsuario);

    @Query("SELECT COUNT(Comentario) AS numComentarios FROM Comentarios_Usuarios_Pilotos_Carreras WHERE idUsuario = :idUsuario")
    int getNumSeguidos(Long idUsuario);

    @Query("SELECT * FROM Usuarios_Siguen_Pilotos USU JOIN Pilotos P ON P.idPiloto = USU.idPiloto WHERE USU.idUsuario = :idUsuario")
    List<Piloto> getPilotosSeguidosUsuario(Long idUsuario);

    @Query("SELECT COM.idUsuario AS idUsuario, COM.idPiloto AS idPiloto, COM.idCarrera AS idCarrera, COM.Comentario AS Comentario, U.NombreUsuario AS nombreUsuario, CONCAT(P.Nombre, ' ', P.Apellido) AS nombrePiloto, PA.Nombre AS nombrePais, U.ImgPerfil AS imgPerfilUsuario, P.ImgPerfil AS imgPerfilPiloto FROM Comentarios_Usuarios_Pilotos_Carreras COM JOIN Usuarios U ON COM.idUsuario = U.idUsuario JOIN Pilotos P ON COM.idPiloto = P.idPiloto JOIN Carreras C ON COM.idCarrera = C.idCarrera JOIN Circuitos Cir ON Cir.idCircuito = C.idCircuito JOIN Paises PA ON Cir.idPais = PA.idPais WHERE U.idUsuario = :idUsuario")
    List<DTOComentarios> getComentariosUsuario(Long idUsuario);

    @Query("INSERT INTO Usuarios_Siguen_Pilotos (idUsuario, idPiloto) VALUES (:idUsuario, :idPiloto)")
    HashMap<String, String> seguirPilotoRegistro(Long idUsuario, Long idPiloto);

    @Query("UPDATE Usuarios SET NombreUsuario = ':nombreUsuario', Nombre = ':nombre', Apellidos = ':apellidos', ImgPerfil = ':imgPerfil' WHERE Correo = ':correo'")
    HashMap<String, String> cambiarDatosPrincipales(String nombreUsuario, String nombre, String apellidos, String imgPerfil, String correo);

    @Query("UPDATE Usuarios SET TemaSeleccionado = :temaSeleccionado WHERE Correo = ':correo'")
    HashMap<String, String> cambiarTemaSeleccionadoUsuarioByEmail(int temaSeleccionado, String email);

    @Query("INSERT INTO Usuarios_Siguen_Usuarios (idUsuario1, idUsuario2) VALUES (:idSeguidor, :idSeguido)")
    HashMap<String, String> seguirUsuario(Long idSeguidor, Long idSeguido);

    @Query("DELETE FROM Usuarios_Siguen_Usuarios WHERE idUsuario1 = :idSeguidor AND idUsuario2 = :idSeguido")
    HashMap<String, String> dejarDeSeguirUsuario(Long idSeguidor, Long idSeguido);
}
