package com.feastfinder.reservationapp.services;

import java.util.ArrayList;
import java.util.Optional;

import com.feastfinder.reservationapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feastfinder.reservationapp.repositories.RepositorioUsuario;

@Service
public class ServicioUsuario {
    @Autowired
    RepositorioUsuario usuariorRepositorio;

    public ArrayList<Usuario> obtenerUsuarios(){
        return (ArrayList<Usuario>)usuariorRepositorio.findAll();
    }

    public Usuario guardaruUsuario (Usuario usuario){
        return usuariorRepositorio.save(usuario);
    }

    public Optional<Usuario> obtenerPorId (Integer id){
        return usuariorRepositorio.findById(id);
    }

    public boolean eliminarUsuario (Integer id){
        try{
            usuariorRepositorio.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }

    public Optional<Usuario> buscarPorNombreDeCuenta (String nombredecuenta){
        return usuariorRepositorio.findByNombredecuenta(nombredecuenta);
    }
}   
