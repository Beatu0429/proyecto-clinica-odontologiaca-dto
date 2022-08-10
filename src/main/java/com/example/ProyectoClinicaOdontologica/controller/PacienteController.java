package com.example.ProyectoClinicaOdontologica.controller;


import com.example.ProyectoClinicaOdontologica.model.PacienteDto;
import com.example.ProyectoClinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDto pacienteDto){
        pacienteService.crearPaciente(pacienteDto);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDto pacienteDto) {
        ResponseEntity<?> response = null;

        if (pacienteDto.getId() != null && pacienteService.leerPaciente(pacienteDto.getId()) != null)
            pacienteService.modificarPaciente(pacienteDto);
        response = ResponseEntity.ok(HttpStatus.OK);

        return response;
    }

    @GetMapping("/{id}")
    public PacienteDto getPaciente(@PathVariable Long id){
        return pacienteService.leerPaciente(id);
    }

    @GetMapping
    public Set<PacienteDto> getPacientesTodos(){
        return pacienteService.getPacientes();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
