package com.lavanderiapiscis.sistemaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.EmpleadoModel;
import com.lavanderiapiscis.sistemaweb.repository.EmpleadoRepository;
import com.lavanderiapiscis.sistemaweb.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoModel> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<EmpleadoModel> findAllCustom() {
        return empleadoRepository.findAllCustom();
    }

    @Override
    public EmpleadoModel findById(int id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public EmpleadoModel add(EmpleadoModel empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoModel update(EmpleadoModel empleado, int id) {
        EmpleadoModel existente = empleadoRepository.findById(id).orElseThrow();
        existente.setSucursal(empleado.getSucursal());
        existente.setNombre(empleado.getNombre());
        existente.setApellido(empleado.getApellido());
        existente.setDni(empleado.getDni());
        existente.setNumero(empleado.getNumero());
        existente.setEstado(empleado.isEstado());
        return empleadoRepository.save(existente);
    }

    @Override
    public EmpleadoModel delete(int id) {
        EmpleadoModel empleado = empleadoRepository.findById(id).orElseThrow();
        empleado.setEstado(false);
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoModel enable(int id) {
        EmpleadoModel empleado = empleadoRepository.findById(id).orElseThrow();
        empleado.setEstado(true);
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoModel disable(int id) {
        EmpleadoModel empleado = empleadoRepository.findById(id).orElseThrow();
        empleado.setEstado(false);
        return empleadoRepository.save(empleado);
    }
}
