package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.entity.Circuito;
import com.app.api.entity.Pais;
import com.app.api.repository.CircuitosRepository;

public class CircuitosImplService implements CircuitosService{

    @Autowired
    private CircuitosRepository circuitosRepository;

    @Override
    public List<Circuito> getAllCircuitos() {
        return this.circuitosRepository.findAll();
    }

    @Override
    public Optional<Circuito> getCircuitoById(Long idCircuito) {
        return this.circuitosRepository.findById(idCircuito);
    }

    @Override
    public Pais getPaisCircuito(Long idCircuito) {
        return this.circuitosRepository.getPaisCircuito(idCircuito);
    }
    
}
