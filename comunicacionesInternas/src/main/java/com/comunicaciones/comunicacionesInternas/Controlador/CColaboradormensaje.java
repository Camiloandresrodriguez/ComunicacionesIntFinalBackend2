package com.comunicaciones.comunicacionesInternas.Controlador;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaboradormensaje;
import com.comunicaciones.comunicacionesInternas.Servicios.SColaboradormensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaborador mensajes")
@CrossOrigin(origins = "*")
public class CColaboradormensaje
{
    @Autowired
    SColaboradormensaje sColaboradormensaje;

    //Endpoint guardado
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MColaboradormensaje mColaboradormensaje)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sColaboradormensaje.guardar(mColaboradormensaje));
        } catch (Exception error)
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
                    .body(this.sColaboradormensaje.consultageneral());
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta individual por identificación
    @GetMapping("/{consecutivo}")
    public ResponseEntity<?>consultaindividualid(@PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaboradormensaje.consultaindividualid(idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint anular
    @PutMapping("/anular/{consecutivo}")
    public ResponseEntity<?>anular(@RequestBody MColaboradormensaje mColaboradormensaje, @PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaboradormensaje.anular(mColaboradormensaje, idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint eliminar
    @DeleteMapping("/{consecutivo}")
    public ResponseEntity<?>eliminar(@PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaboradormensaje.eliminar(idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}