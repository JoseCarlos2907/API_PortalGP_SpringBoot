package com.app.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Coche;
import com.app.api.service.CochesService;

@RestController
@RequestMapping(path = "api/v1/coches")
public class CochesController {
    
    @Autowired
    private CochesService cochesService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCoches(){
        return ResponseEntity.ok(this.cochesService.getAllCoches());
    }

    @GetMapping("/{idCoche}")
    public ResponseEntity<?> getCocheById(@PathVariable("idCoche") Long idCoche){
        Optional<Coche> coche = this.cochesService.getCocheById(idCoche);
        if(coche.isPresent()){
            return ResponseEntity.ok(coche);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ningun coche con ese id");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCoche}/escuderia")
    public ResponseEntity<?> getEscuderiaCoche(@PathVariable("idCoche") Long idCoche){
        return ResponseEntity.ok(this.cochesService.getEscuderiaCoche(idCoche));
    }
}
