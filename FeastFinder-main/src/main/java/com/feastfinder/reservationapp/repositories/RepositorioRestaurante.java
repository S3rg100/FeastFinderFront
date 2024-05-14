package com.feastfinder.reservationapp.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.feastfinder.reservationapp.models.Restaurante;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRestaurante extends JpaRepository<Restaurante, Integer> {
    Optional<Restaurante> findByNombre(String nombre); 
}
