package com.comunicaciones.comunicacionesInternas.Controlador;

import com.comunicaciones.comunicacionesInternas.Modelo.MAnuncios;
import com.comunicaciones.comunicacionesInternas.Servicios.SAnuncios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anuncios")
@CrossOrigin(origins = "*")
public class CAnuncios
{
    @Autowired
    SAnuncios sAnuncios;

    //Endpoint guardado
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody MAnuncios mAnuncios)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sAnuncios.guardar(mAnuncios));
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
                    .body(this.sAnuncios.consultageneral());
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta individual por codigo
    @GetMapping("/{codanuncio}")
    public ResponseEntity<?> consultaindividualId(@PathVariable String codanuncio)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAnuncios.consultaIndividual(codanuncio));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Consulta individual por nombre
    @GetMapping("/buscartitulo/{titulo}")
    public ResponseEntity<?>consultaindividualtitulo(@PathVariable String titulo)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAnuncios.consultaindividualtitulo(titulo));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint modificar
    @PutMapping("/{codanuncio}")
    public ResponseEntity<?>modificar(@RequestBody MAnuncios mAnuncios, @PathVariable String codanundio)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAnuncios.modificar(mAnuncios, codanundio));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint anular
    @PutMapping("/anular/{codanuncio}")
    public ResponseEntity<?> anular(@RequestBody MAnuncios mAnuncios, @PathVariable String codanuncio)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAnuncios.anular(mAnuncios, codanuncio));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint eliminar
    @DeleteMapping("/{codanuncio}")
    public ResponseEntity<?> eliminar(@PathVariable String codanuncio)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAnuncios.eliminar(codanuncio));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}