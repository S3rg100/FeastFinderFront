package com.feastfinder.reservationapp.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import com.feastfinder.reservationapp.models.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReserva extends JpaRepository<Reserva, Integer> {

    ArrayList<Reserva> findByUsuarioID(Integer usuarioID);
}