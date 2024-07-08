package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Carrera;
import com.app.api.entity.Libre;

@Repository
public interface LibresRepository extends JpaRepository<Libre, Long>{
    
    @Query("SELECT * FROM Carreras WHERE idCarrera = (SELECT idCarrera FROM Libres WHERE idLibre = :idCarrera)")
    Carrera getCarreraLibre(Long idCarrera);

}
