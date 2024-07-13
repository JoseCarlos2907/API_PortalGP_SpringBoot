package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.entity.Pais;
import com.app.api.repository.PaisesRepository;

public class PaisesImplService implements PaisesService{

    @Autowired
    private PaisesRepository paisesRepository;

    @Override
    public List<Pais> getAllPaises() {
        return this.paisesRepository.findAll();
    }

    @Override
    public Optional<Pais> getPaisById(Long idPais) {
        return this.paisesRepository.findById(idPais);
    }
    
}
