package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;

import com.lavanderiapiscis.sistemaweb.model.ClienteModel;

public interface ClienteService {
    List<ClienteModel> findAll();
    List<ClienteModel> findAllCustom();
    ClienteModel findById(int id);
    ClienteModel add(ClienteModel cliente);
    ClienteModel update(ClienteModel cliente, int id);
    ClienteModel delete(int id);
    ClienteModel enable(int id);
    ClienteModel disable(int id);
}
