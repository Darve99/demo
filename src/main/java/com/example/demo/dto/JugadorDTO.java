package com.example.demo.dto;

import com.example.demo.models.Jugador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JugadorDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private int numero;
    private EquipoDTO equipo;

    public JugadorDTO(Jugador jugador) {
        this.id = jugador.getId();
        this.nombres = jugador.getNombres();
        this.apellidos = jugador.getApellidos();
        this.numero = jugador.getNumero();
        this.equipo = new EquipoDTO(jugador.getEquipo());
    }
}
