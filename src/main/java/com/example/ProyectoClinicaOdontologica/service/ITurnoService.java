package com.example.ProyectoClinicaOdontologica.service;


import com.example.ProyectoClinicaOdontologica.model.TurnoDto;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDto turnoDto);
    TurnoDto leerTurno(Long id);
    void modificarTurno(TurnoDto turnoDto);
    void eliminarTurno(Long id);
    Set<TurnoDto> getTurnos();

}
