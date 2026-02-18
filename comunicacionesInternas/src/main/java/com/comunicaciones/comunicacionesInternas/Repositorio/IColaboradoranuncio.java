package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaboradoranuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColaboradoranuncio extends JpaRepository<MColaboradoranuncio, String>
{
}
