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
@Table(name = "pqr")
public class Pqr {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pqr_id_seq")
    @SequenceGenerator(name = "pqr_id_seq", sequenceName = "pqr_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "usuarioID", nullable = false)
    private Integer usuarioID;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "estado", nullable = false)
    private char estado;
}
