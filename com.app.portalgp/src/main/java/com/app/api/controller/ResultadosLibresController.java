package com.app.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.DTO.DTOFechaYHoraLibre;
import com.app.api.DTO.DTOResultadosLibres;
import com.app.api.service.ResultadosLibresService;

@RestController
@RequestMapping(path = "api/v1/resultados-libres")
public class ResultadosLibresController {
    @Autowired
    private ResultadosLibresService resultadosLibresService;

    @GetMapping("/{idLibre}")
    public ResponseEntity<?> getResultadosByIdLibre(@PathVariable Long idLibre){
        List<DTOResultadosLibres> resultados = this.resultadosLibresService.getResultadosLibres(idLibre);
        if(resultados.size() > 0){
            return ResponseEntity.ok(resultados);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Este evento aún no se ha efectuado");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idLibre}/piloto/{idPiloto}")
    public ResponseEntity<?> getResultadosByIdPiloto(@PathVariable Long idLibre, @PathVariable Long idPiloto){
        Optional<DTOResultadosLibres> resultados = this.resultadosLibresService.getResultadoLibreByIdPiloto(idLibre, idPiloto);
        if(resultados.isPresent()){
            return ResponseEntity.ok(resultados);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Este evento aún no se ha efectuado");

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{idCarrera}/top")
    public ResponseEntity<?> getTopPilotos(@PathVariable Long idCarrera){
        List<DTOFechaYHoraLibre> datos = this.resultadosLibresService.getFechaYHoraLibresTopPilotos(idCarrera);
        if(datos.size() < 1){
            HashMap<String, String> response = new HashMap<String,String>();
            response.put("msg", "Este evento aún no se ha efectuado");

            return ResponseEntity.ok(response);
        }

        for(DTOFechaYHoraLibre fyh : datos){
            fyh.setTiempos(this.resultadosLibresService.getResultadosTopPilotos(idCarrera, fyh.getNumeroLibre()));
        }

        return ResponseEntity.ok(datos);
    }
}
