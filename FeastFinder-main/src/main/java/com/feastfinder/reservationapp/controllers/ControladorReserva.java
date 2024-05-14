package com.feastfinder.reservationapp.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.feastfinder.reservationapp.models.*;
import com.feastfinder.reservationapp.services.ServicioReserva;
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
@RequestMapping("/reserva")
public class ControladorReserva {

    @Autowired
    private ServicioReserva servicioReserva;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping()
    public ArrayList<Reserva> obtenerReservas() {
        return servicioReserva.obtenerReservas();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return servicioReserva.guardarReserva(reserva);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/{id}")
    public Optional<Reserva> obtenerReservaPorId(@PathVariable("id") Integer id) {
        return servicioReserva.obtenerReservaPorId(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public String eliminarReservaPorId(@PathVariable("id") Integer id) {
        boolean eliminado = servicioReserva.eliminarReservaPorId(id);
        if (eliminado) {
            return "Reserva con ID " + id + " eliminada correctamente";
        } else {
            return "No se pudo eliminar la reserva con ID " + id;
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/usuario/{usuarioID}")
    public ArrayList<Reserva> obtenerReservasPorUsuarioID(@PathVariable Integer usuarioID) {
        return servicioReserva.obtenerReservasPorUsuarioID(usuarioID);
    }
}

