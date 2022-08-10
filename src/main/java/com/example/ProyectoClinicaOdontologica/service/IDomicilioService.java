package com.example.ProyectoClinicaOdontologica.service;

import com.example.ProyectoClinicaOdontologica.model.DomicilioDto;

import java.util.Set;

public interface IDomicilioService {

    void crearDomicilio(DomicilioDto domicilioDto);
    DomicilioDto leerDomicilio(Long id);
    void modificarDomicilio(DomicilioDto domicilioDto);
    void eliminarDomicilio(Long id);
    Set<DomicilioDto> getDomicilios();
}
