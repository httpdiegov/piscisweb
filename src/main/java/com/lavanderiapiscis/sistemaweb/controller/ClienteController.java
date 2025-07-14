package com.lavanderiapiscis.sistemaweb.controller;

import com.lavanderiapiscis.sistemaweb.model.ClienteModel;
import com.lavanderiapiscis.sistemaweb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Mostrar todos los clientes
    @GetMapping("/mantenimientos/clientes")
    public String mostrarClientes(Model model) {
        List<ClienteModel> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/clientes";  // Asegúrate de que clientes.html esté en templates/cliente/
    }

    // Mostrar formulario para nuevo cliente
    @GetMapping("/mantenimientos/clientes/nuevo")
    public String mostrarFormularioNuevoCliente(Model model) {
        model.addAttribute("nuevoCliente", new ClienteModel()); // NECESARIO
        return "cliente/nuevoCliente";
    }

    // Procesar el formulario de nuevo cliente
    @PostMapping("/mantenimientos/clientes/nuevo")
    public String agregarCliente(@ModelAttribute ClienteModel nuevoCliente) {
        clienteService.add(nuevoCliente);
        return "redirect:/mantenimientos/clientes";  // Redirige a la lista de clientes
    }

    // Mostrar formulario para editar un cliente
    @GetMapping("/mantenimientos/clientes/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable int id, Model model) {
        ClienteModel cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/editarCliente";
    }

    // Procesar el formulario de edición de cliente
    @PostMapping("/mantenimientos/clientes/editar/{id}")
    public String actualizarCliente(@PathVariable int id, @ModelAttribute ClienteModel clienteActualizado) {
        clienteService.update(clienteActualizado, id);
        return "redirect:/mantenimientos/clientes";  // Redirige a la lista de clientes
    }

    // Eliminar un cliente (cambiar su estado a false)
    @PostMapping("/mantenimientos/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id) {
        clienteService.delete(id);
        return "redirect:/mantenimientos/clientes";  // Redirige a la lista de clientes
    }

    // Habilitar un cliente
    @PostMapping("/mantenimientos/clientes/habilitar/{id}")
    public String habilitarCliente(@PathVariable int id) {
        clienteService.enable(id);
        return "redirect:/mantenimientos/clientes";  // Redirige a la lista de clientes
    }

    // Deshabilitar un cliente
    @PostMapping("/mantenimientos/clientes/deshabilitar/{id}")
    public String deshabilitarCliente(@PathVariable int id) {
        clienteService.disable(id);
        return "redirect:/mantenimientos/clientes";  // Redirige a la lista de clientes
    }
}
