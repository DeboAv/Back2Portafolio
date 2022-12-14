package com.portafolio.service;

import com.portafolio.entity.Experiencia;
import com.portafolio.interfaces.IExperienciaService;
import com.portafolio.repository.IExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService {

    @Autowired
    IExperienciaRepository experienciaRepository;

    @Override
    public List<Experiencia> list() {
        return experienciaRepository.findAll();
    }

    @Override
    public Optional<Experiencia> getByNombreE(String nombreE) {
        return experienciaRepository.findByNombreE(nombreE);
    }

    @Override
    public void save(Experiencia e) {
        experienciaRepository.save(e);
    }

    @Override
    public void deleteExperiencia(int id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Optional<Experiencia> getOne(int id) {
        return experienciaRepository.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return experienciaRepository.existsById(id);
    }

    @Override
    public boolean existsByNombreE(String nombreE) {
        return experienciaRepository.existsByNombreE(nombreE);
    }
}
