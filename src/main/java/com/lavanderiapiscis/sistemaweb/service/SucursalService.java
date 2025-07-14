package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;

import com.lavanderiapiscis.sistemaweb.model.SucursalModel;

public interface SucursalService {
    List<SucursalModel> findAll();
    List<SucursalModel> findAllCustom();
    SucursalModel findById(int id);
    SucursalModel update(SucursalModel obj, int id);
    SucursalModel delete(int id);
    SucursalModel enable(int id);
    SucursalModel disable(int id);
    SucursalModel add(SucursalModel s);
}
