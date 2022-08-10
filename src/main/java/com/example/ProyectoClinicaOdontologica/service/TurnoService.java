package com.example.ProyectoClinicaOdontologica.service;

import com.example.ProyectoClinicaOdontologica.model.Turno;
import com.example.ProyectoClinicaOdontologica.model.TurnoDto;
import com.example.ProyectoClinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDto turnoDto) {

        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turno);

    }

    @Override
    public TurnoDto leerTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDto turnoDto = null;
        if (turno.isPresent())
            turnoDto = mapper.convertValue(turno, TurnoDto.class);
        return turnoDto;
    }

    @Override
    public void modificarTurno(TurnoDto turnoDto) {
        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDto> getTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDto> turnoDtos = new HashSet<>();
        for (Turno turno : turnos) {
            turnoDtos.add(mapper.convertValue(turno, TurnoDto.class));
        }
        return turnoDtos;
    }
}
