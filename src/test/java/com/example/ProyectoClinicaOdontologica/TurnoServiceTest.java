package com.example.ProyectoClinicaOdontologica;

import com.example.ProyectoClinicaOdontologica.model.*;
import com.example.ProyectoClinicaOdontologica.service.IOdontologoService;
import com.example.ProyectoClinicaOdontologica.service.IPacienteService;
import com.example.ProyectoClinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;


@SpringBootTest
public class TurnoServiceTest {
    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IOdontologoService odontologoService;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void testCrearTurno() {

        Odontologo odontologo = new Odontologo("Neyza","Vargas",107);

        Domicilio domicilio = new Domicilio("siempreviva", "123", "springfield","USA");
        Paciente paciente = new Paciente("Beatriz", "Nieves", 1150, LocalDate.now(),domicilio);
        TurnoDto turnoDto = new TurnoDto(odontologo,paciente,LocalDate.now());
        turnoService.crearTurno(turnoDto);

        TurnoDto turnoDto1 = turnoService.leerTurno(1L);
        Assert.assertTrue(turnoDto1 != null);
    }

    @Test
    public void traerTodos() {
        Set<TurnoDto> turnos = turnoService.getTurnos();
        Assert.assertTrue(!turnos.isEmpty());
        Assert.assertTrue(turnos.size() == 1);
        System.out.println(turnos);
    }

    @Test
    public void eliminarTurnoTest() {
        turnoService.eliminarTurno(1L);
        Assert.assertTrue(turnoService.leerTurno(1L) == null);

    }
}
