package com.example.ProyectoClinicaOdontologica;

import com.example.ProyectoClinicaOdontologica.model.Domicilio;
import com.example.ProyectoClinicaOdontologica.model.PacienteDto;
import com.example.ProyectoClinicaOdontologica.service.IDomicilioService;
import com.example.ProyectoClinicaOdontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.ProyectoClinicaOdontologica.service.IOdontologoService;

import java.time.LocalDate;
import java.util.Set;


@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private IPacienteService pacienteService;


    @Test
    public void testCrearPaciente() {

        Domicilio domicilio = new Domicilio("siempreviva", "123", "springfield","USA");
        PacienteDto pacienteDto = new PacienteDto("Maria","Perez", 9876, LocalDate.now(), domicilio);
        pacienteService.crearPaciente(pacienteDto);
        PacienteDto paciente1 = pacienteService.leerPaciente(1L);
        Assert.assertTrue(paciente1 != null);

    }

    @Test
    public void traerTodos() {
        Set<PacienteDto> pacientes = pacienteService.getPacientes();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 1);
        System.out.println(pacientes);
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminarPaciente(1L);
        Assert.assertTrue(pacienteService.leerPaciente(1L) == null);

    }

}
