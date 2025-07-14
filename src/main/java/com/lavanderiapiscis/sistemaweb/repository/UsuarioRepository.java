package com.lavanderiapiscis.sistemaweb.repository;

import com.lavanderiapiscis.sistemaweb.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    
    @Query("SELECT u FROM UsuarioModel u WHERE u.estado = true")
    List<UsuarioModel> findAllCustom();
}
