package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Pais;

@Repository
public interface PaisesRepository extends JpaRepository<Pais, Long>{
    
}
