package com.app.api.service;

import java.util.List;
import java.util.Optional;

import com.app.api.DTO.DTOClasificacionEscuderias;
import com.app.api.DTO.DTOPerfilEscuderia;
import com.app.api.entity.Coche;
import com.app.api.entity.Escuderia;
import com.app.api.entity.Pais;

public interface EscuderiasService {
    
    public List<Escuderia> getAllEscuderias();

    public Optional<Escuderia> getEscuderiaById(Long idEscuderia);

    public Pais getPaisEscuderia(Long idEscuderia);

    public Coche getCocheEscuderia(Long idEscuderia);

    public List<DTOClasificacionEscuderias> getDatosEscuderiasClasificacionOficial();

    public Optional<DTOPerfilEscuderia> getDatosPefilEscuderia(Long idEscuderia);

    public List<Escuderia> getEscuderiasBarraBusqueda(String cadena, int cantidad);
}
