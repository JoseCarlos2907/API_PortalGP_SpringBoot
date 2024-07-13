package com.app.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.DTO.DTOClasificacionEscuderias;
import com.app.api.DTO.DTOPerfilEscuderia;
import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;
import com.app.api.entity.Pais;


@Repository
public interface EscuderiasRepository extends JpaRepository<Escuderia, Long>{
    
    @Query("SELECT * FROM Paises WHERE IdPais = (SELECT IdPais FROM Escuderias WHERE IdEscuderia = :idEscuderia)")
    Pais getPaisEscuderia(Long idEscuderia);

    @Query("SELECT * FROM Coches WHERE IdEscuderia = :idEscuderia")
    Coche getCocheEscuderia(Long idEscuderia);

    @Query("SELECT E.idEscuderia AS idEscuderia, E.imgLogo AS imgLogo, E.Nombre AS nombre, E.Puntuacion AS puntosTotales, P.CountryCode AS paisCC, P.Nombre AS nombrePais FROM Escuderias E JOIN Paises P ON P.idPais = E.idPais")
    List<DTOClasificacionEscuderias> getDatosEscuderiasClasificacionOficial();

    @Query("SELECT E.Nombre AS nombre,E.imgLogo,E.imgEscuderia,E.Descripcion AS descripcion,C.ImgPrincipal AS imgPrincipal,C.SegundaImg AS segundaImg,C.TerceraImg AS terceraImg,C.CuartaImg AS cuartaImg FROM Escuderias E JOIN Coches C ON C.idEscuderia = E.idEscuderia WHERE E.idEscuderia = :idEscuderia")
    Optional<DTOPerfilEscuderia> getDatosPerfilEscuderia(Long idEscuderia);

    @Query("SELECT * FROM Escuderias WHERE Nombre LIKE '%:cadena%' ORDER BY Nombre ASC LIMIT :cantidad")
    List<Escuderia> getEscuderiasBarraBusqueda(String cadena, int cantidad);
}
