package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;
import com.app.api.repository.CochesRepository;

@Service
public class CochesService{
    
    @Autowired
    private CochesRepository cochesRepository;

    public List<Coche> getAllCoches() {
        return this.cochesRepository.findAll();
    }

    public Optional<Coche> getCocheById(Long idCoche) {
        return this.cochesRepository.findById(idCoche);
    }

    public Escuderia getEscuderiaCoche(Long idCoche) {
        return this.cochesRepository.getEscuderiaCoche(idCoche);
    }
}
