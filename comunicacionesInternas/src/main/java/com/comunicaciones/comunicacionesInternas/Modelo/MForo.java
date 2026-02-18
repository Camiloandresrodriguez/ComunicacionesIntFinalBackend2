package com.comunicaciones.comunicacionesInternas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MForo
{
    @Id
    @Column(length = 20, nullable = false)
    private String idforo;

    @Column(length = 70, nullable = false)
    private String titulo;

    @Column(length = 150,nullable = false)
    private String descripcion;

    @Column(length = 15,nullable = false)
    private String fechacreacion;

    @Column(nullable = false)
    private String idcolaborador;

    //Constructor

    public MForo(String idforo, String titulo, String descripcion, String fechacreacion, String idcolaborador)
    {
        this.idforo = idforo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.idcolaborador = idcolaborador;
    }

    //Constructor vacio
    public MForo()
    {
    }

    //Get and set

    public String getIdforo()
    {
        return idforo;
    }

    public void setIdforo(String idforo)
    {
        this.idforo = idforo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion)
    {
        this.fechacreacion = fechacreacion;
    }

    public String getIdcolaborador()
    {
        return idcolaborador;
    }

    public void setIdcolaborador(String idcolaborador)
    {
        this.idcolaborador = idcolaborador;
    }
}

