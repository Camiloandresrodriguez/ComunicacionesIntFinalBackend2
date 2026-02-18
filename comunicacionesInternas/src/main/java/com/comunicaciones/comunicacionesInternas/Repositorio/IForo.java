package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IForo extends JpaRepository<MForo, String>
{
    List<MForo>findBytitulo(String titulo);
}
