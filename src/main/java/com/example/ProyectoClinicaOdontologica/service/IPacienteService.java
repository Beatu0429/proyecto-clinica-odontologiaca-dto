package com.example.ProyectoClinicaOdontologica.service;

import com.example.ProyectoClinicaOdontologica.model.PacienteDto;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDto pacienteDto);
    PacienteDto leerPaciente(Long id);
    void modificarPaciente(PacienteDto pacienteDto);
    void eliminarPaciente(Long id);
    Set<PacienteDto> getPacientes();
}
