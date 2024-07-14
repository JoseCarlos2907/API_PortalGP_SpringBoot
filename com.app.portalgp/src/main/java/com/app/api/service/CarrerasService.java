package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.DTO.DTOComentarios;
import com.app.api.entity.Carrera;
import com.app.api.entity.Circuito;
import com.app.api.entity.Clasificacion;
import com.app.api.entity.Comentario;
import com.app.api.entity.Libre;
import com.app.api.repository.CarrerasRepository;

@Service
public class CarrerasService{

    @Autowired
    private CarrerasRepository carrerasRepository;

    public List<Carrera> getAllCarreras() {
        return this.carrerasRepository.findAll();
    }

    public Optional<Carrera> getCarreraById(Long idCarrera) {
        return this.carrerasRepository.findById(idCarrera);
    }

    public List<Comentario> getComentariosCarrera(Long idCarrera) {
        return this.getComentariosCarrera(idCarrera);
    }

    public List<Libre> getLibresCarrera(Long idCarrera) {
        return this.carrerasRepository.getLibresCarrera(idCarrera);
    }

    public Clasificacion getClasificacionCarrera(Long idCarrera) {
        return this.carrerasRepository.getClasificacionCarrera(idCarrera);
    }

    public Circuito getCircuitoCarrera(Long idCarrera) {
        return this.carrerasRepository.getCircuitoCarrera(idCarrera);
    }

    public List<String> getAllFechas() {
        return this.carrerasRepository.getAllFechas();
    }

    public List<Carrera> getListaCarreras() {
        return this.carrerasRepository.getListaCarreras();
    }

    public Optional<DTOComentarios> existeComentario(Long idUsuario, Long idCarrera) {
        return this.carrerasRepository.existeComentario(idUsuario, idCarrera);
    }

    public void comentarEnCarrera(Long idPiloto, Long idCarrera, Long idUsuario, String comentario) {
        this.carrerasRepository.comentarEnCarrera(idPiloto, idCarrera, idUsuario, comentario);
    }
    
}
