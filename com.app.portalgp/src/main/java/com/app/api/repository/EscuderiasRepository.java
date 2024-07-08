package com.app.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;
import com.app.api.entity.Pais;

class DTOClasificacionEscuderias{
    public Long idEscuderia;
    public String imgLogo;
    public String nombre;
    public int puntosTotales;
    public String paisCC;
    public String nombrePais;
}

class DTOPerfilEscuderia{
    public String nombre;
    public String imgLogo;
    public String imgEscuderia;
    public String descripcion;
    public String imgPrincipal;
    public String segundaImg;
    public String terceraImg;
    public String cuartaImg;
}

@Repository
public interface EscuderiasRepository extends JpaRepository<Escuderia, Long>{
    
    @Query("SELECT * FROM Paises WHERE IdPais = (SELECT IdPais FROM Escuderias WHERE IdEscuderia = :idEscuderia)")
    Pais getPaisEscuderia(Long idEscuderia);

    @Query("SELECT * FROM Coches WHERE IdEscuderia = :idEscuderia")
    Coche getCocheEscuderia(Long idEscuderia);

    @Query("SELECT E.idEscuderia AS idEscuderia, E.imgLogo AS imgLogo, E.Nombre AS nombre, E.Puntuacion AS puntosTotales, P.CountryCode AS paisCC, P.Nombre AS nombrePais FROM Escuderias E JOIN Paises P ON P.idPais = E.idPais")
    List<DTOClasificacionEscuderias> getDatosEscuderiasClasificacionOficial();

    @Query("SELECT E.Nombre AS nombre,E.imgLogo,E.imgEscuderia,E.Descripcion AS descripcion,C.ImgPrincipal AS imgPrincipal,C.SegundaImg AS segundaImg,C.TerceraImg AS terceraImg,C.CuartaImg AS cuartaImg FROM Escuderias E JOIN Coches C ON C.idEscuderia = E.idEscuderia WHERE E.idEscuderia = :idEscuderia")
    DTOPerfilEscuderia getDatosPerfilEscuderia(Long idEscuderia);
}
