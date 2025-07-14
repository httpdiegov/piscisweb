package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.DistritoModel;

@Service
public interface DistritoService {
	List<DistritoModel> findAll();
	List<DistritoModel> findAllCustom();
	DistritoModel findById(int id);
	DistritoModel update(DistritoModel obj, int id);
	DistritoModel delete(int id);
	DistritoModel enable(int id);
	DistritoModel disable(int id);
	DistritoModel add(DistritoModel v);
}