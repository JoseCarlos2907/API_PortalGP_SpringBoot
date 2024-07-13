package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.DTO.DTOComentarios;
import com.app.api.entity.Carrera;
import com.app.api.entity.Circuito;
import com.app.api.entity.Clasificacion;
import com.app.api.entity.Comentario;
import com.app.api.entity.Libre;
import com.app.api.repository.CarrerasRepository;

public class CarrerasImplService implements CarrerasService{

    @Autowired
    private CarrerasRepository carrerasRepository;

    @Override
    public List<Carrera> getAllCarreras() {
        return this.carrerasRepository.findAll();
    }

    @Override
    public Optional<Carrera> getCarreraById(Long idCarrera) {
        return this.carrerasRepository.findById(idCarrera);
    }

    @Override
    public List<Comentario> getComentariosCarrera(Long idCarrera) {
        return this.getComentariosCarrera(idCarrera);
    }

    @Override
    public List<Libre> getLibresCarrera(Long idCarrera) {
        return this.carrerasRepository.getLibresCarrera(idCarrera);
    }

    @Override
    public Clasificacion getClasificacionCarrera(Long idCarrera) {
        return this.carrerasRepository.getClasificacionCarrera(idCarrera);
    }

    @Override
    public Circuito getCircuitoCarrera(Long idCarrera) {
        return this.carrerasRepository.getCircuitoCarrera(idCarrera);
    }

    @Override
    public List<String> getAllFechas() {
        return this.carrerasRepository.getAllFechas();
    }

    @Override
    public List<Carrera> getListaCarreras() {
        return this.carrerasRepository.getListaCarreras();
    }

    @Override
    public Optional<DTOComentarios> existeComentario(Long idUsuario, Long idCarrera) {
        return this.carrerasRepository.existeComentario(idUsuario, idCarrera);
    }

    @Override
    public void comentarEnCarrera(Long idPiloto, Long idCarrera, Long idUsuario, String comentario) {
        this.carrerasRepository.comentarEnCarrera(idPiloto, idCarrera, idUsuario, comentario);
    }
    
}
