package com.lavanderiapiscis.sistemaweb.controller;

import com.lavanderiapiscis.sistemaweb.model.UsuarioModel;
import com.lavanderiapiscis.sistemaweb.service.EmpleadoService;
import com.lavanderiapiscis.sistemaweb.service.RolService;
import com.lavanderiapiscis.sistemaweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("mantenimientos/usuarios")
    public String mostrarUsuarios(Model model) {
        List<UsuarioModel> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/usuarios";  // templates/usuario/usuarios.html
    }

    @GetMapping("/mantenimientos/usuarios/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("nuevoUsuario", new UsuarioModel());
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("roles", rolService.findAll());
        return "usuario/nuevoUsuario";
    }

    @PostMapping("/mantenimientos/usuarios/nuevo")
    public String agregarUsuario(@ModelAttribute UsuarioModel nuevoUsuario) {
        usuarioService.add(nuevoUsuario);
        return "redirect:/mantenimientos/usuarios";
    }

    @GetMapping("/mantenimientos/usuarios/editar/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable int id, Model model) {
        UsuarioModel usuario = usuarioService.findById(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("roles", rolService.findAll());
        return "usuario/editarUsuario";
    }

    @PostMapping("/mantenimientos/usuarios/editar/{id}")
    public String actualizarUsuario(@PathVariable int id, @ModelAttribute UsuarioModel usuarioActualizado) {
        usuarioService.update(usuarioActualizado, id);
        return "redirect:/mantenimientos/usuarios";
    }

    @PostMapping("/mantenimientos/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        usuarioService.delete(id);
        return "redirect:/mantenimientos/usuarios";
    }

    @PostMapping("/mantenimientos/usuarios/habilitar/{id}")
    public String habilitarUsuario(@PathVariable int id) {
        usuarioService.enable(id);
        return "redirect:/mantenimientos/usuarios";
    }

    @PostMapping("/mantenimientos/usuarios/deshabilitar/{id}")
    public String deshabilitarUsuario(@PathVariable int id) {
        usuarioService.disable(id);
        return "redirect:/mantenimientos/usuarios";
    }
}
