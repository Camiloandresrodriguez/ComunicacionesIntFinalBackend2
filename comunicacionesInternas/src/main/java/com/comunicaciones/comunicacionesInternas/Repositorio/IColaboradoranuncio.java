package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaboradoranuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IColaboradoranuncio extends JpaRepository<MColaboradoranuncio, String>
{
    @Query(value = "SELECT a.codanuncio, a.titulo, a.contenido, a.fechapublicacion, a.idcolaborador, c.nombrecolaborador"
    + "FROM anuncios a INNER JOIN colaborador c ON a.idcolaborador = c.idcolaborador where idcolaborador = id",nativeQuery = true)
    List<Map<String, Object>> buscarPorIdCliente(@Param("id") String id);
}
