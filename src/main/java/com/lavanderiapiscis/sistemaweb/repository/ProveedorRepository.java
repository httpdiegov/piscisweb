package com.lavanderiapiscis.sistemaweb.repository;

import com.lavanderiapiscis.sistemaweb.model.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<ProveedorModel, Integer> {

    @Query("SELECT p FROM ProveedorModel p WHERE p.estado = true")
    List<ProveedorModel> findAllCustom();

}
