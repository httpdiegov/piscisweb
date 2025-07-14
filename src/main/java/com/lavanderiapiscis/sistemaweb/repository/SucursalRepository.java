package com.lavanderiapiscis.sistemaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lavanderiapiscis.sistemaweb.model.SucursalModel;

public interface SucursalRepository extends JpaRepository<SucursalModel, Integer> {
    @Query("select v from SucursalModel v where v.estado=true")
    List<SucursalModel> findAllCustom();
}
