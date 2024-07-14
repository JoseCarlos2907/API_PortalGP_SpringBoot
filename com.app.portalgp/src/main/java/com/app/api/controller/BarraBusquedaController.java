package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.service.BarraBusquedaService;

@RestController
@RequestMapping(path = "api/v1/buscar")
public class BarraBusquedaController {
    
    @Autowired
    private BarraBusquedaService barraBusquedaService;

    @PostMapping("/")
    public ResponseEntity<?> busqueda(@RequestBody String cadena){
        return ResponseEntity.ok(this.barraBusquedaService.busqueda(cadena));
    }
}
