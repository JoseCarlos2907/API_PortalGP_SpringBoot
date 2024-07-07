package com.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Libres")
public class Libre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibre")
    private Long idLibre;

    @Column(name = "NumeroLibre")
    private int numeroLibre;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "HoraInicio")
    private String horaInicio;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "idCarrera")
    private Long idCarrera;

    public Libre(Long idLibre, int numeroLibre, String fecha, String horaInicio, String estado, Long idCarrera) {
        this.idLibre = idLibre;
        this.numeroLibre = numeroLibre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.estado = estado;
        this.idCarrera = idCarrera;
    }

    public Long getIdLibre() {
        return idLibre;
    }

    public void setIdLibre(Long idLibre) {
        this.idLibre = idLibre;
    }

    public int getNumeroLibre() {
        return numeroLibre;
    }

    public void setNumeroLibre(int numeroLibre) {
        this.numeroLibre = numeroLibre;
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
