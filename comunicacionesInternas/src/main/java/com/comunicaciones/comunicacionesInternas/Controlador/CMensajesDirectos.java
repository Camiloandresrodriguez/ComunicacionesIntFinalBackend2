package com.comunicaciones.comunicacionesInternas.Controlador;

import com.comunicaciones.comunicacionesInternas.Modelo.MMensajesDirectos;
import com.comunicaciones.comunicacionesInternas.Servicios.SMensajesDirectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensajes directos")
@CrossOrigin(origins = "*")
public class CMensajesDirectos
{
    @Autowired
    SMensajesDirectos sMensajesDirectos;

    //Endpoint guardado
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MMensajesDirectos mMensajesDirectos)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMensajesDirectos.guardar(mMensajesDirectos));
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
    public ResponseEntity<?> cosnsultageneral()throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMensajesDirectos.consultageneral());
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta individual por codigo
    @GetMapping("/{codmensaje}")
    public ResponseEntity<?>consultaindividualid(@PathVariable String codmensaje)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMensajesDirectos.consultaindividual(codmensaje));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint consulta individuao por nombre
    @GetMapping("/{titulomensaje}")
    public ResponseEntity<?>consultaindividualtitulomensaje(@PathVariable String titulomensaje)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMensajesDirectos.consultaindividualtitulo(titulomensaje));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint modificar
    @PutMapping("/{codmensaje}")
    public ResponseEntity<?> modificar(@RequestBody MMensajesDirectos mMensajesDirectos, @PathVariable String codmensaje)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMensajesDirectos.modificar(mMensajesDirectos,codmensaje));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint anular
    @PutMapping("/anular/{codmensaje}")
    public ResponseEntity<?> anular(@RequestBody MMensajesDirectos mMensajesDirectos, @PathVariable String codmensaje)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMensajesDirectos.anular(mMensajesDirectos,codmensaje));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Endpoint eliminar
    @DeleteMapping("/{codmensaje}")
    public ResponseEntity<?> eliminar(@PathVariable String codmensaje)throws Exception
    {
        try
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMensajesDirectos.eliminar(codmensaje));
        }
        catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}