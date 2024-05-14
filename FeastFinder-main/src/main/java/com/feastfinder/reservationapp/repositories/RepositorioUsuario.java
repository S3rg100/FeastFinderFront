package com.feastfinder.reservationapp.repositories;

import com.feastfinder.reservationapp.models.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombredecuenta(String nombredecuenta); 
    
} 
