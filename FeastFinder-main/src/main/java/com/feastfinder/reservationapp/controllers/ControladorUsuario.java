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

import com.feastfinder.reservationapp.services.ServicioUsuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
    @Autowired
    ServicioUsuario servicioUsuario;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping()
    public ArrayList<Usuario> obtenerUsuarios() {
        return servicioUsuario.obtenerUsuarios();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping (value = "welcome")
    public String welcome() {
        return "Esta en el endpoint seguro";
    }

    @PostMapping ("demo")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return servicioUsuario.guardaruUsuario(usuario);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        return servicioUsuario.obtenerPorId(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") Integer id) {
        boolean eliminado = this.servicioUsuario.eliminarUsuario(id);
        if (eliminado) {
            return "Usuario con ID " + id + " eliminado correctamente";
        } else {
            return "No se pudo eliminar el usuario con ID " + id;
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/detalles/{nombredecuenta}")
    public Optional<Usuario> buscarPorNombreDeCuenta (@PathVariable String nombredecuenta){
        return servicioUsuario.buscarPorNombreDeCuenta(nombredecuenta);
    }

}
