package com.portafolio.repository;

import com.portafolio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    Optional<Persona> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
