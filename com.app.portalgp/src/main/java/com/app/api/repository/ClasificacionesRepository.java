package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Carrera;
import com.app.api.entity.Clasificacion;

@Repository
public interface ClasificacionesRepository extends JpaRepository<Clasificacion, Long>{
    
    @Query("SELECT * FROM Carreras WHERE idCarrera = (SELECT idCarrera FROM Clasificaciones WHERE idClasificacion = :idClasificacion)")
    Carrera getCarreraClasificacion(Long idClasificacion);
}
