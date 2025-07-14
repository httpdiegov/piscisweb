package com.lavanderiapiscis.sistemaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lavanderiapiscis.sistemaweb.model.RolModel;

public interface RolRepository extends JpaRepository<RolModel, Integer> {
    
    @Query("SELECT r FROM RolModel r WHERE r.estado = true")
    List<RolModel> findAllCustom();
}
