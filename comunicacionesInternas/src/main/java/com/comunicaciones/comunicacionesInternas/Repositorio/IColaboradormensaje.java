package com.comunicaciones.comunicacionesInternas.Repositorio;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaboradormensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IColaboradormensaje extends JpaRepository<MColaboradormensaje, String>
{
    @Query(value = "SELECT m.codmensaje, m.titulomensaje, m.contenidomensaje, m.fechacreacion, m.idcolaborador, c.nombrecolaborador"
            + "FROM mensajes m INNER JOIN colaborador c ON a.idcolaborador = c.idcolaborador where idcolaborador = id",nativeQuery = true)
    List<Map<String, Object>> buscarPorIdCliente(@Param("id") String id);
}