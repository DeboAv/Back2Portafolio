package com.daa2.interfaces;

import com.daa2.entity.Experiencia;
import com.daa2.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    List<Experiencia> list();
    Optional<Experiencia> getByNombreE(String nombreE);
    void save(Experiencia e);
    void deleteExperiencia(int id);
    Optional<Experiencia> getOne(int id);
    boolean existsByNombreE(String nombreE);
    boolean existsById(int id);
}
