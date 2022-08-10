package com.example.ProyectoClinicaOdontologica.service;

import com.example.ProyectoClinicaOdontologica.model.Domicilio;
import com.example.ProyectoClinicaOdontologica.model.DomicilioDto;
import com.example.ProyectoClinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearDomicilio(DomicilioDto domicilioDto) {
        Domicilio domicilio = mapper.convertValue(domicilioDto, Domicilio.class);
        domicilioRepository.save(domicilio);

    }

    @Override
    public DomicilioDto leerDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDto domicilioDto = null;
        if(domicilio.isPresent())
            domicilioDto = mapper.convertValue(domicilio, DomicilioDto.class);
        return domicilioDto;

    }

    @Override
    public void modificarDomicilio(DomicilioDto domicilioDto) {
        Domicilio domicilio = mapper.convertValue(domicilioDto, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {

        domicilioRepository.deleteById(id);

    }

    @Override
    public Set<DomicilioDto> getDomicilios() {
        List<Domicilio> domicilios =domicilioRepository.findAll();
        Set<DomicilioDto> domicilioDtos = new HashSet<>();
        for (Domicilio domicilio: domicilios){
            domicilioDtos.add(mapper.convertValue(domicilio, DomicilioDto.class));
        }
        return domicilioDtos;
    }
}
