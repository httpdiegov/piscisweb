package com.lavanderiapiscis.sistemaweb.controller;

import com.lavanderiapiscis.sistemaweb.model.RolModel;
import com.lavanderiapiscis.sistemaweb.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("mantenimientos/roles")
    public String mostrarRoles(Model model) {
        List<RolModel> roles = rolService.findAll();
        model.addAttribute("roles", roles);
        return "rol/roles"; // Asegúrate de que roles.html esté en templates/rol/
    }

    @GetMapping("/mantenimientos/roles/nuevo")
    public String mostrarFormularioNuevoRol(Model model) {
        model.addAttribute("nuevoRol", new RolModel()); // NECESARIO
        return "rol/nuevoRol";
    }

    @PostMapping("/mantenimientos/roles/nuevo")
    public String agregarRol(@ModelAttribute RolModel nuevoRol) {
        rolService.add(nuevoRol);
        return "redirect:/mantenimientos/roles";  // Corregido aquí
    }

    @GetMapping("/mantenimientos/roles/editar/{id}")
    public String mostrarFormularioEditarRol(@PathVariable int id, Model model) {
        RolModel rol = rolService.findById(id);
        model.addAttribute("rol", rol);
        return "rol/editarRol";
    }

    @PostMapping("/mantenimientos/roles/editar/{id}")
    public String actualizarRol(@PathVariable int id, @ModelAttribute RolModel rolActualizado) {
        rolService.update(rolActualizado, id);
        return "redirect:/mantenimientos/roles";  // Corregido aquí
    }

    @PostMapping("/mantenimientos/roles/eliminar/{id}")
    public String eliminarRol(@PathVariable int id) {
        rolService.delete(id);
        return "redirect:/mantenimientos/roles";  // Corregido aquí
    }

    @PostMapping("/mantenimientos/roles/habilitar/{id}")
    public String habilitarRol(@PathVariable int id) {
        rolService.enable(id);
        return "redirect:/mantenimientos/roles";  // Corregido aquí
    }

    @PostMapping("/mantenimientos/roles/deshabilitar/{id}")
    public String deshabilitarRol(@PathVariable int id) {
        rolService.disable(id);
        return "redirect:/mantenimientos/roles";  // Corregido aquí
    }
}
