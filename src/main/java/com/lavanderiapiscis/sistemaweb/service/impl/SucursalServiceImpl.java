package com.lavanderiapiscis.sistemaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.SucursalModel;
import com.lavanderiapiscis.sistemaweb.repository.SucursalRepository;
import com.lavanderiapiscis.sistemaweb.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalModel> findAll() {
        return sucursalRepository.findAll();
    }

    @Override
    public List<SucursalModel> findAllCustom() {
        return sucursalRepository.findAllCustom();
    }

    @Override
    public SucursalModel findById(int id) {
        // Usamos orElseThrow() para lanzar una excepción si no se encuentra la sucursal
        return sucursalRepository.findById(id).orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID: " + id));
    }

    @Override
    public SucursalModel update(SucursalModel obj, int id) {
        // Se asegura de que la sucursal existe antes de intentar actualizar
        Optional<SucursalModel> optional = sucursalRepository.findById(id);
        if (optional.isPresent()) {
            SucursalModel existing = optional.get();
            existing.setNombreSucursal(obj.getNombreSucursal());
            existing.setDireccion(obj.getDireccion());
            return sucursalRepository.save(existing);
        }
        throw new RuntimeException("Sucursal no encontrada con ID: " + id);
    }

    @Override
    public SucursalModel delete(int id) {
        // Verifica si la sucursal existe antes de deshabilitarla
        SucursalModel sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID: " + id));
        sucursal.setEstado(false); // Soft delete
        return sucursalRepository.save(sucursal);
    }

    @Override
    public SucursalModel enable(int id) {
        // Utiliza orElseThrow para asegurarse de que la sucursal esté presente
        SucursalModel sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID: " + id));
        sucursal.setEstado(true);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public SucursalModel disable(int id) {
        // Verifica si la sucursal existe antes de deshabilitarla
        SucursalModel sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID: " + id));
        sucursal.setEstado(false);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public SucursalModel add(SucursalModel s) {
        return sucursalRepository.save(s);
    }
}
