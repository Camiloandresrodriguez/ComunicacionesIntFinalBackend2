package com.comunicaciones.comunicacionesInternas.Servicios;

import com.comunicaciones.comunicacionesInternas.Modelo.MColaborador;
import com.comunicaciones.comunicacionesInternas.Repositorio.IColaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SColaborador
{
    @Autowired
    IColaborador iColaborador;

    public SColaborador(IColaborador iColaborador) {
        this.iColaborador = iColaborador;
    }

    //Guardar
    public MColaborador guardar(MColaborador mColaborador) throws Exception{
        try{
            return this.iColaborador.save(mColaborador);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // consulta general
    public List<MColaborador> consultaGeneral() throws Exception{
        try{
            return this.iColaborador.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual identificacion
    public MColaborador consultaIndividualId(String idcolaborador) throws Exception
    {
        try {
            Optional<MColaborador> colaboradorencontrado = this.iColaborador.findById(idcolaborador);
            if (colaboradorencontrado.isPresent()) {
                return colaboradorencontrado.get();
            } else {
                throw new Exception("Colaborador no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual nombre
    public List<MColaborador>consultaindividualnombre(String nombrecolaborador) throws Exception
    {
        try {
            Optional<MColaborador>colaboradorencontrado = this.iColaborador.findById(nombrecolaborador);
            if (colaboradorencontrado.isPresent()) {
                return this.iColaborador.findByNombrecolaborador(nombrecolaborador);
            }
            else
                {
                throw new Exception("Colaborador no encontrado");
                }
        }
        catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public MColaborador modificar(MColaborador mColaborador, String idcolaborador) throws Exception{
        try {
            Optional<MColaborador>colaboradorencontrado= this.iColaborador.findById(idcolaborador);
            if (colaboradorencontrado.isPresent()) {
                MColaborador nuevocolaborador = colaboradorencontrado.get();
                nuevocolaborador.setIdcolaborador(mColaborador.getIdcolaborador());
                nuevocolaborador.setTipocolaborador(mColaborador.getTipocolaborador());
                nuevocolaborador.setNombrecolaborador(mColaborador.getNombrecolaborador());
                nuevocolaborador.setApellidocolaborador(mColaborador.getApellidocolaborador());
                nuevocolaborador.setCorreoelectronico(mColaborador.getCorreoelectronico());
                nuevocolaborador.setClave(mColaborador.getClave());
                nuevocolaborador.setFecharegistro(mColaborador.getFecharegistro());
                nuevocolaborador.setActivo(mColaborador.getActivo());
                return this.iColaborador.save(nuevocolaborador);
            }
            else {
                throw new Exception("no se puede hacer una modificaciòn por el Colaborador no esta registrado");
            }
        }
        catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public Boolean eliminar(String idcolaborador) throws Exception{
        try {
            Optional<MColaborador> colaboradorencontrado=this.iColaborador.findById(idcolaborador);
            if (colaboradorencontrado.isPresent()) {
                this.iColaborador.deleteById(idcolaborador);
                return true;
            }
            else {
                throw new Exception("No se puede eliminar el colaborador por que no existe");
            }
        }
        catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Anular
    public MColaborador anular(MColaborador mColaborador, String idcolaborador) throws Exception{
        try {
            Optional<MColaborador>colaboradorencontrado= this.iColaborador.findById(idcolaborador);
            if (colaboradorencontrado.isPresent()) {
                MColaborador nuevoregistro = colaboradorencontrado.get();
                if(mColaborador.getActivo().equals("True"))
                {
                    nuevoregistro.setActivo("True");
                }
                else {
                    nuevoregistro.setActivo("False");
                }
                return this.iColaborador.save(nuevoregistro);
            }
            else {
                throw new Exception("Cliente no registrado, no se puede anular");
            }
        }
        catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
