package com.lavanderiapiscis.sistemaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.lavanderiapiscis.sistemaweb.model.SucursalModel;
import com.lavanderiapiscis.sistemaweb.service.DistritoService;
import com.lavanderiapiscis.sistemaweb.service.SucursalService;

@Controller
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;
    
    @Autowired
    private DistritoService distritoService; 

    @GetMapping("/sucursales")
    public String mostrarSucursales(Model model) {
        try {
            List<SucursalModel> sucursales = sucursalService.findAll();
            model.addAttribute("sucursales", sucursales);
            model.addAttribute("nuevaSucursal", new SucursalModel());
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las sucursales: " + e.getMessage());
        }
        return "sucursal/sucursales";
    }



    @GetMapping("/mantenimientos/sucursales/nuevo")
    public String mostrarFormularioNuevaSucursal(Model model) {
        model.addAttribute("nuevaSucursal", new SucursalModel());
        model.addAttribute("distritos", distritoService.findAll()); 
        return "sucursal/nuevaSucursal";
    }

    @PostMapping("/mantenimientos/sucursales/nuevo")
    public String agregarSucursal(@ModelAttribute SucursalModel nuevaSucursal, Model model) {
        try {
            sucursalService.add(nuevaSucursal);
            return "redirect:/sucursales";
        } catch (Exception e) {
            model.addAttribute("error", "Error al agregar la sucursal: " + e.getMessage());
            return "sucursal/nuevaSucursal";
        }
    }

    @GetMapping("/mantenimientos/sucursales/editar/{id}")
    public String mostrarFormularioEditarSucursal(@PathVariable int id, Model model) {
        try {
            SucursalModel sucursal = sucursalService.findById(id);
            if (sucursal == null) {
                model.addAttribute("error", "Sucursal no encontrada");
                return "redirect:/sucursales";
            }
            model.addAttribute("sucursal", sucursal);
            model.addAttribute("distritos", distritoService.findAll());

            return "sucursal/editarSucursal";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la sucursal: " + e.getMessage());
            return "redirect:/sucursales";
        }
    }

    @PostMapping("/mantenimientos/sucursales/editar/{id}")
    public String actualizarSucursal(@PathVariable int id, @ModelAttribute SucursalModel sucursal, Model model) {
        try {
            sucursal.setId(id);
            sucursalService.update(sucursal, id);
            return "redirect:/sucursales";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar la sucursal: " + e.getMessage());
            return "sucursal/editarSucursal";
        }
    }

    @PostMapping("/mantenimientos/sucursales/eliminar/{id}")
    public String eliminarSucursal(@PathVariable int id, Model model) {
        try {
            sucursalService.delete(id);
            return "redirect:/sucursales";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la sucursal: " + e.getMessage());
            return "redirect:/sucursales";
        }
    }

    @PostMapping("/mantenimientos/sucursales/habilitar/{id}")
    public String habilitarSucursal(@PathVariable int id) {
        try {
            sucursalService.enable(id);
            return "redirect:/sucursales";
        } catch (Exception e) {
            return "redirect:/sucursales";
        }
    }

    @PostMapping("/mantenimientos/sucursales/deshabilitar/{id}")
    public String deshabilitarSucursal(@PathVariable int id) {
        try {
            sucursalService.disable(id);
            return "redirect:/sucursales";
        } catch (Exception e) {
            return "redirect:/sucursales";
        }
    }
}
