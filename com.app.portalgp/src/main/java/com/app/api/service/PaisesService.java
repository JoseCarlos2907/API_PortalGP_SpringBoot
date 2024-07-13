package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.entity.Pais;

public interface PaisesService {
    
    public List<Pais> getAllPaises();

    public Optional<Pais> getPaisById(Long idPais);
}
