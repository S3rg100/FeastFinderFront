package com.feastfinder.reservationapp.repositories;

import com.feastfinder.reservationapp.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Integer> {
}
