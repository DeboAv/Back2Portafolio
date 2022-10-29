package com.daa2.repository;

import com.daa2.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Integer> {

    Optional<Experiencia> findByNombreE(String nombreE);
    boolean existsByNombreE(String nombreE);
}
