package com.comunicaciones.comunicacionesInternas.Servicios;

import com.comunicaciones.comunicacionesInternas.Modelo.MAnuncios;
import com.comunicaciones.comunicacionesInternas.Repositorio.IAnuncios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SAnuncios
{
    @Autowired
    IAnuncios iAnuncios;

    public SAnuncios(IAnuncios iAnuncios)
    {
        this.iAnuncios = iAnuncios;
    }

    //Guardar
    public MAnuncios guardar(MAnuncios mAnuncios) throws Exception
    {
        try
        {
            return this.iAnuncios.save(mAnuncios);
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta general
    public List<MAnuncios>consultageneral() throws Exception
    {
        try
        {
            return this.iAnuncios.findAll();
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta individual por codigo
    public MAnuncios consultaIndividual(String codanuncio) throws Exception
    {
        try
        {
            Optional<MAnuncios>anuncioencontrado=this.iAnuncios.findById(codanuncio);
            if (anuncioencontrado.isPresent())
            {
                return anuncioencontrado.get();
            }
            else
            {
                throw new Exception("Anuncio no encontrado");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta individual por titulo
    public List<MAnuncios>consultaindividualtitulo(String titulo) throws Exception
    {
        try
        {
            return this.iAnuncios.findBytitulo(titulo);
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Modificar
    public MAnuncios modificar(MAnuncios mAnuncios, String codanuncio) throws Exception
    {
        try
        {
            Optional<MAnuncios>anuncioencontrado = this.iAnuncios.findById(codanuncio);
            if (anuncioencontrado.isPresent())
            {
                MAnuncios nuevoregistro = anuncioencontrado.get();
                nuevoregistro.setCodanuncio(mAnuncios.getCodanuncio());
                nuevoregistro.setTitulo(mAnuncios.getTitulo());
                nuevoregistro.setContenido(mAnuncios.getContenido());
                nuevoregistro.setFechapublicacion(mAnuncios.getFechapublicacion());
                nuevoregistro.setActivo(mAnuncios.getActivo());
                nuevoregistro.setmColaborador(mAnuncios.getmColaborador());
                return this.iAnuncios.save(nuevoregistro);
            }
            else
            {
                throw new Exception("No se puede modificar, por que el anuncio no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminar(String codanuncio) throws Exception
    {
        try
        {
            Optional<MAnuncios>anuncioencontrado = this.iAnuncios.findById(codanuncio);
            if (anuncioencontrado.isPresent())
            {
                this.iAnuncios.deleteById(codanuncio);
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
    public MAnuncios anular(MAnuncios mAnuncios, String codanuncio) throws Exception
    {
        try
        {
            Optional<MAnuncios>anuncioencontrado = this.iAnuncios.findById(codanuncio);
            if (anuncioencontrado.isPresent())
            {
                MAnuncios nuevoregistro = anuncioencontrado.get();
                if (mAnuncios.getActivo().equals("True"))
                {
                    nuevoregistro.setActivo("True");
                }
                else
                {
                    nuevoregistro.setActivo("False");
                }
                return this.iAnuncios.save(nuevoregistro);
            }
            else
            {
                throw new Exception("No se puede anular por que el anuncio no existe");
            }
        }
        catch (Exception error)
        {
            throw new Exception(error.getMessage());
        }
    }
}
