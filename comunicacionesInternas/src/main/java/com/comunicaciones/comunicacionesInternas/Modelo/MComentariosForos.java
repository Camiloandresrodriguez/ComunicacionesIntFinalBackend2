package com.comunicaciones.comunicacionesInternas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentariosforos")
public class MComentariosForos
{
    @Id
    @Column(length = 20,nullable = false)
    private String idcomntario;

    @Column(nullable = false)
    private String idforo;

    @Column(nullable = false)
    private String idcolaborador;

    @Column(length = 250,nullable = false)
    private String contenido;

    @Column(length = 15, nullable = false)
    private String fechapublicaión;

    //Constructor

    public MComentariosForos(String idcomntario, String idforo, String idcolaborador, String contenido, String fechapublicaión)
    {
        this.idcomntario = idcomntario;
        this.idforo = idforo;
        this.idcolaborador = idcolaborador;
        this.contenido = contenido;
        this.fechapublicaión = fechapublicaión;
    }

    //Constructor vacio

    public MComentariosForos()
    {
    }

    //Get and set

    public String getIdcomntario()
    {
        return idcomntario;
    }

    public void setIdcomntario(String idcomntario)
    {
        this.idcomntario = idcomntario;
    }

    public String getIdforo()
    {
        return idforo;
    }

    public void setIdforo(String idforo)
    {
        this.idforo = idforo;
    }

    public String getIdcolaborador()
    {
        return idcolaborador;
    }

    public void setIdcolaborador(String idcolaborador)
    {
        this.idcolaborador = idcolaborador;
    }

    public String getContenido()
    {
        return contenido;
    }

    public void setContenido(String contenido)
    {
        this.contenido = contenido;
    }

    public String getFechapublicaión()
    {
        return fechapublicaión;
    }

    public void setFechapublicaión(String fechapublicaión)
    {
        this.fechapublicaión = fechapublicaión;
    }
}
