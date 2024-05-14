package com.feastfinder.reservationapp.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.feastfinder.reservationapp.models.Restaurante;
import com.feastfinder.reservationapp.services.ServicioRestaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante")
public class ControladorRestaurante {

    @Autowired
    ServicioRestaurante servicioRestaurante;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping()
    public ArrayList<Restaurante> obtenerRestaurantes() {
        return servicioRestaurante.obtenerRestaurantes();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public Restaurante guardarRestaurante(@RequestBody Restaurante restaurante) {
        return servicioRestaurante.guardarRestaurante(restaurante);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/{id}")
    public Optional<Restaurante> obtenerRestaurantePorId(@PathVariable("id") Integer id) {
        return servicioRestaurante.obtenerRestaurantePorId(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public String eliminarRestaurantePorId(@PathVariable("id") Integer id) {
        boolean eliminado = this.servicioRestaurante.eliminarRestaurantePorId(id);
        if (eliminado) {
            return "Restaurante con ID " + id + " eliminado correctamente";
        } else {
            return "No se pudo eliminar el restaurante con ID " + id;
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/detalles/{nombre}")
    public Optional<Restaurante> obtenerRestaurantePorNombre(@PathVariable String nombre){
        return servicioRestaurante.obtenerRestaurantePorNombre(nombre);
    }
}
