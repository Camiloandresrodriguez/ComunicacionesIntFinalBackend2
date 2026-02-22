package com.comunicaciones.comunicacionesInternas.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idforo"
)
public class MForo {
    @Id
    @Column(length = 20, nullable = false)
    private String idforo;

    @Column(length = 70, nullable = false)
    private String titulo;

    @Column(length = 150, nullable = false)
    private String descripcion;

    @Column(length = 15, nullable = false)
    private LocalDate fechacreacion;

    @Column(length = 10, nullable = false)
    private String activo;

    @ManyToOne
    @JoinColumn(name = "pkcolaborador")
    private MColaborador mColaborador;

    @OneToMany(mappedBy = "mForo")
    private List<MComentariosForos> mComentariosForos;


    //Constructor


    public MForo(String idforo, String titulo, String descripcion, LocalDate fechacreacion, String activo, MColaborador mColaborador, List<MComentariosForos> mComentariosForos) {
        this.idforo = idforo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.activo = activo;
        this.mColaborador = mColaborador;
        this.mComentariosForos = mComentariosForos;
    }

    //Constructor vacio
    public MForo() {
    }

    //Get and set


    public String getIdforo() {
        return idforo;
    }

    public void setIdforo(String idforo) {
        this.idforo = idforo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public MColaborador getmColaborador() {
        return mColaborador;
    }

    public void setmColaborador(MColaborador mColaborador) {
        this.mColaborador = mColaborador;
    }

    public List<MComentariosForos> getmComentariosForos() {
        return mComentariosForos;
    }

    public void setmComentariosForos(List<MComentariosForos> mComentariosForos) {
        this.mComentariosForos = mComentariosForos;
    }
}


