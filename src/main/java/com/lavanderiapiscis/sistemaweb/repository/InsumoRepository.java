package com.lavanderiapiscis.sistemaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lavanderiapiscis.sistemaweb.model.InsumoModel;

public interface InsumoRepository extends JpaRepository<InsumoModel, Integer> {
}
