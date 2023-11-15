package com.example.demo.services;

import com.example.demo.exceptions.NotFoundRequestException;
import com.example.demo.exceptions.StandardRequestException;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.models.Equipo;
import com.example.demo.repositories.EquipoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<EquipoDTO> getEquipos() {
        List<Equipo> equipos = equipoRepository.findAll();
        return equipos.stream().map(EquipoDTO::new).collect(Collectors.toList());
    }

    public EquipoDTO getEquipoById(Long id) throws NotFoundRequestException {
        return new EquipoDTO(getEquipoFromDB(id));
    }

    public EquipoDTO createEquipo(Equipo equipo) {
        return new EquipoDTO(equipoRepository.save(equipo));
    }

    public EquipoDTO updateEquipo(Long id, Equipo equipo) throws NotFoundRequestException {
        Equipo existingEquipo = getEquipoFromDB(id);
        BeanUtils.copyProperties(equipo, existingEquipo, "id"); // Exclude copying the ID
        return new EquipoDTO(equipoRepository.save(existingEquipo));
    }

    public EquipoDTO deleteEquipo(Long id) throws NotFoundRequestException {
        Equipo equipo = getEquipoFromDB(id);
        equipoRepository.delete(equipo);
        return new EquipoDTO(equipo);
    }

    private Equipo getEquipoFromDB(Long id) throws NotFoundRequestException {
        Optional<Equipo> equipoOptional = equipoRepository.findById(id);
        return equipoOptional.orElseThrow(() -> new NotFoundRequestException("Equipo no encontrado"));
    }
}
