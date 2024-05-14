package com.feastfinder.reservationapp.controllers;

import com.feastfinder.reservationapp.models.Categoria;
import com.feastfinder.reservationapp.services.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class ControladorCategoria {

    @Autowired
    private ServicioCategoria servicioCategoria;

    @GetMapping()
    public List<Categoria> obtenerCategorias() {
        return servicioCategoria.obtenerCategorias();
    }

    @PostMapping()
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return servicioCategoria.crearCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable("id") Integer id) {
        return servicioCategoria.obtenerCategoriaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable("id") Integer id) {
        servicioCategoria.eliminarCategoria(id);
    }
}
