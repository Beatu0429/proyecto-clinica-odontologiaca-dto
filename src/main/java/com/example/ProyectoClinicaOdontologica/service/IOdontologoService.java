package com.example.ProyectoClinicaOdontologica.service;

import com.example.ProyectoClinicaOdontologica.model.OdontologoDto;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDto odontologoDto);
    OdontologoDto leerOdontologo(Long id);
    void modificarOdontologo(OdontologoDto odontologoDto);
    void eliminarOdontologo(Long id);
    Set<OdontologoDto> getOdontologos();
}
