package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private int numero;

    @ManyToOne
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    private Equipo equipo;

    public Jugador(Long id) {
        this.id = id;
    }

    public Jugador(String nombres, String apellidos, int numero, Equipo equipo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero = numero;
        this.equipo = equipo;
    }
}
