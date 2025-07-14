package com.lavanderiapiscis.sistemaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lavanderiapiscis.sistemaweb.model.DistritoModel;
import com.lavanderiapiscis.sistemaweb.service.DistritoService;

@Controller
public class DistritoController {
    
    @Autowired
    private DistritoService distritoService;
    
    @GetMapping("/distritos")
    public String mostrarDistritos(Model model) {
        try {
            List<DistritoModel> distritos = distritoService.findAll();
            model.addAttribute("distritos", distritos);
            model.addAttribute("nuevoDistrito", new DistritoModel());
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los distritos: " + e.getMessage());
        }
        
        return "distrito/distritos"; // Esto apunta a templates/distrito/distritos.html
    }
   
}