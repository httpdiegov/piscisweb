package com.lavanderiapiscis.sistemaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanderiapiscis.sistemaweb.model.ClienteModel;
import com.lavanderiapiscis.sistemaweb.repository.ClienteRepository;
import com.lavanderiapiscis.sistemaweb.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<ClienteModel> findAllCustom() {
        return clienteRepository.findAllCustom();
    }

    @Override
    public ClienteModel findById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public ClienteModel add(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteModel update(ClienteModel cliente, int id) {
        ClienteModel existente = clienteRepository.findById(id).orElseThrow();
        existente.setNombre(cliente.getNombre());
        existente.setApellido(cliente.getApellido());
        existente.setDni(cliente.getDni());
        existente.setNumero(cliente.getNumero());
        existente.setEstado(cliente.isEstado());
        return clienteRepository.save(existente);
    }

    @Override
    public ClienteModel delete(int id) {
        ClienteModel cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setEstado(false);  // Cambia su estado a false (inactivo)
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteModel enable(int id) {
        ClienteModel cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setEstado(true);
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteModel disable(int id) {
        ClienteModel cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setEstado(false);
        return clienteRepository.save(cliente);
    }
}
