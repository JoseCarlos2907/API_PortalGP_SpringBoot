package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.DTO.DTOComentarios;
import com.app.api.DTO.DTOUsuariosSeguidoresYSeguidos;
import com.app.api.entity.Pais;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;
import com.app.api.repository.UsuariosRepository;

@Service
public class UsuariosService{

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuarios> getAllUsuarios() {
        return this.usuariosRepository.findAll();
    }

    public Optional<Usuarios> getUsuarioByEmail(String email) {
        return this.usuariosRepository.getUsuarioByEmail(email);
    }

    public Optional<Usuarios> getUsuarioById(Long idUsuario) {
        return this.usuariosRepository.findById(idUsuario);
    }

    public Pais getPaisUsuario(Long idUsuario) {
        return this.usuariosRepository.getPaisUsuario(idUsuario);
    }

    public List<DTOUsuariosSeguidoresYSeguidos> getSeguidoresUsuario(Long idUsuario) {
        return this.usuariosRepository.getSeguidoresUsuario(idUsuario);
    }

    public List<DTOUsuariosSeguidoresYSeguidos> getSeguidosUsuario(Long idUsuario) {
        return this.usuariosRepository.getSeguidosUsuario(idUsuario);
    }

    public List<Piloto> getPilotosSeguidosUsuario(Long idUsuario) {
        return this.usuariosRepository.getPilotosSeguidosUsuario(idUsuario);
    }

    public List<DTOComentarios> getComentariosUsuario(Long idUsuario) {
        return this.usuariosRepository.getComentariosUsuario(idUsuario);
    }

    public void seguirPilotoRegistro(Long idUsuario, Long idPiloto){
        this.usuariosRepository.seguirPilotoRegistro(idUsuario, idPiloto);
    }
    
    public void cambiarDatosPrincipales(String nombreUsuario, String nombre, String apellidos, String imgPerfil, String correo){
        this.cambiarDatosPrincipales(nombreUsuario, nombre, apellidos, imgPerfil, correo);
    }

    public void cambiarTemaSeleccionadoUsuarioByEmail(int temaSeleccionado, String email){
        this.cambiarTemaSeleccionadoUsuarioByEmail(temaSeleccionado, email);
    }

    public void seguirUsuario(Long idSeguidor, Long idSeguido){
        this.usuariosRepository.seguirUsuario(idSeguidor, idSeguido);
    }
    
    public void dejarDeSeguirUsuario(Long idSeguidor, Long idSeguido){
        this.usuariosRepository.dejarDeSeguirUsuario(idSeguidor, idSeguido);
    }
    public void getUsuariosBarraBusqueda(String cadena, int cantidad){
        this.usuariosRepository.getUsuariosBarraBusqueda(cadena, cantidad);
    }

    public void eliminarUsuario(Long idUsuario) {
        this.usuariosRepository.deleteById(idUsuario);
    }

    public void registrarUsuario(Usuarios usuario) {
        this.usuariosRepository.save(usuario);
    }
}
