package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.entity.Circuito;
import com.app.api.entity.Pais;

public interface CircuitosService {
    
    public List<Circuito> getAllCircuitos();

    public Optional<Circuito> getCircuitoById(Long idCircuito);

    public Pais getPaisCircuito(Long idCircuito);
}
