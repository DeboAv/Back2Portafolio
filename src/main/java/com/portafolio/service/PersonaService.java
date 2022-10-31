package com.portafolio.service;

import com.portafolio.entity.Persona;
import com.portafolio.interfaces.IPersonaService;
import com.portafolio.repository.IPersonaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaService implements IPersonaService {

    IPersonaRepository personaRepository;

    public PersonaService(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> list() {
        return personaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Persona findPersona(int id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Optional<Persona> getByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }

    @Override
    public boolean existByNombre(String nombre) {
        return personaRepository.existsByNombre(nombre);
    }

    public boolean exist(int id){
        return personaRepository.existsById(id);
    }

}
