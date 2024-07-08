package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;

@Repository
public interface CochesRepository extends JpaRepository<Coche, Long>{
    
    @Query("SELECT * FROM Escuderias WHERE idEscuderia = (SELECT idEscuderia FROM Coches WHERE idCoche = :idCoche)")
    Escuderia getEscuderiaCoche(Long idCoche);
}
