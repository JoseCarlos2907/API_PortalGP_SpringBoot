package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;

public interface CochesService {
    
    public List<Coche> getAllCoches();

    public Optional<Coche> getCocheById(Long idCoche);

    public Escuderia getEscuderiaCoche(Long idCoche);
}
