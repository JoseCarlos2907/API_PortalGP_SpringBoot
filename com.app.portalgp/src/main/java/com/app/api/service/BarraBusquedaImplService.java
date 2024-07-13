package com.app.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.DTO.DTOBusqueda;
import com.app.api.entity.Escuderia;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;
import com.app.api.repository.EscuderiasRepository;
import com.app.api.repository.PilotosRepository;
import com.app.api.repository.UsuariosRepository;

public class BarraBusquedaImplService implements BarraBusquedaService{

    @Autowired
    private EscuderiasRepository escuderiasRepository;
    
    @Autowired
    private PilotosRepository pilotosRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public DTOBusqueda busqueda(String cadena) {
        int cantidad = 5;
        DTOBusqueda busqueda = new DTOBusqueda();
        List<Piloto> pilotosBusqueda = this.pilotosRepository.getPilotosBarraBusqueda(cadena);
        cantidad -= pilotosBusqueda.size();

        if(cantidad > 0){
            busqueda.setPilotos(pilotosBusqueda);
            
            return busqueda;
        }


        List<Escuderia> escuderiasBusqueda = this.escuderiasRepository.getEscuderiasBarraBusqueda(cadena, cantidad);
        cantidad -= escuderiasBusqueda.size();

        if(cantidad > 0){
            busqueda.setPilotos(pilotosBusqueda);
            busqueda.setEscuderias(escuderiasBusqueda);

            return busqueda;
        }


        List<Usuarios> usuariosBusqueda = this.usuariosRepository.getUsuariosBarraBusqueda(cadena, cantidad);
        cantidad -= usuariosBusqueda.size();

        if(cantidad > 0){
            busqueda.setPilotos(pilotosBusqueda);
            busqueda.setEscuderias(escuderiasBusqueda);
            busqueda.setUsuarios(usuariosBusqueda);

            return busqueda;
        }

        return busqueda;
    }
    
}
