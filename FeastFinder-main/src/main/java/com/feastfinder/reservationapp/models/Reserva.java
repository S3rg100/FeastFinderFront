package com.feastfinder.reservationapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_id_seq")
    @SequenceGenerator(name = "reserva_id_seq", sequenceName = "reserva_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "usuarioID", nullable = false)
    private Integer usuarioID;

    @Column(name = "RestauranteID", nullable = false)
    private Integer restauranteID;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Hora", nullable = false)
    private LocalTime hora;

    @Column(name = "Estado", nullable = false)
    private char estado;

    @Column(name = "Descripcion")
    private String descripcion;
}
