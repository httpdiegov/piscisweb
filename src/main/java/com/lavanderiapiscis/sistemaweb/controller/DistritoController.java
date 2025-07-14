package com.lavanderiapiscis.sistemaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "distrito/distritos";
    }

    @GetMapping("/mantenimientos/distritos/nuevo")
    public String mostrarFormularioNuevoDistrito(Model model) {
        model.addAttribute("nuevoDistrito", new DistritoModel());
        return "distrito/nuevoDistrito";
    }

    @PostMapping("/mantenimientos/distritos/nuevo")
    public String agregarDistrito(@ModelAttribute DistritoModel nuevoDistrito, Model model) {
        try {
            distritoService.add(nuevoDistrito);
            return "redirect:/distritos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al agregar el distrito: " + e.getMessage());
            return "distrito/nuevoDistrito";
        }
    }

    @GetMapping("/mantenimientos/distritos/editar/{id}")
    public String mostrarFormularioEditarDistrito(@PathVariable int id, Model model) {
        try {
            DistritoModel distrito = distritoService.findById(id);
            if (distrito == null) {
                model.addAttribute("error", "Distrito no encontrado");
                return "redirect:/distritos";
            }
            model.addAttribute("distrito", distrito);
            return "distrito/editarDistrito";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el distrito: " + e.getMessage());
            return "redirect:/distritos";
        }
    }

    @PostMapping("/mantenimientos/distritos/editar/{id}")
    public String actualizarDistrito(@PathVariable int id, @ModelAttribute DistritoModel distrito, Model model) {
        try {
            distritoService.update(distrito, id);
            return "redirect:/distritos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el distrito: " + e.getMessage());
            return "distrito/editarDistrito";
        }
    }

    @PostMapping("/mantenimientos/distritos/eliminar/{id}")
    public String eliminarDistrito(@PathVariable int id, Model model) {
        try {
            distritoService.delete(id);
            return "redirect:/distritos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el distrito: " + e.getMessage());
            return "redirect:/distritos";
        }
    }

    @PostMapping("/mantenimientos/distritos/habilitar/{id}")
    public String habilitarDistrito(@PathVariable int id) {
        try {
            distritoService.enable(id);
            return "redirect:/distritos";
        } catch (Exception e) {
            return "redirect:/distritos";
        }
    }

    @PostMapping("/mantenimientos/distritos/deshabilitar/{id}")
    public String deshabilitarDistrito(@PathVariable int id) {
        try {
            distritoService.disable(id);
            return "redirect:/distritos";
        } catch (Exception e) {
            return "redirect:/distritos";
        }
    }
}
