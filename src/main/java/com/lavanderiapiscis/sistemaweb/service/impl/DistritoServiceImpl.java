package com.lavanderiapiscis.sistemaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.DistritoModel;
import com.lavanderiapiscis.sistemaweb.repository.DistritoRepository;
import com.lavanderiapiscis.sistemaweb.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoModel> findAll() {
        return distritoRepository.findAll();
    }

    @Override
    public List<DistritoModel> findAllCustom() {
        return distritoRepository.findAllCustom();
    }

    @Override
    public DistritoModel findById(int id) {
        return distritoRepository.findById(id).orElse(null);
    }

    @Override
    public DistritoModel update(DistritoModel obj, int id) {
        Optional<DistritoModel> optional = distritoRepository.findById(id);
        if (optional.isPresent()) {
            DistritoModel existing = optional.get();
            existing.setDistrito(obj.getDistrito());
            return distritoRepository.save(existing);
        }
        throw new RuntimeException("Distrito no encontrado con ID: " + id);
    }

    @Override
    public DistritoModel delete(int id) {
        Optional<DistritoModel> optional = distritoRepository.findById(id);
        if (optional.isPresent()) {
            DistritoModel distrito = optional.get();
            distrito.setEstado(false); // Soft delete
            return distritoRepository.save(distrito);
        }
        throw new RuntimeException("Distrito no encontrado con ID: " + id);
    }

    @Override
    public DistritoModel enable(int id) {
    	DistritoModel distrito = distritoRepository.findById(id).get();
            distrito.setEstado(true);
            return distritoRepository.save(distrito);
    }
    
    @Override
    public DistritoModel disable(int id) {
    	DistritoModel distrito = distritoRepository.findById(id).get();
            distrito.setEstado(false);
            return distritoRepository.save(distrito);
    }
    @Override
    public DistritoModel add(DistritoModel d) {
        return distritoRepository.save(d);
    }
}
