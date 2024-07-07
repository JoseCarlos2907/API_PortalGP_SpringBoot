package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Clasificaciones")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClasificacion")
    private Long idClasificacion;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "HoraInicio")
    private String horaInicio;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "idCarrera")
    private Long idCarrera;

    public Clasificacion(Long idClasificacion, String fecha, String horaInicio, String estado, Long idCarrera) {
        this.idClasificacion = idClasificacion;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.estado = estado;
        this.idCarrera = idCarrera;
    }

    public Long getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    
}
