package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MComentariosForos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IComentariosForos extends JpaRepository<MComentariosForos, String>
{
    @Query(value = "SELECT f.idforo, f.titulo, f.descripción, f.fechacreacion, f.idcolaborador, c.nombrecolaborador"
            + "FROM foro f INNER JOIN colaborador c ON a.idcolaborador = c.idcolaborador where idcolaborador = id",nativeQuery = true)
    List<Map<String, Object>> buscarPorIdCliente(@Param("id") String id);
}
