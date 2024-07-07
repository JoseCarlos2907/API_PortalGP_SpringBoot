package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera")
    private Long idCarrera;

    @Column(name = "Vueltas")
    private int vueltas;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "HoraInicio")
    private String horaInicio;

    @Column(name = "Estado")
    private String estado;

    public Carrera(Long idCarrera, int vueltas, String fecha, String horaInicio, String estado) {
        this.idCarrera = idCarrera;
        this.vueltas = vueltas;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.estado = estado;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
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
}
