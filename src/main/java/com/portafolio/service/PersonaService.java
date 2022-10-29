package com.portafolio.service;

import com.portafolio.entity.Persona;
import com.portafolio.interfaces.IPersonaService;
import com.portafolio.repository.IPersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    IPersonaRepository personaRepository;

    public PersonaService(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getPersona() {
        return personaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }
}
