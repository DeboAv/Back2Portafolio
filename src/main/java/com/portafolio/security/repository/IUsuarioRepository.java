package com.portafolio.security.repository;

import com.portafolio.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
