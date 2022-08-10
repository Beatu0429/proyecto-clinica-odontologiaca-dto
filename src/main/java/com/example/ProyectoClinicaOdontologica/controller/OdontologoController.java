package com.example.ProyectoClinicaOdontologica.controller;

import com.example.ProyectoClinicaOdontologica.model.OdontologoDto;
import com.example.ProyectoClinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.crearOdontologo(odontologoDto);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public OdontologoDto getOdontologo(@PathVariable Long id){
        return odontologoService.leerOdontologo(id);
    }

    @GetMapping
    public Set<OdontologoDto> getOdontologosTodos(){
        return odontologoService.getOdontologos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDto odontologoDto) {
        ResponseEntity<?> response = null;

        if (odontologoDto.getId() != null && odontologoService.leerOdontologo(odontologoDto.getId()) != null)
            odontologoService.modificarOdontologo(odontologoDto);
            response = ResponseEntity.ok(HttpStatus.OK);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
