package com.lavanderiapiscis.sistemaweb.repository;

import com.lavanderiapiscis.sistemaweb.model.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Integer> {

    // Definir una consulta personalizada para obtener los empleados con un estado específico (por ejemplo, habilitados)
    @Query("SELECT e FROM EmpleadoModel e WHERE e.estado = true")
    List<EmpleadoModel> findAllCustom();
}
