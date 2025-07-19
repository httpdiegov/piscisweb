package com.lavanderiapiscis.sistemaweb.service.impl;

import com.lavanderiapiscis.sistemaweb.model.VistaDetalleBoletaModel;
import com.lavanderiapiscis.sistemaweb.repository.VistaDetalleBoletaRepository;
import com.lavanderiapiscis.sistemaweb.service.VistaDetalleBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VistaDetalleBoletaServiceImpl implements VistaDetalleBoletaService {

    @Autowired
    private VistaDetalleBoletaRepository repository;

    @Override
    public List<VistaDetalleBoletaModel> obtenerDetallesPorBoletaId(int boletaId) {
        return repository.findByBoletaId(boletaId);
    }
}
