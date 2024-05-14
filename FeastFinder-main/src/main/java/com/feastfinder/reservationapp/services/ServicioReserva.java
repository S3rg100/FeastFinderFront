package com.feastfinder.reservationapp.services;

import java.util.ArrayList;
import java.util.Optional;

import com.feastfinder.reservationapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feastfinder.reservationapp.repositories.RepositorioReserva;

@Service
public class ServicioReserva {
    @Autowired
    RepositorioReserva reservaRepositorio;

    public ArrayList<Reserva> obtenerReservas(){
        return (ArrayList<Reserva>) reservaRepositorio.findAll();
    }

    public Reserva guardarReserva(Reserva reserva){
        return reservaRepositorio.save(reserva);
    }

    public Optional<Reserva> obtenerReservaPorId(Integer id){
        return reservaRepositorio.findById(id);
    }

    public boolean eliminarReservaPorId(Integer id){
        try{
            reservaRepositorio.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }

    public ArrayList<Reserva> obtenerReservasPorUsuarioID(Integer usuarioID) {
        return reservaRepositorio.findByUsuarioID(usuarioID);
    }
}

