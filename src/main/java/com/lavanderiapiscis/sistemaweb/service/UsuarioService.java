package com.lavanderiapiscis.sistemaweb.service;

import com.lavanderiapiscis.sistemaweb.model.UsuarioModel;

import java.util.List;

public interface UsuarioService {
    List<UsuarioModel> findAll();
    List<UsuarioModel> findAllCustom();
    UsuarioModel findById(int id);
    UsuarioModel add(UsuarioModel usuario);
    UsuarioModel update(UsuarioModel usuario, int id);
    UsuarioModel delete(int id);
    UsuarioModel enable(int id);
    UsuarioModel disable(int id);
}
