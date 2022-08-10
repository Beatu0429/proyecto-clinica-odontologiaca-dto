package com.example.ProyectoClinicaOdontologica.controller;


import com.example.ProyectoClinicaOdontologica.model.DomicilioDto;
import com.example.ProyectoClinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    IDomicilioService domicilioService;

    @PostMapping
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDto domicilioDto){
        domicilioService.crearDomicilio(domicilioDto);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DomicilioDto domicilioDto) {
        ResponseEntity<?> response = null;

        if (domicilioDto.getId() != null && domicilioService.leerDomicilio(domicilioDto.getId()) != null)
            domicilioService.modificarDomicilio(domicilioDto);
        response = ResponseEntity.ok(HttpStatus.OK);

        return response;
    }

    @GetMapping("/{id}")
    public DomicilioDto getDomicilio(@PathVariable Long id){
        return domicilioService.leerDomicilio(id);
    }

    @GetMapping
    public Set<DomicilioDto> getDomiciliosTodos(){
        return domicilioService.getDomicilios();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteDomicilio(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
