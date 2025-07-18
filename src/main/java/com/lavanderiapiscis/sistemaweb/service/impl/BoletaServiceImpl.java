package com.lavanderiapiscis.sistemaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.BoletaModel;
import com.lavanderiapiscis.sistemaweb.model.DetalleBoletaModel;
import com.lavanderiapiscis.sistemaweb.repository.BoletaRepository;
import com.lavanderiapiscis.sistemaweb.service.BoletaService;

@Service
public class BoletaServiceImpl implements BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    @Override
    public List<BoletaModel> findAll() {
        return boletaRepository.findAll();
    }

    @Override
    public List<BoletaModel> findAllCustom() {
        return boletaRepository.findAllCustom();
    }

    @Override
    public BoletaModel findById(int id) {
        return boletaRepository.findById(id).orElse(null);
    }

    @Override
    public BoletaModel add(BoletaModel boleta) {
        return boletaRepository.save(boleta);
    }

    @Override
    public BoletaModel update(BoletaModel boletaActualizada, int id) {
        BoletaModel boletaExistente = boletaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Boleta no encontrada"));

        // Actualiza los campos que quieras (cliente, empleado, sucursal, fechas, estado, total, etc)
        boletaExistente.setCliente(boletaActualizada.getCliente());
        boletaExistente.setEmpleado(boletaActualizada.getEmpleado());
        boletaExistente.setSucursal(boletaActualizada.getSucursal());
        boletaExistente.setFechaEmision(boletaActualizada.getFechaEmision());
        boletaExistente.setFechaEntrega(boletaActualizada.getFechaEntrega());
        boletaExistente.setTotal(boletaActualizada.getTotal());

        // Aquí es importante manejar bien los detalles:
        // Eliminar detalles antiguos si ya no están, agregar los nuevos y actualizar los existentes
        boletaExistente.getDetalles().clear();
        boletaActualizada.getDetalles().forEach(detalle -> {
            detalle.setBoleta(boletaExistente); // relacionar detalle con la boleta existente
            boletaExistente.getDetalles().add(detalle);
        });

        return boletaRepository.save(boletaExistente);
    }


    @Override
    public BoletaModel delete(int id) {
        BoletaModel boleta = boletaRepository.findById(id).orElseThrow();
        return boletaRepository.save(boleta);
    }

    @Override
    public BoletaModel enable(int id) {
        BoletaModel boleta = boletaRepository.findById(id).orElseThrow();
        return boletaRepository.save(boleta);
    }

    @Override
    public BoletaModel disable(int id) {
        BoletaModel boleta = boletaRepository.findById(id).orElseThrow();
        return boletaRepository.save(boleta);
    }
}
