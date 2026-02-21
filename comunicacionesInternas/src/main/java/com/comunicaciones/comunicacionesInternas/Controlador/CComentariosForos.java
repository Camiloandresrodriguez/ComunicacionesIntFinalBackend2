package com.comunicaciones.comunicacionesInternas.Controlador;

import com.comunicaciones.comunicacionesInternas.Modelo.MComentariosForos;
import com.comunicaciones.comunicacionesInternas.Servicios.SComentariosForos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios Foros")
@CrossOrigin(origins = "*")
public class CComentariosForos
{
    @Autowired
    SComentariosForos sComentariosForos;

    //Endpoint guardado
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MComentariosForos mComentariosForos)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sComentariosForos.guardar(mComentariosForos));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta general
    @GetMapping
    public ResponseEntity<?>consultageneral()throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sComentariosForos.consultageneral());
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta individual por identificación
    @GetMapping("/{idcomentario}")
    public ResponseEntity<?>consultaindividualid(@PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sComentariosForos.consultaindividualid(idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint anular
    @PutMapping("/anular/{idcomentario}")
    public ResponseEntity<?>anular(@RequestBody MComentariosForos mComentariosForos, @PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sComentariosForos.anular(mComentariosForos, idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint eliminar
    @DeleteMapping("/{idcomentario}")
    public ResponseEntity<?>eliminar(@PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sComentariosForos.eliminar(idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}