package com.example.demo.services;

import com.example.demo.exceptions.NotFoundRequestException;
import com.example.demo.dto.JugadorDTO;
import com.example.demo.models.Jugador;
import com.example.demo.repositories.JugadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<JugadorDTO> getJugadores() {
        List<Jugador> jugadores = (List<Jugador>) jugadorRepository.findAll();
        return jugadores.stream().map(JugadorDTO::new).collect(Collectors.toList());
    }

    public JugadorDTO getJugadorById(Long id) throws NotFoundRequestException {
        Jugador jugador = getJugadorFromDB(id);
        return new JugadorDTO(jugador);
    }

    public JugadorDTO createJugador(Jugador jugador) {
        return new JugadorDTO(jugadorRepository.save(jugador));
    }

    public JugadorDTO updateJugador(Long id, Jugador jugador) throws NotFoundRequestException {
        Jugador existingJugador = getJugadorFromDB(id);
        BeanUtils.copyProperties(jugador, existingJugador, "id");
        return new JugadorDTO(jugadorRepository.save(existingJugador));
    }

    public void deleteJugador(Long id) throws NotFoundRequestException {
        Jugador jugador = getJugadorFromDB(id);
        jugadorRepository.delete(jugador);
    }

    private Jugador getJugadorFromDB(Long id) throws NotFoundRequestException {
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        return jugadorOptional.orElseThrow(() -> new NotFoundRequestException("Jugador no encontrado"));
    }
}
