package com.example.demo.controllers;

import com.example.demo.dto.EquipoDTO;
import com.example.demo.exceptions.StandardRequestException;
import com.example.demo.models.Equipo;
import com.example.demo.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipoDTO> getEquipos() {
        return equipoService.getEquipos();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipoDTO getEquipoById(@PathVariable Long id) throws StandardRequestException {
        return equipoService.getEquipoById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipoDTO createEquipo(@RequestBody Equipo equipo) throws StandardRequestException {
        return equipoService.createEquipo(equipo);
    }
}
