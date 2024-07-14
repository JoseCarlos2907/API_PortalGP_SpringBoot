package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Pais;
import com.app.api.repository.PaisesRepository;

@Service
public class PaisesService{

    @Autowired
    private PaisesRepository paisesRepository;

    public List<Pais> getAllPaises() {
        return this.paisesRepository.findAll();
    }

    public Optional<Pais> getPaisById(Long idPais) {
        return this.paisesRepository.findById(idPais);
    }
    
}
