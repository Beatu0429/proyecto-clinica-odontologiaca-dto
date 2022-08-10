package com.example.ProyectoClinicaOdontologica.service;

import com.example.ProyectoClinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.ProyectoClinicaOdontologica.model.Odontologo;
import com.example.ProyectoClinicaOdontologica.model.OdontologoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearOdontologo(OdontologoDto odontologoDto) {

        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        odontologoRepository.save(odontologo);

    }

    @Override
    public OdontologoDto leerOdontologo(Long id) {

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDto odontologoDto = null;
        if(odontologo.isPresent())
            odontologoDto = mapper.convertValue(odontologo, OdontologoDto.class);
        return odontologoDto;
    }

    @Override
    public void modificarOdontologo(OdontologoDto odontologoDto) {
        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDto> getOdontologos() {
        List<Odontologo> odontologos =odontologoRepository.findAll();
        Set<OdontologoDto> odontologoDtos = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            odontologoDtos.add(mapper.convertValue(odontologo, OdontologoDto.class));
        }
        return odontologoDtos;
    }
}
