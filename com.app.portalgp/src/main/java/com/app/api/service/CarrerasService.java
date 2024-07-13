package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.DTO.DTOComentarios;
import com.app.api.entity.Carrera;
import com.app.api.entity.Circuito;
import com.app.api.entity.Clasificacion;
import com.app.api.entity.Comentario;
import com.app.api.entity.Libre;

public interface CarrerasService {
    
    public List<Carrera> getAllCarreras();

    public Optional<Carrera> getCarreraById(Long idCarrera);

    public List<Comentario> getComentariosCarrera(Long idCarrera);

    public List<Libre> getLibresCarrera(Long idCarrera);

    public Clasificacion getClasificacionCarrera(Long idCarrera);
    
    public Circuito getCircuitoCarrera(Long idCarrera);

    public List<String> getAllFechas();

    public List<Carrera> getListaCarreras();

    public Optional<DTOComentarios> existeComentario(Long idUsuario, Long idCarrera);

    public void comentarEnCarrera(Long idPiloto, Long idCarrera, Long idUsuario, String comentario);
}
