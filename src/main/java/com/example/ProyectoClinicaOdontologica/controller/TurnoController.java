package com.example.ProyectoClinicaOdontologica.controller;


import com.example.ProyectoClinicaOdontologica.model.TurnoDto;
import com.example.ProyectoClinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDto turnoDto){
        turnoService.crearTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDto turnoDto) {
        ResponseEntity<?> response = null;

        if (turnoDto.getId() != null && turnoService.leerTurno(turnoDto.getId()) != null)
            turnoService.modificarTurno(turnoDto);
        response = ResponseEntity.ok(HttpStatus.OK);

        return response;
    }

    @GetMapping("/{id}")
    public TurnoDto getTurno(@PathVariable Long id){
        return turnoService.leerTurno(id);
    }

    @GetMapping
    public Set<TurnoDto> getTurnosTodos(){
        return turnoService.getTurnos();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
