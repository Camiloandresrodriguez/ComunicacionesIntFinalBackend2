package com.comunicaciones.comunicacionesInternas.Modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "colaborador")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idcolaborador"
)
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
private LocalDate fecharegistro;

@Column(length = 5, nullable = false)
private  String activo;


    @OneToMany(mappedBy = "mColaborador")
    private List<MForo> mForo;

    @OneToMany(mappedBy = "mColaborador")
    private List<MAnuncios> mAnuncios;

    @OneToMany(mappedBy = "mColaborador")
    private List<MComentariosForos> mComentariosForos;

    @OneToMany(mappedBy = "mColaborador")
    private List<MMensajesDirectos> mMensajesDirectos;

    @OneToMany(mappedBy = "mColaborador")
    private List<MColaboradormensaje> mColaboradormensaje;

    @OneToMany(mappedBy = "mColaborador")
    private List<MColaboradoranuncio> mColaboradoranuncio;



//Constructores

    public MColaborador(String idcolaborador, String tipocolaborador, String nombrecolaborador, String apellidocolaborador, String correoelectronico, String clave, LocalDate fecharegistro, String activo, List<MForo> mForo, List<MAnuncios> mAnuncios, List<MColaboradoranuncio> mColaboradoranuncio, List<MComentariosForos> mComentariosForos, List<MColaboradormensaje> mColaboradormensaje, List<MMensajesDirectos> mMensajesDirectos) {
        this.idcolaborador = idcolaborador;
        this.tipocolaborador = tipocolaborador;
        this.nombrecolaborador = nombrecolaborador;
        this.apellidocolaborador = apellidocolaborador;
        this.correoelectronico = correoelectronico;
        this.clave = clave;
        this.fecharegistro = fecharegistro;
        this.activo = activo;
        this.mForo = mForo;
        this.mAnuncios = mAnuncios;
        this.mColaboradoranuncio = mColaboradoranuncio;
        this.mComentariosForos = mComentariosForos;
        this.mColaboradormensaje = mColaboradormensaje;
        this.mMensajesDirectos = mMensajesDirectos;
    }


//Cosntructor vacio

    public MColaborador()
    {
    }

//Get and set


    public String getIdcolaborador() {
        return idcolaborador;
    }

    public void setIdcolaborador(String idcolaborador) {
        this.idcolaborador = idcolaborador;
    }

    public String getTipocolaborador() {
        return tipocolaborador;
    }

    public void setTipocolaborador(String tipocolaborador) {
        this.tipocolaborador = tipocolaborador;
    }

    public String getNombrecolaborador() {
        return nombrecolaborador;
    }

    public void setNombrecolaborador(String nombrecolaborador) {
        this.nombrecolaborador = nombrecolaborador;
    }

    public String getApellidocolaborador() {
        return apellidocolaborador;
    }

    public void setApellidocolaborador(String apellidocolaborador) {
        this.apellidocolaborador = apellidocolaborador;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public LocalDate getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(LocalDate fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<MForo> getmForo() {
        return mForo;
    }

    public void setmForo(List<MForo> mForo) {
        this.mForo = mForo;
    }

    public List<MAnuncios> getmAnuncios() {
        return mAnuncios;
    }

    public void setmAnuncios(List<MAnuncios> mAnuncios) {
        this.mAnuncios = mAnuncios;
    }

    public List<MColaboradoranuncio> getmColaboradoranuncio() {
        return mColaboradoranuncio;
    }

    public void setmColaboradoranuncio(List<MColaboradoranuncio> mColaboradoranuncio) {
        this.mColaboradoranuncio = mColaboradoranuncio;
    }

    public List<MComentariosForos> getmComentariosForos() {
        return mComentariosForos;
    }

    public void setmComentariosForos(List<MComentariosForos> mComentariosForos) {
        this.mComentariosForos = mComentariosForos;
    }

    public List<MColaboradormensaje> getmColaboradormensaje() {
        return mColaboradormensaje;
    }

    public void setmColaboradormensaje(List<MColaboradormensaje> mColaboradormensaje) {
        this.mColaboradormensaje = mColaboradormensaje;
    }

    public List<MMensajesDirectos> getmMensajesDirectos() {
        return mMensajesDirectos;
    }

    public void setmMensajesDirectos(List<MMensajesDirectos> mMensajesDirectos) {
        this.mMensajesDirectos = mMensajesDirectos;
    }
}