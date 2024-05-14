package com.feastfinder.reservationapp.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.feastfinder.reservationapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feastfinder.reservationapp.services.ServicioPqr;

@RestController
@RequestMapping("/pqr")
public class ControladorPqr {
    @Autowired
    ServicioPqr servicioPqr;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping()
    public ArrayList<Pqr> obtenerPqrs() {
        return servicioPqr.obtenerPqrs();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public Pqr guardarPqr(@RequestBody Pqr pqr) {
        return servicioPqr.guardarPqr(pqr);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/{id}")
    public Optional<Pqr> obtenerPqrPorId(@PathVariable("id") Integer id) {
        return servicioPqr.obtenerPqrPorId(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") Integer id) {
        boolean eliminada = this.servicioPqr.eliminarPqr(id);
        if (eliminada) {
            return "PQR con ID " + id + " eliminada correctamente";
        } else {
            return "No se pudo eliminar la PQR con ID " + id;
        }
    }
}
