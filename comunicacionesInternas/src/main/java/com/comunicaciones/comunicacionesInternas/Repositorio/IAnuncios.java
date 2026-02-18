package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MAnuncios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnuncios extends JpaRepository<MAnuncios, String>
{
    List<MAnuncios>findBytitulo(String titulo);
}
