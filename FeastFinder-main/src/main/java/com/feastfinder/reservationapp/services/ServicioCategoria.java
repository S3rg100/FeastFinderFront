package com.feastfinder.reservationapp.services;

import com.feastfinder.reservationapp.models.Categoria;
import com.feastfinder.reservationapp.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCategoria {

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    public List<Categoria> obtenerCategorias() {
        return repositorioCategoria.findAll();
    }

    public Categoria crearCategoria(Categoria categoria) {
        return repositorioCategoria.save(categoria);
    }

    public Categoria obtenerCategoriaPorId(Integer id) {
        Optional<Categoria> categoriaOptional = repositorioCategoria.findById(id);
        if (categoriaOptional.isPresent()) {
            return categoriaOptional.get();
        } else {
            // Manejo de error cuando la categoría no existe
            throw new RuntimeException("Categoría no encontrada con ID: " + id);
        }
    }

    public void eliminarCategoria(Integer id) {
        repositorioCategoria.deleteById(id);
    }
}
