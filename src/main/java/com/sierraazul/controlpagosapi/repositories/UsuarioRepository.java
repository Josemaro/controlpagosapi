package com.sierraazul.controlpagosapi.repositories;

import com.sierraazul.controlpagosapi.models.UsuarioModel;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    public abstract Page<UsuarioModel> findByPrioridad(Integer prioridad,Pageable pageable);
    public Optional<UsuarioModel> findByEmail(String email);
}