package com.app.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Circuito;
import com.app.api.service.CircuitosService;

@RestController
@RequestMapping(path = "api/v1/circuitos")
public class CircuitosController {
    
    @Autowired
    private CircuitosService circuitosService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCircuitor(){
        return ResponseEntity.ok(this.circuitosService.getAllCircuitos());
    }

    @GetMapping("/{idCircuito}")
    public ResponseEntity<?> getCircuitoById(@PathVariable("idCircuito") Long idCircuito){
        Optional<Circuito> circuito = this.circuitosService.getCircuitoById(idCircuito);
        if(circuito.isPresent()){
            return ResponseEntity.ok(circuito);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ningun circuito con ese id");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCircuito}/pais")
    public ResponseEntity<?> getPaisCircuito(@PathVariable("idCircuito") Long idCircuito){
        return ResponseEntity.ok(this.circuitosService.getPaisCircuito(idCircuito));
    }
}
