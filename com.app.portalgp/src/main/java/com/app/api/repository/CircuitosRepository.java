package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Circuito;
import com.app.api.entity.Pais;

@Repository
public interface CircuitosRepository extends JpaRepository<Circuito, Long>{
    
    @Query("SELECT * FROM Paises WHERE IdPais = (SELECT IdPais FROM Circuitos WHERE IdCircuito = :idCircuito)")
    Pais getPaisCircuito(Long idCircuito);
}
