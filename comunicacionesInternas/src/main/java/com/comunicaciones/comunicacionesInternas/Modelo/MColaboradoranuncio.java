package com.comunicaciones.comunicacionesInternas.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "colaboradoranuncio")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "consecutivo"
)
public class MColaboradoranuncio
{
    @Id
    @Column(length = 20,nullable = false)
    private String consecutivo;

    @Column(nullable = false)
    private String codanuncio;

    @Column(length = 15, nullable = false)
    private LocalDate fechalectura;

    @Column(length = 10, nullable = false)
    private String leido;

    @ManyToOne
    @JoinColumn(name = "pkcolaborador")
    private MColaborador mColaborador;

    @ManyToOne
    @JoinColumn(name = "pkanuncios")
    private MAnuncios mAnuncios;

    //Constructor

    public MColaboradoranuncio(String consecutivo, String codanuncio, LocalDate fechalectura, String leido, MColaborador mColaborador, MAnuncios mAnuncios) {
        this.consecutivo = consecutivo;
        this.codanuncio = codanuncio;
        this.fechalectura = fechalectura;
        this.leido = leido;
        this.mColaborador = mColaborador;
        this.mAnuncios = mAnuncios;
    }


    //Constructor vacio

    public MColaboradoranuncio()
    {
    }

    //Get and Set


    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getCodanuncio() {
        return codanuncio;
    }

    public void setCodanuncio(String codanuncio) {
        this.codanuncio = codanuncio;
    }

    public LocalDate getFechalectura() {
        return fechalectura;
    }

    public void setFechalectura(LocalDate fechalectura) {
        this.fechalectura = fechalectura;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }

    public MColaborador getmColaborador() {
        return mColaborador;
    }

    public void setmColaborador(MColaborador mColaborador) {
        this.mColaborador = mColaborador;
    }

    public MAnuncios getmAnuncios() {
        return mAnuncios;
    }

    public void setmAnuncios(MAnuncios mAnuncios) {
        this.mAnuncios = mAnuncios;
    }
}
