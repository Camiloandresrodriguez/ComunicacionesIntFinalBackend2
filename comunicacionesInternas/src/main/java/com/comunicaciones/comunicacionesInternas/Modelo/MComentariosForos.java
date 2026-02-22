package com.comunicaciones.comunicacionesInternas.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "comentariosforos")

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idcomentario"
)
public class MComentariosForos
{
    @Id
    @Column(length = 20,nullable = false)
    private String idcomentario;

    @Column(length = 250,nullable = false)
    private String contenido;

    @Column(length = 15, nullable = false)
    private LocalDate fechapublicaion;

    @Column(length = 10,nullable = false)
    private String activo;

    @ManyToOne
    @JoinColumn(name = "pkcolaborador")
    private MColaborador mColaborador;

    @ManyToOne
    @JoinColumn(name = "pkforo")
    private MForo mForo;

    //Constructor


    public MComentariosForos(String idcomentario, String contenido, LocalDate fechapublicaion, String activo, MColaborador mColaborador, MForo mForo) {
        this.idcomentario = idcomentario;
        this.contenido = contenido;
        this.fechapublicaion = fechapublicaion;
        this.activo = activo;
        this.mColaborador = mColaborador;
        this.mForo = mForo;
    }

    //Constructor vacio
    public MComentariosForos()
    {
    }

    //Get and set


    public String getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(String idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechapublicaion() {
        return fechapublicaion;
    }

    public void setFechapublicaion(LocalDate fechapublicaion) {
        this.fechapublicaion = fechapublicaion;
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

    public MForo getmForo() {
        return mForo;
    }

    public void setmForo(MForo mForo) {
        this.mForo = mForo;
    }
}
