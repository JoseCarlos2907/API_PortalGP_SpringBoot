package com.app.api.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.api.DTO.DTOComentarios;
import com.app.api.DTO.DTOUsuariosSeguidoresYSeguidos;
import com.app.api.entity.Pais;
import com.app.api.entity.Piloto;
import com.app.api.entity.Usuarios;

public interface UsuariosService {
    
    public Optional<Usuarios> getUsuarioById(Long idUsuario);

    public List<Usuarios> getAllUsuarios();
    
    public Pais getPaisUsuario(Long idUsuario);
    
    public List<DTOUsuariosSeguidoresYSeguidos> getSeguidoresUsuario(Long idUsuario);

    public List<DTOUsuariosSeguidoresYSeguidos> getSeguidosUsuario(Long idUsuario);

    public List<Piloto> getPilotosSeguidosUsuario(Long idUsuario);

    public List<DTOComentarios> getComentariosUsuario(Long idUsuario);
    
    public Map<String, String> eliminarUsuario();

    public Map<String, String> registrarUsuario();
    
}
