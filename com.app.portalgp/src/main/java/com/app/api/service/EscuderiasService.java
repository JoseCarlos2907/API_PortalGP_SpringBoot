package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.DTO.DTOClasificacionEscuderias;
import com.app.api.DTO.DTOPerfilEscuderia;
import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;
import com.app.api.entity.Pais;
import com.app.api.repository.EscuderiasRepository;

@Service
public class EscuderiasService{
    
    @Autowired
    private EscuderiasRepository escuderiasRepository;

    public List<Escuderia> getAllEscuderias() {
        return this.escuderiasRepository.findAll();
    }

    public Optional<Escuderia> getEscuderiaById(Long idEscuderia) {
        return this.escuderiasRepository.findById(idEscuderia);
    }

    public Pais getPaisEscuderia(Long idEscuderia) {
        return this.escuderiasRepository.getPaisEscuderia(idEscuderia);
    }

    public Coche getCocheEscuderia(Long idEscuderia) {
        return this.escuderiasRepository.getCocheEscuderia(idEscuderia);
    }

    public List<DTOClasificacionEscuderias> getDatosEscuderiasClasificacionOficial() {
        return this.escuderiasRepository.getDatosEscuderiasClasificacionOficial();
    }

    public Optional<DTOPerfilEscuderia> getDatosPefilEscuderia(Long idEscuderia) {
        return this.escuderiasRepository.getDatosPerfilEscuderia(idEscuderia);
    }

    public List<Escuderia> getEscuderiasBarraBusqueda(String cadena, int cantidad) {
        return this.escuderiasRepository.getEscuderiasBarraBusqueda(cadena, cantidad);
    }
}
