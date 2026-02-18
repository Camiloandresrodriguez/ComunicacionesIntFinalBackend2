package com.comunicaciones.comunicacionesInternas.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "colaboradoranuncio")
public class MColaboradoranuncio
{
    @Column(nullable = false)
    private String idcolaborador;

    @Column(nullable = false)
    private String codanuncio;

    @Column(length = 15, nullable = false)
    private String fechalectura;

    @Column(length = 10, nullable = false)
    private String leido;

    //Constructor

    public MColaboradoranuncio(String idcolaborador, String codanuncio, String fechalectura, String leido)
    {
        this.idcolaborador = idcolaborador;
        this.codanuncio = codanuncio;
        this.fechalectura = fechalectura;
        this.leido = leido;
    }

    //Constructor vacio

    public MColaboradoranuncio()
    {
    }

    //Get and Set

    public String  getIdcolaborador()
    {
        return idcolaborador;
    }

    public void setIdcolaborador(String idcolaborador)
    {
        this.idcolaborador = idcolaborador;
    }

    public String getCodanuncio()
    {
        return codanuncio;
    }

    public void setCodanuncio(String codanuncio)
    {
        this.codanuncio = codanuncio;
    }

    public String getFechalectura()
    {
        return fechalectura;
    }

    public void setFechalectura(String fechalectura)
    {
        this.fechalectura = fechalectura;
    }

    public String getLeido()
    {
        return leido;
    }

    public void setLeido(String leido)
    {
        this.leido = leido;
    }
}
