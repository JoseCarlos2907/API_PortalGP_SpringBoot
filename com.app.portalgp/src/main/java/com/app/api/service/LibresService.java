package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.entity.Carrera;
import com.app.api.entity.Libre;

public interface LibresService {
    
    public List<Libre> getAllLibres();

    public Optional<Libre> getLibreById(Long idLibre);

    public Carrera getCarreraLibre(Long idLibre);
}
