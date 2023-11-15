package com.example.demo.controllers;


import com.example.demo.dto.JugadorDTO;
import com.example.demo.exceptions.StandardRequestException;
import com.example.demo.models.Jugador;
import com.example.demo.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JugadorDTO> getJugadores() {
        return jugadorService.getJugadores();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JugadorDTO getJugadorById(@PathVariable Long id) throws StandardRequestException {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public JugadorDTO createJugador(@RequestBody Jugador jugador) throws StandardRequestException {
        return jugadorService.createJugador(jugador);
    }

}
