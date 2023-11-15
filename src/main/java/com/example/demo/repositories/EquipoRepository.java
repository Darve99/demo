package com.example.demo.repositories;

import com.example.demo.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByCiudad(String ciudad);
    List<Equipo> findByNombre(String nombre);
}
