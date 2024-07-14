package com.app.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Clasificacion;
import com.app.api.service.ClasificacionesService;

@RestController
@RequestMapping(path = "api/v1/clasificaciones")
public class ClasificacionesController {
    
    @Autowired
    private ClasificacionesService clasificacionesService;

    @GetMapping("/")
    public ResponseEntity<?> getAllClasificaciones(){
        return ResponseEntity.ok(this.clasificacionesService.getAllClasificaciones());
    }

    @GetMapping("/{idClasificacion}")
    public ResponseEntity<?> getClasificacionById(@PathVariable("idClasificacion") Long idClasificacion){
        Optional<Clasificacion> clasificacion = this.clasificacionesService.getClasificacionById(idClasificacion);
        if(clasificacion.isPresent()){
            return ResponseEntity.ok(clasificacion);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ninguna clasificación con ese id");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idClasificacion}/carrera")
    public ResponseEntity<?> getCarreraClasificacion(@PathVariable("idClasificacion") Long idClasificacion){
        return ResponseEntity.ok(this.clasificacionesService.getCarreraClasificacion(idClasificacion));
    }
}
