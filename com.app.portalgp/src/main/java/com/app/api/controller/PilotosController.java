package com.app.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.DTO.DTOBasicoPerfilPiloto;
import com.app.api.DTO.DTOClasificacionPilotosComunidad;
import com.app.api.DTO.DTOClasificacionPilotosOficial;
import com.app.api.DTO.DTOPerfilPiloto;
import com.app.api.DTO.DTOUltimasPosicionesPiloto;
import com.app.api.DTO.DTOUltimosTiemposPiloto;
import com.app.api.entity.Piloto;
import com.app.api.service.PilotosService;

@RestController
@RequestMapping(path = "api/v1/pilotos")
public class PilotosController {
    
    @Autowired
    private PilotosService pilotosService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPilotos(){
        return ResponseEntity.ok(this.pilotosService.getAllPilotos());
    }

    @GetMapping("/{idPiloto}")
    public ResponseEntity<?> getPilotoById(@PathVariable("idPiloto") Long idPiloto){
        Optional<Piloto> piloto = this.pilotosService.getPilotoById(idPiloto);
        if(piloto.isPresent()){
            return ResponseEntity.ok(piloto);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ningun piloto con ese id");

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{idPiloto}/pais")
    public ResponseEntity<?> getPaisPiloto(@PathVariable("idPiloto") Long idPiloto){
        return ResponseEntity.ok(this.pilotosService.getPaisPiloto(idPiloto));
    }

    @GetMapping("/{idPiloto}/coche")
    public ResponseEntity<?> getCochePiloto(@PathVariable("idPiloto") Long idPiloto){
        return ResponseEntity.ok(this.pilotosService.getCochePiloto(idPiloto));
    }

    @GetMapping("/{idPiloto}/usuarios-seguidores")
    public ResponseEntity<?> getUsuariosSeguidoresPiloto(@PathVariable("idPiloto") Long idPiloto){
        return ResponseEntity.ok(this.pilotosService.getUsuariosSeguidoresPiloto(idPiloto));
    }

    @GetMapping("/{idPiloto}/comentarios")
    public ResponseEntity<?> getComentariosPiloto(@PathVariable("idPiloto") Long idPiloto){
        return ResponseEntity.ok(this.pilotosService.getComentariosPiloto(idPiloto));
    }

    @GetMapping("/{idPiloto}/puntuaciones")
    public ResponseEntity<?> getPuntuacionesPiloto(@PathVariable("idPiloto") Long idPiloto){
        
        List<Integer> posiciones = this.pilotosService.getPuntuacionesPiloto(idPiloto);
        List<Integer> puntuaciones = new ArrayList<Integer>();
        HashMap<String, String> response = new HashMap<String,String>();

        if(posiciones.size() < 1){
            response.put("msg", "Este piloto aún no ha saltado a la pista");
            return ResponseEntity.ok(response);
        }

        for (Integer posicion : puntuaciones) {
            Integer puntuacion = 0;

            switch (posicion) {
                case 1:
                    puntuacion = 25;
                    break;
                case 2:
                    puntuacion = 18;
                    break;
                case 3:
                    puntuacion = 15;
                    break;
                case 4:
                    puntuacion = 12;
                    break;
                case 5:
                    puntuacion = 10;
                    break;
                case 6:
                    puntuacion = 8;
                    break;
                case 7:
                    puntuacion = 6;
                    break;
                case 8:
                    puntuacion = 4;
                    break;
                case 9:
                    puntuacion = 2;
                    break;
                case 10:
                    puntuacion = 1;
                    break;
            
                default:
                    puntuacion = 0;
                    break;
            }
            
            puntuaciones.add(puntuacion);
        }
        
        return ResponseEntity.ok(puntuaciones);
    }

    @GetMapping("/{idPiloto}/datos-perfil")
    public ResponseEntity<?> getDatosPerfilPiloto(@PathVariable("idPiloto") Long idPiloto){
        Optional<DTOBasicoPerfilPiloto> datosBasicos = this.pilotosService.getDatosBasicoPerfilPiloto(idPiloto);
        List<DTOUltimasPosicionesPiloto> ultimasPosiciones = this.pilotosService.getUltimasPosicionesPiloto(idPiloto);
        List<DTOUltimosTiemposPiloto> ultimosTiempos = this.pilotosService.getUltimosTiemposPiloto(idPiloto);

        if(datosBasicos.isPresent()){
            DTOPerfilPiloto datosPiloto = new DTOPerfilPiloto(datosBasicos, ultimosTiempos, ultimasPosiciones);
            return ResponseEntity.ok(datosPiloto);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ningun piloto con ese id");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/datos-clasificacion-oficial")
    public ResponseEntity<?> getDatosClasificacionOficial(){
        List<DTOClasificacionPilotosOficial> datosPilotos = this.pilotosService.getDatosClasificacionOficial();
        
        if(datosPilotos.size() > 0){
            return ResponseEntity.ok(datosPilotos);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No hay registros");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/datos-clasificacion-comunidad")
    public ResponseEntity<?> getDatosClasificacionComunidad(){
        List<DTOClasificacionPilotosComunidad> datosPilotos = this.pilotosService.getDatosClasificacionComunidad();
        
        if(datosPilotos.size() > 0){
            return ResponseEntity.ok(datosPilotos);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No hay registros");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/seguir")
    public ResponseEntity<?> seguirPiloto(@RequestBody Long idSeguidor, @RequestBody Long idPiloto){
        this.pilotosService.seguirPiloto(idPiloto, idSeguidor);
        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Solicitud de seguimiento aceptada");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/no-seguir")
    public ResponseEntity<?> dejarDeSeguirPiloto(@RequestBody Long idSeguidor, @RequestBody Long idPiloto){
        this.pilotosService.dejarDeSeguirPiloto(idPiloto, idSeguidor);
        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Solicitud de cancelar seguimiento aceptada");

        return ResponseEntity.ok(response);
    }
}
