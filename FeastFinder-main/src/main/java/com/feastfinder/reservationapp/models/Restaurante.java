package com.feastfinder.reservationapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurante_id_seq")
    @SequenceGenerator(name = "restaurante_id_seq", sequenceName = "restaurante_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "categoriaID")
    private Integer categoriaID;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "menufilepath")
    private String menuFilePath;

    @Column(name = "fotosfilepath")
    private String fotosFilePath;

    @OneToMany
    @JoinColumn(name = "RestauranteID")
    private Set<Reserva> reservas;
}
