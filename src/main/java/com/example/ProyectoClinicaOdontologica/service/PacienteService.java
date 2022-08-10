package com.example.ProyectoClinicaOdontologica.service;

import com.example.ProyectoClinicaOdontologica.model.Paciente;
import com.example.ProyectoClinicaOdontologica.model.PacienteDto;
import com.example.ProyectoClinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearPaciente(PacienteDto pacienteDto) {

        Paciente paciente = mapper.convertValue(pacienteDto, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public PacienteDto leerPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDto pacienteDto = null;
        if(paciente.isPresent())
            pacienteDto = mapper.convertValue(paciente, PacienteDto.class);
        return pacienteDto;
    }

    @Override
    public void modificarPaciente(PacienteDto pacienteDto) {
        Paciente paciente = mapper.convertValue(pacienteDto, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDto> getPacientes() {
        List<Paciente> pacientes =pacienteRepository.findAll();
        Set<PacienteDto> pacienteDtos = new HashSet<>();
        for (Paciente paciente: pacientes){
            pacienteDtos.add(mapper.convertValue(paciente, PacienteDto.class));
        }
        return pacienteDtos;
    }
}
