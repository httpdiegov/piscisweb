package com.lavanderiapiscis.sistemaweb.service;

import com.lavanderiapiscis.sistemaweb.model.VistaDetalleBoletaModel;

import java.util.List;

public interface VistaDetalleBoletaService {
    List<VistaDetalleBoletaModel> obtenerDetallesPorBoletaId(int boletaId);
}
