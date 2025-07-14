package com.lavanderiapiscis.sistemaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lavanderiapiscis.sistemaweb.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    @Query("SELECT c FROM ClienteModel c WHERE c.estado = true")
    List<ClienteModel> findAllCustom();
}
