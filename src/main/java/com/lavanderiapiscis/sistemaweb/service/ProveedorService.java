package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;

import com.lavanderiapiscis.sistemaweb.model.ProveedorModel;

public interface ProveedorService {
    List<ProveedorModel> findAll();
    List<ProveedorModel> findAllCustom();
    ProveedorModel findById(int id);
    ProveedorModel add(ProveedorModel obj);
    ProveedorModel update(ProveedorModel obj, int id);
    ProveedorModel delete(int id);   // deshabilita
    ProveedorModel enable(int id);
    ProveedorModel disable(int id);

}
