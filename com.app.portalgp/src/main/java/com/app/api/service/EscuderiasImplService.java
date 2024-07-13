package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.DTO.DTOClasificacionEscuderias;
import com.app.api.DTO.DTOPerfilEscuderia;
import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;
import com.app.api.entity.Pais;
import com.app.api.repository.EscuderiasRepository;

public class EscuderiasImplService implements EscuderiasService{
    
    @Autowired
    private EscuderiasRepository escuderiasRepository;

    @Override
    public List<Escuderia> getAllEscuderias() {
        return this.escuderiasRepository.findAll();
    }

    @Override
    public Optional<Escuderia> getEscuderiaById(Long idEscuderia) {
        return this.escuderiasRepository.findById(idEscuderia);
    }

    @Override
    public Pais getPaisEscuderia(Long idEscuderia) {
        return this.escuderiasRepository.getPaisEscuderia(idEscuderia);
    }

    @Override
    public Coche getCocheEscuderia(Long idEscuderia) {
        return this.escuderiasRepository.getCocheEscuderia(idEscuderia);
    }

    @Override
    public List<DTOClasificacionEscuderias> getDatosEscuderiasClasificacionOficial() {
        return this.escuderiasRepository.getDatosEscuderiasClasificacionOficial();
    }

    @Override
    public Optional<DTOPerfilEscuderia> getDatosPefilEscuderia(Long idEscuderia) {
        return this.escuderiasRepository.getDatosPerfilEscuderia(idEscuderia);
    }

    @Override
    public List<Escuderia> getEscuderiasBarraBusqueda(String cadena, int cantidad) {
        return this.escuderiasRepository.getEscuderiasBarraBusqueda(cadena, cantidad);
    }
}
