package com.lavanderiapiscis.sistemaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.RolModel;
import com.lavanderiapiscis.sistemaweb.repository.RolRepository;
import com.lavanderiapiscis.sistemaweb.service.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolModel> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public List<RolModel> findAllCustom() {
        return rolRepository.findAllCustom();
    }

    @Override
    public RolModel findById(int id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public RolModel add(RolModel rol) {
        return rolRepository.save(rol);
    }

    @Override
    public RolModel update(RolModel rol, int id) {
        RolModel existente = rolRepository.findById(id).orElseThrow();
        existente.setNombreRol(rol.getNombreRol());
        existente.setDescripcion(rol.getDescripcion());
        return rolRepository.save(existente);
    }

    @Override
    public RolModel delete(int id) {
        RolModel rol = rolRepository.findById(id).orElseThrow();
        rol.setEstado(false);
        return rolRepository.save(rol);
    }

    @Override
    public RolModel enable(int id) {
        RolModel rol = rolRepository.findById(id).orElseThrow();
        rol.setEstado(true);
        return rolRepository.save(rol);
    }

    @Override
    public RolModel disable(int id) {
        RolModel rol = rolRepository.findById(id).orElseThrow();
        rol.setEstado(false);
        return rolRepository.save(rol);
    }
}
