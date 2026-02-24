package com.comunicaciones.comunicacionesInternas.Controlador;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaborador;
import com.comunicaciones.comunicacionesInternas.Servicios.SColaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(origins = "*")
public class CColaborador
{
    @Autowired
    SColaborador sColaborador;

    //Endpoint guardado
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody MColaborador mColaborador) throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sColaborador.guardar(mColaborador));
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
    public ResponseEntity<?> consultageneral()throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaborador.consultaGeneral());
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta individual por identificación
    @GetMapping("/{idcolaborador}")
    public ResponseEntity<?> consultaindividualid(@PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaborador.consultaIndividualId(idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta individual por nombre
    @GetMapping("/buscarnombre/{nombrecolaborador}")
    public ResponseEntity<?> consultaindividualnombre(@PathVariable String nombrecolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaborador.consultaindividualnombre(nombrecolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint modificar
    @PutMapping("/{idcolaborador}")
    public ResponseEntity<?> modificar(@RequestBody MColaborador mColaborador, @PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaborador.modificar(mColaborador,idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint anular
    @PutMapping("/anular/{idcolaborador}")
    public ResponseEntity<?> anular(@RequestBody MColaborador mColaborador, @PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaborador.anular(mColaborador, idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint eliminar
    @DeleteMapping("/{idcolaborador}")
    public ResponseEntity<?> eliminar(@PathVariable String idcolaborador)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sColaborador.eliminar(idcolaborador));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}