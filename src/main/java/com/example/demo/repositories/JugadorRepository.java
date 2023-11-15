package com.example.demo.repositories;

import com.example.demo.models.Jugador;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Long> {
    List<Jugador> findByNombre(String nombre);
    List<Jugador> findByEquipo(String equipo);
}
