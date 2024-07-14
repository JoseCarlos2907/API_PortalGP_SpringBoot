package com.app.api.controller;

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

import com.app.api.DTO.DTOComentarios;
import com.app.api.entity.Carrera;
import com.app.api.entity.Comentario;
import com.app.api.service.CarrerasService;

@RestController
@RequestMapping(path = "api/v1/carreras")
public class CarrerasController {
    
    @Autowired
    private CarrerasService carrerasService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCarreras(){
        return ResponseEntity.ok(this.carrerasService.getAllCarreras());
    }

    @GetMapping("/{idCarrera}")
    public ResponseEntity<?> getCarreraById(@PathVariable("idCarrera") Long idCarrera){
        Optional<Carrera> carrera = this.carrerasService.getCarreraById(idCarrera);
        if(carrera.isPresent()){
            return ResponseEntity.ok(carrera);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ninguna carrera con ese id");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCarrera}/comentarios")
    public ResponseEntity<?> getComentariosCarrera(@PathVariable("idCarrera") Long idCarrera){
        List<Comentario> comentarios = this.carrerasService.getComentariosCarrera(idCarrera);
        
        if(comentarios.size() > 0){
            return ResponseEntity.ok(comentarios);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Esta carrera no tiene comentarios");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCarrera}/libres")
    public ResponseEntity<?> getLibresCarrera(@PathVariable("idCarrera") Long idCarrera){
        return ResponseEntity.ok(this.carrerasService.getLibresCarrera(idCarrera));
    }

    @GetMapping("/{idCarrera}/clasificacion")
    public ResponseEntity<?> getClasificacionCarrera(@PathVariable("idCarrera") Long idCarrera){
        return ResponseEntity.ok(this.carrerasService.getClasificacionCarrera(idCarrera));
    }

    @GetMapping("/{idCarrera}/circuito")
    public ResponseEntity<?> getCircuitoCarrera(@PathVariable("idCarrera") Long idCarrera){
        return ResponseEntity.ok(this.carrerasService.getCircuitoCarrera(idCarrera));
    }

    @GetMapping("/fechas")
    public ResponseEntity<?> getAllFechas(){
        return ResponseEntity.ok(this.carrerasService.getAllFechas());
    }
    
    @GetMapping("/lista-carreras")
    public ResponseEntity<?> getListaCarreras(){
        return ResponseEntity.ok(this.carrerasService.getListaCarreras());
    }

    @PostMapping("/{idCarrera}/comentar")
    public ResponseEntity<?> comentarCarrera(@PathVariable("idCarrera") Long idCarrera, @RequestBody Long idPiloto, @RequestBody Long idUsuario, @RequestBody String comentario){
        
        Optional<DTOComentarios> busquedaComentario = this.carrerasService.existeComentario(idUsuario, idCarrera);
        HashMap<String, String> response = new HashMap<String,String>();

        if(!busquedaComentario.isPresent()){

            this.carrerasService.comentarEnCarrera(idPiloto, idCarrera, idUsuario, comentario);
            
            response.put("msg", "Comentario publicado");
            return ResponseEntity.ok(response);
        }

        response.put("msg", "El usuario ya ha comentado en esta carrera");
        return ResponseEntity.ok(response);
    }
}
