package com.comunicaciones.comunicacionesInternas.Servicios;

import com.comunicaciones.comunicacionesInternas.Modelo.MForo;
import com.comunicaciones.comunicacionesInternas.Modelo.MMensajesDirectos;
import com.comunicaciones.comunicacionesInternas.Repositorio.IMensajesDirectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Optional;

@Service
public class SMensajesDirectos
{
    @Autowired
    IMensajesDirectos iMensajesDirectos;

    public SMensajesDirectos(IMensajesDirectos iMensajesDirectos)
    {
        this.iMensajesDirectos = iMensajesDirectos;
    }

    //Guardar
    public MMensajesDirectos guardar(MMensajesDirectos mMensajesDirectos) throws Exception
    {
        try
        {
            return this.iMensajesDirectos.save(mMensajesDirectos);
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta general
    public List<MMensajesDirectos>consultageneral() throws Exception
    {
        try
        {
            return this.iMensajesDirectos.findAll();
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta individual por codigo
    public MMensajesDirectos consultaindividual(String codmensaje)throws Exception
    {
        try
        {
            Optional<MMensajesDirectos>mensajeencontrado=this.iMensajesDirectos.findById(codmensaje);
            if (mensajeencontrado.isPresent())
            {
                return mensajeencontrado.get();
            }
            else
            {
                throw new Exception("Mensaje no encontrado");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta individual por titulo
    public List<MMensajesDirectos>consultaindividualtitulo(String titulomensaje) throws Exception
    {
        try
        {
            return this.iMensajesDirectos.findBytitulomensaje(titulomensaje);
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Modificar
    public MMensajesDirectos modificar(MMensajesDirectos mMensajesDirectos, String codmensaje) throws Exception
    {
        try
        {
            Optional<MMensajesDirectos>mensajeencontrado = this.iMensajesDirectos.findById(codmensaje);
            if (mensajeencontrado.isPresent())
            {
                MMensajesDirectos nuevoregistro = mensajeencontrado.get();
                nuevoregistro.setCodmensaje(mMensajesDirectos.getCodmensaje());
                nuevoregistro.setTitulomensaje(mMensajesDirectos.getTitulomensaje());
                nuevoregistro.setContenidomensaje(mMensajesDirectos.getContenidomensaje());
                nuevoregistro.setFechacreacion(mMensajesDirectos.getFechacreacion());
                nuevoregistro.setActivo(mMensajesDirectos.getActivo());
                nuevoregistro.setmColaborador(mMensajesDirectos.getmColaborador());
                return this.iMensajesDirectos.save(nuevoregistro);
            }
            else
            {
                throw new Exception("No se puede modificar por el mensanje no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminar(String codmensaje)throws Exception
    {
        try
        {
            Optional<MMensajesDirectos>mensajeencontrado = this.iMensajesDirectos.findById(codmensaje);
            if (mensajeencontrado.isPresent())
            {
                this.iMensajesDirectos.deleteById(codmensaje);
                return true;
            }
            else
            {
                throw new Exception("No se puede eleminar el mensaje por que no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Anular
    public MMensajesDirectos anular(MMensajesDirectos mMensajesDirectos, String codmensaje) throws Exception
    {
        try
        {
            Optional<MMensajesDirectos>mensajeencontrado = this.iMensajesDirectos.findById(codmensaje);
            if (mensajeencontrado.isPresent())
            {
                MMensajesDirectos nuevoregistro = mensajeencontrado.get();
                if (mMensajesDirectos.getActivo().equals("True"))
                {
                    nuevoregistro.setActivo("True");
                }
                else
                {
                    nuevoregistro.setActivo("False");
                }
                return this.iMensajesDirectos.save(nuevoregistro);
            }
            else
            {
                throw new Exception("No se puede anular por que el mensaje no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }
}