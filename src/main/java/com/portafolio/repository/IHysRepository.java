package com.daa2.repository;

import com.daa2.entity.Hys;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IHysRepository extends JpaRepository<Hys, Integer> {
    Optional<Hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}