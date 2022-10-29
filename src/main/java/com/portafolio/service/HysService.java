package com.portafolio.service;

import com.portafolio.entity.Hys;
import com.portafolio.interfaces.IHysService;
import com.portafolio.repository.IHysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HysService implements IHysService {
    @Autowired
    IHysRepository repository;

    public List<Hys> list(){
        return repository.findAll();
    }

    public Optional<Hys> getOne(int id){
        return repository.findById(id);
    }

    public Optional<Hys> getByNombre(String nombre){
        return repository.findByNombre(nombre);
    }

    public void save(Hys skill){
        repository.save(skill);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return repository.existsByNombre(nombre);
    }
}