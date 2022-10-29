package com.daa2.interfaces;

import com.daa2.entity.Persona;
import java.util.List;

public interface IPersonaService {
    List<Persona> getPersona();
    void savePersona(Persona persona);
    void deletePersona(Long id);
    Persona findPersona(Long id);
}
