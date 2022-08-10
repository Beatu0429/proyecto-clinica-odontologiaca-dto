package com.example.ProyectoClinicaOdontologica;

import com.example.ProyectoClinicaOdontologica.model.OdontologoDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.ProyectoClinicaOdontologica.service.IOdontologoService;

import java.util.Set;


@SpringBootTest
public class OdontologoServiceTests {
    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void testCrearOdontologo() {
        OdontologoDto odontologoDto = new OdontologoDto("Pedro", "Martinez", 1234);
        odontologoService.crearOdontologo(odontologoDto);
        OdontologoDto odontologoDto1 = odontologoService.leerOdontologo(1L);
        Assert.assertTrue(odontologoDto1 != null);
    }

    @Test
    public void traerTodos() {
        Set<OdontologoDto> odontologos = odontologoService.getOdontologos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }

    @Test
    public void eliminarOdontologoTest() {
        odontologoService.eliminarOdontologo(1L);
        Assert.assertTrue(odontologoService.leerOdontologo(1L) == null);

    }

}
