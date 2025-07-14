package com.lavanderiapiscis.sistemaweb.service.impl;

import com.lavanderiapiscis.sistemaweb.model.ProveedorModel;
import com.lavanderiapiscis.sistemaweb.repository.ProveedorRepository;
import com.lavanderiapiscis.sistemaweb.service.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository repo;

    @Override
    public List<ProveedorModel> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ProveedorModel> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public ProveedorModel findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ProveedorModel add(ProveedorModel obj) {
        return repo.save(obj);
    }

    @Override
    public ProveedorModel update(ProveedorModel obj, int id) {
        var ex = repo.findById(id).orElseThrow();
        ex.setRuc(obj.getRuc());
        ex.setRazonSocial(obj.getRazonSocial());
        ex.setDireccion(obj.getDireccion());
        ex.setCorreo(obj.getCorreo());
        ex.setNumero(obj.getNumero());
        return repo.save(ex);
    }

    @Override
    public ProveedorModel delete(int id) {
        var p = repo.findById(id).orElseThrow();
        p.setEstado(false);
        return repo.save(p);
    }

    @Override
    public ProveedorModel enable(int id) {
        var p = repo.findById(id).orElseThrow();
        p.setEstado(true);
        return repo.save(p);
    }
    @Override
    public ProveedorModel disable(int id) {
        var p = repo.findById(id).orElseThrow();
        p.setEstado(false);
        return repo.save(p);
    }

}
