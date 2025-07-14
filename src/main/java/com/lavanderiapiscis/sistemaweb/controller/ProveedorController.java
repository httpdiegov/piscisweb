package com.lavanderiapiscis.sistemaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- IMPORT NECESARIO
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lavanderiapiscis.sistemaweb.model.ProveedorModel;
import com.lavanderiapiscis.sistemaweb.service.ProveedorService;


@Controller
@RequestMapping("/mantenimientos/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String mostrarProveedores(Model model) {
        var lista = proveedorService.findAll();
        model.addAttribute("proveedores", lista);
        return "proveedor/proveedores";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("nuevoProveedor", new ProveedorModel());
        return "proveedor/nuevoProveedor";
    }

    @PostMapping("/nuevo")
    public String agregar(@ModelAttribute ProveedorModel nuevo) {
        proveedorService.add(nuevo);
        return "redirect:/mantenimientos/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable int id, Model model) {
        model.addAttribute("proveedor", proveedorService.findById(id));
        return "proveedor/editarProveedor";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable int id, @ModelAttribute ProveedorModel mod) {
        proveedorService.update(mod, id);
        return "redirect:/mantenimientos/proveedores";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        proveedorService.delete(id);
        return "redirect:/mantenimientos/proveedores";
    }

    @PostMapping("/habilitar/{id}")
    public String habilitar(@PathVariable int id) {
        proveedorService.enable(id);
        return "redirect:/mantenimientos/proveedores";
    }
    
    @PostMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable int id) {
        proveedorService.disable(id);
        return "redirect:/mantenimientos/proveedores";
    }

}
