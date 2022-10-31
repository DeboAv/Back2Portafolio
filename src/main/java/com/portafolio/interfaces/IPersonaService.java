package com.portafolio.interfaces;

import com.portafolio.entity.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    List<Persona> list();
    void savePersona(Persona persona);
    Persona findPersona(int id);
    boolean exist(int id);
    Optional<Persona> getByNombre(String nombre);
    boolean existByNombre(String nombre);
}