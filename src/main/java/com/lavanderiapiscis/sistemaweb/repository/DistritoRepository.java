package com.lavanderiapiscis.sistemaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lavanderiapiscis.sistemaweb.model.DistritoModel;

public interface DistritoRepository extends JpaRepository<DistritoModel, Integer> {
	@Query("select v from DistritoModel v where v.estado=true")
	List<DistritoModel> findAllCustom();
}