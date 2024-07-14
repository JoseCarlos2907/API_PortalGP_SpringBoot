package com.app.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Escuderia;
import com.app.api.service.EscuderiasService;

@RestController
@RequestMapping(path = "api/v1/escuderias")
public class EscuderiasController {
    
    @Autowired
    private EscuderiasService escuderiasService;

    @GetMapping("/")
    public ResponseEntity<?> getAllEscuderias(){
        return ResponseEntity.ok(this.escuderiasService.getAllEscuderias());
    }

    @GetMapping("/{idEscuderia}")
    public ResponseEntity<?> getEscuderiaById(@PathVariable("idEscuderia") Long idEscuderia){
        Optional<Escuderia> escuderia = this.escuderiasService.getEscuderiaById(idEscuderia);
        if(escuderia.isPresent()){
            return ResponseEntity.ok(escuderia);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ninguna escuderia con ese id");

        return ResponseEntity.ok(response);
    }
}
