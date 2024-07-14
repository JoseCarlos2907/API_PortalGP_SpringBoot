package com.app.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Pais;
import com.app.api.service.PaisesService;

@RestController 
@RequestMapping(path = "api/v1/paises")
public class PaisesController {
    
    @Autowired
    private PaisesService paisesService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPaises(){
        return ResponseEntity.ok(this.paisesService.getAllPaises());
    }

    @GetMapping("/{idPais}")
    public ResponseEntity<?> getPaisById(@PathVariable("idPais") Long idPais){
        Optional<Pais> pais = this.paisesService.getPaisById(idPais);
        if(pais.isPresent()){
            return ResponseEntity.ok(pais);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ningun país con ese id");

        return ResponseEntity.ok(response);
    }
}
