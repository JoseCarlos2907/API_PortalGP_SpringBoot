package com.app.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.Usuarios;
import com.app.api.service.UsuariosService;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsuarios(){
        return ResponseEntity.ok(this.usuariosService.getAllUsuarios());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("idUsuario") Long idUsuario){
        Optional<Usuarios> usuario = this.usuariosService.getUsuarioById(idUsuario);
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "No existe ningun usuario con ese id");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idUsuario}/pais")
    public ResponseEntity<?> getPaisUsuario(@PathVariable("idUsuario") Long idUsuario){
        return ResponseEntity.ok(this.usuariosService.getPaisUsuario(idUsuario));
    }

    
}
