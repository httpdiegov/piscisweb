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
        double precioPorKilo = 4.0;
        double total = 0.0;

        if (boleta.getDetalles() != null) {
            for (DetalleBoletaModel detalle : boleta.getDetalles()) {
                // Establecer relación boleta-detalle
                detalle.setBoleta(boleta);

                // Calcular el precio si el tipo de cobro es por kilo
                if ("kilo".equalsIgnoreCase(detalle.getTipoCobro())) {
                    double peso = detalle.getPeso() != null ? detalle.getPeso() : 0.0;
                    double precio = peso * precioPorKilo;
                    detalle.setPrecio(precio);
                    total += precio;
                } else if ("unidad".equalsIgnoreCase(detalle.getTipoCobro())) {
                    total += detalle.getPrecio();
                    detalle.setPeso(null); // Aseguramos que el peso no quede con valor si es por unidad
                }
            }
        }

        boleta.setTotal(total);
        return boletaRepository.save(boleta);
    }

    @Override
    public BoletaModel update(BoletaModel boletaActualizada, int id) {
        BoletaModel boletaExistente = boletaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Boleta no encontrada"));

        // Actualiza campos principales
        boletaExistente.setCliente(boletaActualizada.getCliente());
        boletaExistente.setEmpleado(boletaActualizada.getEmpleado());
        boletaExistente.setSucursal(boletaActualizada.getSucursal());
        boletaExistente.setFechaEmision(boletaActualizada.getFechaEmision());
        boletaExistente.setFechaEntrega(boletaActualizada.getFechaEntrega());

        // Limpiar detalles antiguos
        boletaExistente.getDetalles().clear();

        double total = 0.0;

        // Procesar nuevos detalles
        for (DetalleBoletaModel detalle : boletaActualizada.getDetalles()) {
            detalle.setBoleta(boletaExistente); // Enlaza el detalle con la boleta

            // Calcular el precio según tipoCobro
            if ("kilo".equalsIgnoreCase(detalle.getTipoCobro())) {
                if (detalle.getPeso() != null) {
                    detalle.setPrecio(detalle.getPeso() * 4); // Precio por kilo
                } else {
                    detalle.setPrecio(0); // o puedes lanzar una excepción si el peso es obligatorio
                }
            } else {
                // Si no es por kilo, usar el precio que viene o asegurarse de que no sea nulo
                detalle.setPrecio(detalle.getPrecio() != 0 ? detalle.getPrecio() : 0);
            }

            total += detalle.getPrecio(); // Acumula el total

            boletaExistente.getDetalles().add(detalle);
        }

        boletaExistente.setTotal(total);

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
