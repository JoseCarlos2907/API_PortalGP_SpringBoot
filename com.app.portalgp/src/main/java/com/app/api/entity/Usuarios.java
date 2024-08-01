package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;
    
    @Column(name = "ImgPerfil")
    private String imgPerfil;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "FechaNac")
    private String fechaNac;

    @Column(name = "NombreUsuario")
    private String nombreUsuario;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Rol")
    private String rol;

    @Column(name = "TemaSeleccionado")
    private int temaSeleccionado;

    @Column(name = "idPais")
    private int idPais;

    public Usuarios(String imgPerfil, String nombre, String apellido, String fechaNac,
            String nombreUsuario, String correo, String rol, int temaSeleccionado, int idPais) {
        this.imgPerfil = imgPerfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.rol = rol;
        this.temaSeleccionado = temaSeleccionado;
        this.idPais = idPais;
    }
    

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getTemaSeleccionado() {
        return temaSeleccionado;
    }

    public void setTemaSeleccionado(int temaSeleccionado) {
        this.temaSeleccionado = temaSeleccionado;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    
}
