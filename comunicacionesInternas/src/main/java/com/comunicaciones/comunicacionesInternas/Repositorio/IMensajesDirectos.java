package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MMensajesDirectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMensajesDirectos extends JpaRepository<MMensajesDirectos, String>
{
    List<MMensajesDirectos>findBytitulomensaje(String titulomensaje);
}
