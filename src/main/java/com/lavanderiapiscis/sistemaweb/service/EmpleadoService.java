package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;
import com.lavanderiapiscis.sistemaweb.model.EmpleadoModel;

public interface EmpleadoService {
    List<EmpleadoModel> findAll();
    List<EmpleadoModel> findAllCustom();  // Agregar este método a la interfaz
    EmpleadoModel findById(int id);
    EmpleadoModel add(EmpleadoModel empleado);
    EmpleadoModel update(EmpleadoModel empleado, int id);
    EmpleadoModel delete(int id);
    EmpleadoModel enable(int id);
    EmpleadoModel disable(int id);
}
