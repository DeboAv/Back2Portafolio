package com.daa2.interfaces;

import com.daa2.entity.Educacion;
import java.util.List;
import java.util.Optional;

public interface IEducacionService {
    List<Educacion> list();
    Optional<Educacion> getOne(int id);
    Optional<Educacion> getByNmbreE(String nombreE);
    void save(Educacion educacion);
    void delete(int id);
    boolean existsById(int id);
    boolean existsByNombreE(String nombreE);
}
