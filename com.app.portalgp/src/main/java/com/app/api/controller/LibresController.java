package com.app.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Libre;
import com.app.api.service.LibresService;

@RestController
@RequestMapping(path = "api/v1/libres")
public class LibresController {
    
    @Autowired
    private LibresService libresService;

    @GetMapping("/")
    public ResponseEntity<?> getAllLibres(){
        return ResponseEntity.ok(this.libresService.getAllLibres());
    }

    @GetMapping("/{idLibre}")
    public ResponseEntity<?> getLibreById(@PathVariable("idLibre") Long idLibre){
        Optional<Libre> libre = this.libresService.getLibreById(idLibre);
        if(libre.isPresent()){
            return ResponseEntity.ok(libre);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ningun libre con ese id");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idLibre}/carrera")
    public ResponseEntity<?> getCarreraLibre(@PathVariable("idLibre") Long idLibre){
        return ResponseEntity.ok(this.libresService.getCarreraLibre(idLibre));
    }
}
