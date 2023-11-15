package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ciudad;
    private Long cantidadCopasInternacionales;

    public Equipo(Long id) {
        this.id = id;
    }

    public Equipo(String nombre, String ciudad, Long cantidadCopasInternacionales) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cantidadCopasInternacionales = cantidadCopasInternacionales;
    }
}
