package com.feastfinder.reservationapp.services;

import java.util.ArrayList;
import java.util.Optional;

import com.feastfinder.reservationapp.models.Restaurante;       
import com.feastfinder.reservationapp.repositories.RepositorioRestaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioRestaurante {

    @Autowired
    RepositorioRestaurante repositorioRestaurante;

    public ArrayList<Restaurante> obtenerRestaurantes() {
        return (ArrayList<Restaurante>) repositorioRestaurante.findAll();
    }

    public Restaurante guardarRestaurante(Restaurante restaurante) {
        return repositorioRestaurante.save(restaurante);
    }

    public Optional<Restaurante> obtenerRestaurantePorId(Integer id) {
        return repositorioRestaurante.findById(id);
    }

    public boolean eliminarRestaurantePorId(Integer id) {
        try {
            repositorioRestaurante.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Optional<Restaurante> obtenerRestaurantePorNombre(String nombre){
        return repositorioRestaurante.findByNombre(nombre);
    }
}
