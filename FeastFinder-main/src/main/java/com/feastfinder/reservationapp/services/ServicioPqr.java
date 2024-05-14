package com.feastfinder.reservationapp.services;

import com.feastfinder.reservationapp.models.*;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feastfinder.reservationapp.repositories.RepositorioPqr;

@Service
public class ServicioPqr {

    @Autowired
    RepositorioPqr pqrRepositorio;

    public ArrayList<Pqr> obtenerPqrs() {
        return (ArrayList<Pqr>) pqrRepositorio.findAll();
    }

        public Pqr guardarPqr (Pqr pqr){
        return pqrRepositorio.save(pqr);
    }

    public Optional<Pqr> obtenerPqrPorId (Integer id){
        return pqrRepositorio.findById(id);
    }

    public boolean eliminarPqr (Integer id){
        try{
            pqrRepositorio.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }
}
