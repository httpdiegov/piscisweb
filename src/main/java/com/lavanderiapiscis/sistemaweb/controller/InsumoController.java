package com.lavanderiapiscis.sistemaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.lavanderiapiscis.sistemaweb.model.InsumoModel;
import com.lavanderiapiscis.sistemaweb.model.ProveedorModel;
import com.lavanderiapiscis.sistemaweb.service.InsumoService;
import com.lavanderiapiscis.sistemaweb.service.ProveedorService;

@Controller
@RequestMapping("/mantenimientos/insumos")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @Autowired
    private ProveedorService proveedorService; // para listar proveedores en el formulario

    @GetMapping
    public String mostrarInsumos(Model model) {
        model.addAttribute("insumos", insumoService.findAll());
        return "insumo/insumos";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        InsumoModel nuevo = new InsumoModel();
        nuevo.setProveedor(new ProveedorModel()); // <--- línea clave
        model.addAttribute("nuevoInsumo", nuevo);
        model.addAttribute("proveedores", proveedorService.findAll());
        return "insumo/nuevoInsumo";
    }


    @PostMapping("/nuevo")
    public String agregar(@ModelAttribute InsumoModel nuevoInsumo) {
        // Recuperar el proveedor completo desde el ID
        int proveedorId = nuevoInsumo.getProveedor().getId();
        var proveedorCompleto = proveedorService.findById(proveedorId);
        
        // Asignar el proveedor completo al insumo antes de guardar
        nuevoInsumo.setProveedor(proveedorCompleto);

        insumoService.add(nuevoInsumo);
        return "redirect:/mantenimientos/insumos";
    }



    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable int id, Model model) {
        model.addAttribute("insumo", insumoService.findById(id));
        model.addAttribute("proveedores", proveedorService.findAll());
        return "insumo/editarInsumo";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable int id, @ModelAttribute InsumoModel mod) {
        insumoService.update(mod, id);
        return "redirect:/mantenimientos/insumos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        insumoService.delete(id);
        return "redirect:/mantenimientos/insumos";
    }

    @PostMapping("/habilitar/{id}")
    public String habilitar(@PathVariable int id) {
        insumoService.enable(id);
        return "redirect:/mantenimientos/insumos";
    }

    @PostMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable int id) {
        insumoService.disable(id);
        return "redirect:/mantenimientos/insumos";
    }
}
