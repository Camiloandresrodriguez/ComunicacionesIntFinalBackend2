package com.comunicaciones.comunicacionesInternas.Controlador;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaboradoranuncio;
import com.comunicaciones.comunicacionesInternas.Servicios.SColaboradoranuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaborador anuncio")
@CrossOrigin(origins = "*")
public class CColaboradoranuncio
{
    @Autowired
    SColaboradoranuncio sColaboradoranuncio;

    //Endpoint guardado
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MColaboradoranuncio mColaboradoranuncio)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sColaboradoranuncio.guardar(mColaboradoranuncio));
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
                    .body(this.sColaboradoranuncio.consultageneral());
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
                    .body(this.sColaboradoranuncio.consultaindividualid(idcolaborador));
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
    public ResponseEntity<?>anular(@RequestBody MColaboradoranuncio mColaboradoranuncio, @PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaboradoranuncio.anular(mColaboradoranuncio, idcolaborador));
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
                    .body(this.sColaboradoranuncio.eliminar(idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}