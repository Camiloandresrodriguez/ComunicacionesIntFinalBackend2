package com.comunicaciones.comunicacionesInternas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "colaborador")
public class MColaborador
{
@Id
@Column(name = "idcolaborador", nullable = false)
private String idcolaborador;

@Column(length = 50, nullable = false)
private String tipocolaborador;

@Column(length = 100,nullable = false)
private String nombrecolaborador;

@Column(length = 120, nullable = false)
private String apellidocolaborador;

@Column(length = 30, nullable = false)
private String correoelectronico;

@Column(length = 30, nullable = false)
private String clave;

@Column(length = 15, nullable = false)
private String fecharegistro;

@Column(length = 5, nullable = false)
private  String activo;

//Relaciones:

//Constructores

    public MColaborador(String idcolaborador, String tipocolaborador, String nombrecolaborador, String apellidocolaborador, String correoelectronico, String clave, String fecharegistro, String activo)
    {
        this.idcolaborador = idcolaborador;
        this.tipocolaborador = tipocolaborador;
        this.nombrecolaborador = nombrecolaborador;
        this.apellidocolaborador = apellidocolaborador;
        this.correoelectronico = correoelectronico;
        this.clave = clave;
        this.fecharegistro = fecharegistro;
        this.activo = activo;
    }

//Cosntructor vacio

    public MColaborador()
    {
    }

//Get and set

    public String getIdcolaborador()
    {
        return idcolaborador;
    }

    public void setIdcolaborador(String idcolaborador)
    {
        this.idcolaborador = idcolaborador;
    }

    public String getTipocolaborador()
    {
        return tipocolaborador;
    }

    public void setTipocolaborador(String tipocolaborador)
    {
        this.tipocolaborador = tipocolaborador;
    }

    public String getNombrecolaborador()
    {
        return nombrecolaborador;
    }

    public void setNombrecolaborador(String nombrecolaborador)
    {
        this.nombrecolaborador = nombrecolaborador;
    }

    public String getApellidocolaborador() {
        return apellidocolaborador;
    }

    public void setApellidocolaborador(String apellidocolaborador)
    {
        this.apellidocolaborador = apellidocolaborador;
    }

    public String getCorreoelectronico()
    {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico)
    {
        this.correoelectronico = correoelectronico;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }

    public String getFecharegistro()
    {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro)
    {
        this.fecharegistro = fecharegistro;
    }

    public String getActivo()
    {
        return activo;
    }

    public void setActivo(String activo)
    {
        this.activo = activo;
    }
}