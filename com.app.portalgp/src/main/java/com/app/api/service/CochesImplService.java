package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;
import com.app.api.repository.CochesRepository;

public class CochesImplService implements CochesService{
    
    @Autowired
    private CochesRepository cochesRepository;

    @Override
    public List<Coche> getAllCoches() {
        return this.cochesRepository.findAll();
    }

    @Override
    public Optional<Coche> getCocheById(Long idCoche) {
        return this.cochesRepository.findById(idCoche);
    }

    @Override
    public Escuderia getEscuderiaCoche(Long idCoche) {
        return this.cochesRepository.getEscuderiaCoche(idCoche);
    }
}
