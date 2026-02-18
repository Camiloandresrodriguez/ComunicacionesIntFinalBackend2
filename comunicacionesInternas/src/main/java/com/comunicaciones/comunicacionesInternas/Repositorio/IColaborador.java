package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColaborador extends JpaRepository<MColaborador, String>
{
    List<MColaborador>findByNombrecolaborador(String nombrecolaborador);
}
