package com.lavanderiapiscis.sistemaweb.controller;

import com.lavanderiapiscis.sistemaweb.model.BoletaModel;
import com.lavanderiapiscis.sistemaweb.model.ClienteModel;
import com.lavanderiapiscis.sistemaweb.model.EmpleadoModel;
import com.lavanderiapiscis.sistemaweb.model.SucursalModel;
import com.lavanderiapiscis.sistemaweb.service.BoletaService;
import com.lavanderiapiscis.sistemaweb.service.ClienteService;
import com.lavanderiapiscis.sistemaweb.service.EmpleadoService;
import com.lavanderiapiscis.sistemaweb.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/mantenimientos/boletas")
    public String mostrarBoletas(Model model) {
        model.addAttribute("boletas", boletaService.findAll());
        return "boleta/boletas";
    }

    @GetMapping("/mantenimientos/boletas/nuevo")
    public String mostrarFormularioNuevaBoleta(Model model) {
    	BoletaModel nuevaBoleta = new BoletaModel();
    	nuevaBoleta.setDetalles(new ArrayList<>()); // 👈 evita errores si la lista está vacía
    	model.addAttribute("nuevaBoleta", nuevaBoleta);


        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("sucursales", sucursalService.findAll());

        return "boleta/nuevaBoleta";
    }
    
    


    @PostMapping("/mantenimientos/boletas/nuevo")
    public String agregarBoleta(@ModelAttribute("nuevaBoleta") BoletaModel nuevaBoleta) {

        // Asegura que cada detalle tenga la referencia a la boleta
        if (nuevaBoleta.getDetalles() != null) {
            nuevaBoleta.getDetalles().forEach(detalle -> detalle.setBoleta(nuevaBoleta));
        }

        boletaService.add(nuevaBoleta); // guarda todo, incluyendo los detalles

        return "redirect:/mantenimientos/boletas";
    }

    @GetMapping("/mantenimientos/boletas/editar/{id}")
    public String mostrarFormularioEditarBoleta(@PathVariable int id, Model model) {
        BoletaModel boleta = boletaService.findById(id);
        model.addAttribute("boleta", boleta);
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("sucursales", sucursalService.findAll());
        return "boleta/editarBoleta";
    }

    @PostMapping("/mantenimientos/boletas/editar/{id}")
    public String actualizarBoleta(@PathVariable int id, @ModelAttribute("boleta") BoletaModel boletaActualizada) {
        boletaService.update(boletaActualizada, id);
        return "redirect:/mantenimientos/boletas";
    }

    @PostMapping("/mantenimientos/boletas/eliminar/{id}")
    public String eliminarBoleta(@PathVariable int id) {
        boletaService.delete(id);
        return "redirect:/mantenimientos/boletas";
    }

    @PostMapping("/mantenimientos/boletas/habilitar/{id}")
    public String habilitarBoleta(@PathVariable int id) {
        boletaService.enable(id);
        return "redirect:/mantenimientos/boletas";
    }

    @PostMapping("/mantenimientos/boletas/deshabilitar/{id}")
    public String deshabilitarBoleta(@PathVariable int id) {
        boletaService.disable(id);
        return "redirect:/mantenimientos/boletas";
    }
}
