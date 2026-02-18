package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MComentariosForos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentariosForos extends JpaRepository<MComentariosForos, String>
{

}
