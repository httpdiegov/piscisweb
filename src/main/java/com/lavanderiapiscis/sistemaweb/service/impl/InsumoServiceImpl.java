package com.lavanderiapiscis.sistemaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.InsumoModel;
import com.lavanderiapiscis.sistemaweb.repository.InsumoRepository;
import com.lavanderiapiscis.sistemaweb.service.InsumoService;

@Service
public class InsumoServiceImpl implements InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public List<InsumoModel> findAll() {
        return insumoRepository.findAll();
    }

    @Override
    public InsumoModel findById(int id) {
        Optional<InsumoModel> optional = insumoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void add(InsumoModel insumo) {
        insumoRepository.save(insumo);
    }

    @Override
    public void update(InsumoModel insumo, int id) {
        insumo.setId(id);
        insumoRepository.save(insumo);
    }

    @Override
    public void delete(int id) {
        insumoRepository.deleteById(id);
    }

    @Override
    public void enable(int id) {
        InsumoModel insumo = findById(id);
        if (insumo != null) {
            insumo.setEstado(true);
            insumoRepository.save(insumo);
        }
    }

    @Override
    public void disable(int id) {
        InsumoModel insumo = findById(id);
        if (insumo != null) {
            insumo.setEstado(false);
            insumoRepository.save(insumo);
        }
    }
}
