package com.comunicaciones.comunicacionesInternas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "colaboradormensaje")
public class MColaboradormensaje
{
    @Column(nullable = false)
    private String idcolaborador;

    @Column(nullable = false)
    private String codmensaje;

    @Column(length = 15,nullable = false)
    private String fechamensaje;

    @Column(length = 10, nullable = false)
    private String activo;

    //Constructor
    public MColaboradormensaje(String idcolaborador, String codmensaje, String fechamensaje, String activo)
    {
        this.idcolaborador = idcolaborador;
        this.codmensaje = codmensaje;
        this.fechamensaje = fechamensaje;
        this.activo = activo;
    }

    //Cosntructor vacio


    public MColaboradormensaje()
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

    public String getCodmensaje()
    {
        return codmensaje;
    }

    public void setCodmensaje(String codmensaje)
    {
        this.codmensaje = codmensaje;
    }

    public String getFechamensaje()
    {
        return fechamensaje;
    }

    public void setFechamensaje(String fechamensaje)
    {
        this.fechamensaje = fechamensaje;
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
