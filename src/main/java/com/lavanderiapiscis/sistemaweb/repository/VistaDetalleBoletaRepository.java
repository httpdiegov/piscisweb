package com.lavanderiapiscis.sistemaweb.repository;

import com.lavanderiapiscis.sistemaweb.model.VistaDetalleBoletaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VistaDetalleBoletaRepository extends JpaRepository<VistaDetalleBoletaModel, Integer> {
    List<VistaDetalleBoletaModel> findByBoletaId(int boletaId);
}
