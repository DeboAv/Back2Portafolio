package com.daa2.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.daa2.entity.Educacion;
import com.daa2.interfaces.IEducacionService;
import com.daa2.repository.IEducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService {
    @Autowired
    IEducacionRepository repository;

    public List<Educacion> list(){
        return repository.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return repository.findById(id);
    }

    public Optional<Educacion> getByNmbreE(String nombreE){
        return repository.findByNombreE(nombreE);
    }

    public void save(Educacion educacion){
        repository.save(educacion);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public boolean existsByNombreE(String nombreE){
        return repository.existsByNombreE(nombreE);
    }
}