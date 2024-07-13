package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.entity.Carrera;
import com.app.api.entity.Clasificacion;

public interface ClasificacionesService {
    
    public List<Clasificacion> getAllClasificaciones();

    public Optional<Clasificacion> getClasificacionById(Long idClasificacion);

    public Carrera getCarreraClasificacion(Long idClasificacion);
}
