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
import com.app.api.entity.ResultadosClasificaciones;
import com.app.api.service.ResultadosClasificacionesService;

@RestController
@RequestMapping(path = "api/v1/resultados-clasificaciones")
public class ResultadosClasificacionesController {

    @Autowired
    private ResultadosClasificacionesService resultadosClasificacionesService;

    @GetMapping("/{idClasificacion}")
    public ResponseEntity<?> getResultadosByIdClasificacion(@PathVariable("idClasificacion") Long idClasificacion){
        List<ResultadosClasificaciones> resultados = this.resultadosClasificacionesService.getResultadosClasifiacionesByIdClasificacion(idClasificacion);
        if(resultados.size() > 0){
            return ResponseEntity.ok(resultados);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Este evento aún no se ha efectuado");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idClasificacion}/piloto/{idPiloto}")
    public ResponseEntity<?> getResultadosByIdPiloto(@PathVariable("idClasificacion") Long idClasificacion, @PathVariable("idPiloto") Long idPiloto){
        Optional<ResultadosClasificaciones> resultados = this.resultadosClasificacionesService.getResultadoClasificacionByIdPiloto(idClasificacion, idPiloto);
        if(resultados.isPresent()){
            return ResponseEntity.ok(resultados);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Este evento aún no se ha efectuado");

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{idCarrera}/top")
    public ResponseEntity<?> getTopPilotos(@PathVariable("idCarrera") Long idCarrera){
        Optional<DTOFechaYHora> datos = this.resultadosClasificacionesService.getFechaYHoraTopPilotos(idCarrera);
        if(!datos.isPresent()){
            HashMap<String, String> response = new HashMap<String,String>();
            response.put("msg", "Este evento aún no se ha efectuado");

            return ResponseEntity.ok(response);
        }

        DTOFechaYHora datosFinales = datos.get();
        datosFinales.setTiempos(this.resultadosClasificacionesService.getResultadosTopPilotos(idCarrera));

        return ResponseEntity.ok(datosFinales);
    }
}
