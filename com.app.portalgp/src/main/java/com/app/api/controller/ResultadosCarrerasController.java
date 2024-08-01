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

import com.app.api.DTO.DTOFechaYHora;
import com.app.api.entity.ResultadosCarreras;
import com.app.api.service.ResultadosCarrerasService;

@RestController
@RequestMapping(path = "api/v1/resultados-carreras")
public class ResultadosCarrerasController {
    
    @Autowired
    private ResultadosCarrerasService resultadosCarrerasService;

    @GetMapping("/{idCarrera}")
    public ResponseEntity<?> getResultadosByIdCarrera(@PathVariable("idCarrera") Long idCarrera){
        List<ResultadosCarreras> resultados = this.resultadosCarrerasService.getResultadosCarrreraByIdCarrera(idCarrera);
        if(resultados.size() > 0){
            return ResponseEntity.ok(resultados);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Este evento aún no se ha efectuado");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCarrera}/piloto/{idPiloto}")
    public ResponseEntity<?> getResultadosByIdPiloto(@PathVariable("idCarrera") Long idCarrera, @PathVariable("idPiloto") Long idPiloto){
        Optional<ResultadosCarreras> resultados = this.resultadosCarrerasService.getResultadoCarreraByIdPiloto(idCarrera, idPiloto);
        if(resultados.isPresent()){
            return ResponseEntity.ok(resultados);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Este evento aún no se ha efectuado");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCarrera}/top")
    public ResponseEntity<?> getTopPilotos(@PathVariable("idCarrera") Long idCarrera){
        Optional<DTOFechaYHora> datos = this.resultadosCarrerasService.getFechaYHoraTopPilotos(idCarrera);
        if(!datos.isPresent()){
            HashMap<String, String> response = new HashMap<String,String>();
            response.put("msg", "Este evento aún no se ha efectuado");

            return ResponseEntity.ok(response);
        }

        DTOFechaYHora datosFinales = datos.get();
        datosFinales.setTiempos(this.resultadosCarrerasService.getResultadosTopPilotos(idCarrera));

        return ResponseEntity.ok(datosFinales);
    }
}
