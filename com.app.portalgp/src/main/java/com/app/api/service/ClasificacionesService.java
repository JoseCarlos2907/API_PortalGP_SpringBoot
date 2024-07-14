package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Carrera;
import com.app.api.entity.Clasificacion;
import com.app.api.repository.ClasificacionesRepository;

@Service
public class ClasificacionesService{

    @Autowired
    private ClasificacionesRepository clasificacionesRepository;

    public List<Clasificacion> getAllClasificaciones() {
        return this.clasificacionesRepository.findAll();
    }

    public Optional<Clasificacion> getClasificacionById(Long idClasificacion) {
        return this.clasificacionesRepository.findById(idClasificacion);
    }

    public Carrera getCarreraClasificacion(Long idClasificacion) {
        return this.clasificacionesRepository.getCarreraClasificacion(idClasificacion);
    }
    
}
