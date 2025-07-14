package com.lavanderiapiscis.sistemaweb.service.impl;

import com.lavanderiapiscis.sistemaweb.model.UsuarioModel;
import com.lavanderiapiscis.sistemaweb.repository.UsuarioRepository;
import com.lavanderiapiscis.sistemaweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<UsuarioModel> findAllCustom() {
        return usuarioRepository.findAllCustom();
    }

    @Override
    public UsuarioModel findById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioModel add(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioModel update(UsuarioModel usuario, int id) {
        UsuarioModel existente = usuarioRepository.findById(id).orElseThrow();
        existente.setEmpleado(usuario.getEmpleado());
        existente.setCorreo(usuario.getCorreo());
        existente.setClave(usuario.getClave());
        existente.setNumero(usuario.getNumero());
        existente.setRol(usuario.getRol());
        existente.setEstado(usuario.isEstado());
        return usuarioRepository.save(existente);
    }

    @Override
    public UsuarioModel delete(int id) {
        UsuarioModel usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setEstado(false);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioModel enable(int id) {
        UsuarioModel usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setEstado(true);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioModel disable(int id) {
        UsuarioModel usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setEstado(false);
        return usuarioRepository.save(usuario);
    }
}
