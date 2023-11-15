package com.example.demo.dto;

import com.example.demo.models.Equipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipoDTO {
    private Long id;
    private String nombre;
    private String ciudad;
    private int cantidadCopasInternacionales;

    public EquipoDTO(Equipo equipo) {
        this.id = equipo.getId();
        this.nombre = equipo.getNombre();
        this.ciudad = equipo.getCiudad();
        this.cantidadCopasInternacionales = equipo.getCantidadCopasInternacionales().intValue();
    }
}
