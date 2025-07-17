package com.lavanderiapiscis.sistemaweb.repository;

import com.lavanderiapiscis.sistemaweb.model.BoletaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoletaRepository extends JpaRepository<BoletaModel, Integer> {
    
    @Query("SELECT u FROM BoletaModel u WHERE u.estado = true")
    List<BoletaModel> findAllCustom();
}
