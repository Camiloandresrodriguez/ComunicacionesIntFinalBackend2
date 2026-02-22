package com.comunicaciones.comunicacionesInternas.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "colaboradormensaje")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "consecutivo"
)
public class MColaboradormensaje
{
    @Id
    @Column(length = 20,nullable = false)
    private String consecutivo;

    @Column(nullable = false)
    private String codmensaje;

    @Column(length = 15,nullable = false)
    private LocalDate fechamensaje;

    @Column(length = 10, nullable = false)
    private String activo;

    @ManyToOne
    @JoinColumn(name = "pkcolaborador")
    private MColaborador mColaborador;

    //Constructor

    public MColaboradormensaje(String consecutivo, String codmensaje, LocalDate fechamensaje, String activo, MColaborador mColaborador) {
        this.consecutivo = consecutivo;
        this.codmensaje = codmensaje;
        this.fechamensaje = fechamensaje;
        this.activo = activo;
        this.mColaborador = mColaborador;
    }


    //Cosntructor vacio

    public MColaboradormensaje()
    {
    }

    //Get and set


    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getCodmensaje() {
        return codmensaje;
    }

    public void setCodmensaje(String codmensaje) {
        this.codmensaje = codmensaje;
    }

    public LocalDate getFechamensaje() {
        return fechamensaje;
    }

    public void setFechamensaje(LocalDate fechamensaje) {
        this.fechamensaje = fechamensaje;
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
}
