package com.portafolio.interfaces;

import com.portafolio.entity.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> getPersona();
    void savePersona(Persona persona);
    void deletePersona(Long id);
    Persona findPersona(Long id);
}
