package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.DTO.DTOComentarios;
import com.app.api.DTO.DTOUsuariosSeguidoresYSeguidos;
import com.app.api.entity.Pais;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;
import com.app.api.repository.UsuariosRepository;

public class UsuariosImplService implements UsuariosService{

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return this.usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> getUsuarioById(Long idUsuario) {
        return this.usuariosRepository.findById(idUsuario);
    }

    @Override
    public Pais getPaisUsuario(Long idUsuario) {
        return this.usuariosRepository.getPaisUsuario(idUsuario);
    }

    @Override
    public List<DTOUsuariosSeguidoresYSeguidos> getSeguidoresUsuario(Long idUsuario) {
        return this.usuariosRepository.getSeguidoresUsuario(idUsuario);
    }

    @Override
    public List<DTOUsuariosSeguidoresYSeguidos> getSeguidosUsuario(Long idUsuario) {
        return this.usuariosRepository.getSeguidosUsuario(idUsuario);
    }

    @Override
    public List<Piloto> getPilotosSeguidosUsuario(Long idUsuario) {
        return this.usuariosRepository.getPilotosSeguidosUsuario(idUsuario);
    }

    @Override
    public List<DTOComentarios> getComentariosUsuario(Long idUsuario) {
        return this.usuariosRepository.getComentariosUsuario(idUsuario);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        this.usuariosRepository.deleteById(idUsuario);
    }

    @Override
    public void registrarUsuario(Usuarios usuario) {
        this.usuariosRepository.save(usuario);
    }
}
