package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;

import com.lavanderiapiscis.sistemaweb.model.RolModel;

public interface RolService {
    List<RolModel> findAll();
    List<RolModel> findAllCustom();
    RolModel findById(int id);
    RolModel add(RolModel rol);
    RolModel update(RolModel rol, int id);
    RolModel delete(int id);
    RolModel enable(int id);
    RolModel disable(int id);
}
