package com.example.ProyectoClinicaOdontologica.repository;

import com.example.ProyectoClinicaOdontologica.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {
}
