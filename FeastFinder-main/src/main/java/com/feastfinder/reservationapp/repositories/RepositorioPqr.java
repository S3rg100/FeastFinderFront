package com.feastfinder.reservationapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.feastfinder.reservationapp.models.*;

import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioPqr extends JpaRepository<Pqr, Integer> {
    
}