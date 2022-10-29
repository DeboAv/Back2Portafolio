package com.daa2.interfaces;

import com.daa2.entity.Hys;
import java.util.List;
import java.util.Optional;

public interface IHysService {
    List<Hys> list();
    Optional<Hys> getOne(int id);
    Optional<Hys> getByNombre(String nombre);
    void save(Hys skill);
    void delete(int id);
    boolean existsById(int id);
    boolean existsByNombre(String nombre);
}
