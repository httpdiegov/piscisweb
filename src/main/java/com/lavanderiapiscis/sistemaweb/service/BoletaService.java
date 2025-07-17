package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;

import com.lavanderiapiscis.sistemaweb.model.BoletaModel;

public interface BoletaService {
	
	
    List<BoletaModel> findAll();
    List<BoletaModel> findAllCustom();
    BoletaModel findById(int id);
    BoletaModel add(BoletaModel boleta);
    BoletaModel update(BoletaModel boleta, int id);
    BoletaModel delete(int id);
    BoletaModel enable(int id);
    BoletaModel disable(int id);
	

}
