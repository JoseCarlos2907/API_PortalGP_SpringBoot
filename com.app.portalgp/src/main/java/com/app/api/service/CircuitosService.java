package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Circuito;
import com.app.api.entity.Pais;
import com.app.api.repository.CircuitosRepository;

@Service
public class CircuitosService{

    @Autowired
    private CircuitosRepository circuitosRepository;

    public List<Circuito> getAllCircuitos() {
        return this.circuitosRepository.findAll();
    }

    public Optional<Circuito> getCircuitoById(Long idCircuito) {
        return this.circuitosRepository.findById(idCircuito);
    }

    public Pais getPaisCircuito(Long idCircuito) {
        return this.circuitosRepository.getPaisCircuito(idCircuito);
    }
    
}
