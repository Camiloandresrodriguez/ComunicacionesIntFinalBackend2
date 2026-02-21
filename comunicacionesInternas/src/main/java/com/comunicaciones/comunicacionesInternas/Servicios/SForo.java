package com.comunicaciones.comunicacionesInternas.Servicios;

import com.comunicaciones.comunicacionesInternas.Modelo.MForo;
import com.comunicaciones.comunicacionesInternas.Repositorio.IForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SForo
{
    @Autowired
    IForo iForo;

    public SForo(IForo iForo)
    {
        this.iForo = iForo;
    }

    //Guardar
    public MForo guardar(MForo mForo) throws Exception
    {
        try
        {
            return this.iForo.save(mForo);
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta general
    public List<MForo>consultageneral()throws Exception
    {
        try
        {
            return this.iForo.findAll();
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta individual por codigo
    public MForo consultaindividualid(String idforo)throws Exception
    {
        try
        {
            Optional<MForo> foroencontrado = this.iForo.findById(idforo);
            if (foroencontrado.isPresent())
            {
                return foroencontrado.get();
            } else
            {
                throw new Exception("Foro no encontrado");
            }
        } catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta individual por titulo
    public List<MForo>consultaindividualtitulo(String titulo) throws Exception
    {
        try
        {
            return this.iForo.findBytitulo(titulo);
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Modificar
    public MForo modificar(MForo mForo, String idforo)throws Exception
    {
        try
        {
            Optional<MForo>foroencontrado = this.iForo.findById(idforo);
            if (foroencontrado.isPresent())
            {
                MForo nuevoregistro = foroencontrado.get();
                nuevoregistro.setIdforo(mForo.getIdforo());
                nuevoregistro.setTitulo(mForo.getTitulo());
                nuevoregistro.setDescripcion(mForo.getDescripcion());
                nuevoregistro.setFechacreacion(mForo.getFechacreacion());
                nuevoregistro.setActivo(mForo.getActivo());
                nuevoregistro.setmColaborador(mForo.getmColaborador());
                return this.iForo.save(nuevoregistro);
            }
            else
            {
                throw new Exception("No se puede modificar por que el foro no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminar(String idforo)throws Exception
    {
        try
        {
            Optional<MForo>foroencontrado = this.iForo.findById(idforo);
            if (foroencontrado.isPresent())
            {
                this.iForo.deleteById(idforo);
                return true;
            }
            else
            {
                throw new Exception("No se encontro el anuncio por que no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Anular
    public MForo anular(MForo mForo, String idforo) throws Exception
    {
        try
        {
            Optional<MForo>foroencontrado = this.iForo.findById(idforo);
            if (foroencontrado.isPresent())
            {
                MForo nuevoregistro = foroencontrado.get();
                if (mForo.getActivo().equals("True"))
                {
                    nuevoregistro.setActivo("True");
                }
                else
                {
                    nuevoregistro.setActivo("False");
                }
                return this.iForo.save(nuevoregistro);
            }
            else
            {
                throw new Exception("No se puede anular por que el foro no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }
}
