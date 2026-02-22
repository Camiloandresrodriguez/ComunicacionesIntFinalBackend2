package com.comunicaciones.comunicacionesInternas.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mensajesdirectos")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codmensaje"
)
public class MMensajesDirectos
{
    @Id
    @Column(length = 20, nullable = false)
    private String codmensaje;

    @Column(length = 70,nullable = false)
    private String titulomensaje;

    @Column(length = 150, nullable = false)
    private String contenidomensaje;

    @Column(length = 15,nullable = false)
    private LocalDate fechacreacion;

    @Column(length = 10,nullable = false)
    private String activo;

    @ManyToOne
    @JoinColumn(name = "pkcolaborador")
    private MColaborador mColaborador;


    //Constructor


    public MMensajesDirectos(String codmensaje, String titulomensaje, String contenidomensaje, LocalDate fechacreacion, String activo, MColaborador mColaborador) {
        this.codmensaje = codmensaje;
        this.titulomensaje = titulomensaje;
        this.contenidomensaje = contenidomensaje;
        this.fechacreacion = fechacreacion;
        this.activo = activo;
        this.mColaborador = mColaborador;
    }

    //Constructor vacio
    public MMensajesDirectos()
    {
    }


    //Get and set


    public String getCodmensaje() {
        return codmensaje;
    }

    public void setCodmensaje(String codmensaje) {
        this.codmensaje = codmensaje;
    }

    public String getTitulomensaje() {
        return titulomensaje;
    }

    public void setTitulomensaje(String titulomensaje) {
        this.titulomensaje = titulomensaje;
    }

    public String getContenidomensaje() {
        return contenidomensaje;
    }

    public void setContenidomensaje(String contenidomensaje) {
        this.contenidomensaje = contenidomensaje;
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
}

