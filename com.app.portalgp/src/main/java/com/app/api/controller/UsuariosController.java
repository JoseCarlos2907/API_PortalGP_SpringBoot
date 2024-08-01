package com.app.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{idUsuario}/usuarios-seguidores")
    public ResponseEntity<?> getSeguidoresUsuario(@PathVariable("idUsuario") Long idUsuario){
        return ResponseEntity.ok(this.usuariosService.getSeguidoresUsuario(idUsuario));
    }

    @GetMapping("/{idUsuario}/usuarios-seguidos")
    public ResponseEntity<?> getSeguidosUsuario(@PathVariable("idUsuario") Long idUsuario){
        return ResponseEntity.ok(this.usuariosService.getSeguidosUsuario(idUsuario));
    }

    @GetMapping("/{idUsuario}/pilotos-seguidos")
    public ResponseEntity<?> getPilotosSeguidosUsuario(@PathVariable("idUsuario") Long idUsuario){
        return ResponseEntity.ok(this.usuariosService.getPilotosSeguidosUsuario(idUsuario));
    }

    @GetMapping("/{idUsuario}/comentarios")
    public ResponseEntity<?> getComentariosUsuario(@PathVariable("idUsuario") Long idUsuario){
        return ResponseEntity.ok(this.usuariosService.getComentariosUsuario(idUsuario));
    }

    @PostMapping("/gbe")
    public ResponseEntity<?> getUsuarioByEmail(@RequestBody String email){
        return ResponseEntity.ok(this.usuariosService.getUsuarioByEmail(email));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(
        @RequestBody String nombre,
        @RequestBody String imgPerfil,
        @RequestBody String apellidos,
        @RequestBody String fechaNac,
        @RequestBody String nombreUsuario,
        @RequestBody String correo,
        @RequestBody String rol,
        @RequestBody int temaSeleccionado,
        @RequestBody int idPais
    
    ){
        this.usuariosService.registrarUsuario(new Usuarios(imgPerfil, nombre, apellidos, fechaNac, nombreUsuario, correo, rol, temaSeleccionado, idPais));
        
        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Usuario registrado correctamente");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(
        @RequestBody String correo,
        @RequestBody List<Long> pilotos
    ){
        Usuarios usuario = this.usuariosService.getUsuarioByEmail(correo).get();

        for(Long idPiloto: pilotos){
            this.usuariosService.seguirPilotoRegistro(usuario.getIdUsuario(), idPiloto);
        }

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Todo correcto👌 (Registrao)");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/cambiar-datos-principales")
    public ResponseEntity<?> cambiarDatosPrincipales(
        @RequestBody String nombreUsuario,
        @RequestBody String nombre,
        @RequestBody String apellidos,
        @RequestBody String imgPerfil,
        @RequestBody String correo
    ){
        this.usuariosService.cambiarDatosPrincipales(nombreUsuario, nombre, apellidos, imgPerfil, correo);
    
        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Todo correcto👌");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/cambiar-datos-principales")
    public ResponseEntity<?> cambiarTemaSeleccionadoUsuarioByEmail(
        @RequestBody int temaSeleccionado,
        @RequestBody String correo
    ){
        this.usuariosService.cambiarTemaSeleccionadoUsuarioByEmail(temaSeleccionado, correo);
    
        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Todo correcto👌");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/eliminar/{idUsuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("idUsuario") Long idUsuario){
        this.usuariosService.eliminarUsuario(idUsuario);
        
        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Todo correcto👌 (Eliminao)");
    
        return ResponseEntity.ok(response);
    }

    @PostMapping("/seguir")
    public ResponseEntity<?> seguirUsuario(@RequestBody Long idSeguidor, @RequestBody Long idSeguido){
        this.seguirUsuario(idSeguidor, idSeguido);

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Todo correcto👌 (Seguio)");
    
        return ResponseEntity.ok(response);
    }

    @PostMapping("/no-seguir")
    public ResponseEntity<?> dejarDeSeguirUsuario(@RequestBody Long idSeguidor, @RequestBody Long idSeguido){
        this.dejarDeSeguirUsuario(idSeguidor, idSeguido);

        HashMap<String, String> response = new HashMap<String,String>();
        response.put("msg", "Todo correcto👌 (Seguio)");
    
        return ResponseEntity.ok(response);
    }
}
