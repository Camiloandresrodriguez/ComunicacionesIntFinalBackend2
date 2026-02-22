package com.comunicaciones.comunicacionesInternas.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "anuncios")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codanuncio"

)
public class MAnuncios
{
    @Id
    @Column(length = 20,nullable = false)
    private String codanuncio;

    @Column(length = 70,nullable = false)
    private String titulo;

    @Column(length = 150,nullable = false)
    private String contenido;

    @Column(length = 15,nullable = false)
    private LocalDate fechapublicacion;

    @Column(length = 10,nullable = false)
    private String activo;

    @ManyToOne
    @JoinColumn(name = "pkcolaborador")
    private MColaborador mColaborador;

    @OneToMany(mappedBy = "mAnuncios")
    private List<MColaboradoranuncio> mColaboradoranuncio;


    //contructor


    public MAnuncios(String codanuncio, String titulo, String contenido, LocalDate fechapublicacion, String activo, MColaborador mColaborador, List<MColaboradoranuncio> mColaboradoranuncio) {
        this.codanuncio = codanuncio;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechapublicacion = fechapublicacion;
        this.activo = activo;
        this.mColaborador = mColaborador;
        this.mColaboradoranuncio = mColaboradoranuncio;
    }

    //Constructor vacio
    public MAnuncios()
    {
    }

    //Get and Set


    public String getCodanuncio() {
        return codanuncio;
    }

    public void setCodanuncio(String codanuncio) {
        this.codanuncio = codanuncio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(LocalDate fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
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

    public List<MColaboradoranuncio> getmColaboradoranuncio() {
        return mColaboradoranuncio;
    }

    public void setmColaboradoranuncio(List<MColaboradoranuncio> mColaboradoranuncio) {
        this.mColaboradoranuncio = mColaboradoranuncio;
    }
}
