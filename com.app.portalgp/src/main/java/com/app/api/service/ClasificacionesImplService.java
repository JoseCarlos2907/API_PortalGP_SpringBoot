package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.entity.Carrera;
import com.app.api.entity.Clasificacion;
import com.app.api.repository.ClasificacionesRepository;

public class ClasificacionesImplService implements ClasificacionesService{

    @Autowired
    private ClasificacionesRepository clasificacionesRepository;

    @Override
    public List<Clasificacion> getAllClasificaciones() {
        return this.clasificacionesRepository.findAll();
    }

    @Override
    public Optional<Clasificacion> getClasificacionById(Long idClasificacion) {
        return this.clasificacionesRepository.findById(idClasificacion);
    }

    @Override
    public Carrera getCarreraClasificacion(Long idClasificacion) {
        return this.clasificacionesRepository.getCarreraClasificacion(idClasificacion);
    }
    
}
