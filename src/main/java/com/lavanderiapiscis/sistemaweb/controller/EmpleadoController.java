package com.lavanderiapiscis.sistemaweb.controller;

import com.lavanderiapiscis.sistemaweb.model.EmpleadoModel;
import com.lavanderiapiscis.sistemaweb.model.SucursalModel;
import com.lavanderiapiscis.sistemaweb.service.EmpleadoService;
import com.lavanderiapiscis.sistemaweb.service.SucursalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SucursalService sucursalService;

    // Mostrar todos los empleados
    @GetMapping("/mantenimientos/empleados")
    public String mostrarEmpleados(Model model) {
        List<EmpleadoModel> empleados = empleadoService.findAll();
        model.addAttribute("empleados", empleados);
        return "empleado/empleados";
    }

    // Mostrar formulario para nuevo empleado
    @GetMapping("/mantenimientos/empleados/nuevo")
    public String mostrarFormularioNuevoEmpleado(Model model) {
        // Obtener la lista de sucursales desde el servicio
        List<SucursalModel> sucursales = sucursalService.findAllCustom();
        
        // Agregar el objeto Empleado vacío y la lista de sucursales al modelo
        model.addAttribute("nuevoEmpleado", new EmpleadoModel());
        model.addAttribute("sucursales", sucursales);
        return "empleado/nuevoEmpleado";
    }

    // Procesar el formulario de nuevo empleado
    @PostMapping("/mantenimientos/empleados/nuevo")
    public String agregarEmpleado(@ModelAttribute EmpleadoModel nuevoEmpleado) {
        // Asignar horas predeterminadas si no se proporcionan
        if (nuevoEmpleado.getHoraEntrada() == null) {
            nuevoEmpleado.setHoraEntrada(LocalTime.of(9, 0));  // Hora predeterminada de entrada
        }
        if (nuevoEmpleado.getHoraSalida() == null) {
            nuevoEmpleado.setHoraSalida(LocalTime.of(18, 0));  // Hora predeterminada de salida
        }

        // Verificar si la sucursal es nula
        if (nuevoEmpleado.getSucursal() == null) {
            return "error";  // O redirigir a un formulario de error
        }
        empleadoService.add(nuevoEmpleado);
        return "redirect:/mantenimientos/empleados";  // Redirige a la lista de empleados
    }

    // Mostrar formulario para editar un empleado
    @GetMapping("/mantenimientos/empleados/editar/{id}")
    public String mostrarFormularioEditarEmpleado(@PathVariable int id, Model model) {
        EmpleadoModel empleado = empleadoService.findById(id);
        
        // Obtener la lista de sucursales para el formulario de edición
        List<SucursalModel> sucursales = sucursalService.findAllCustom();
        
        // Agregar el empleado y la lista de sucursales al modelo
        model.addAttribute("empleado", empleado);
        model.addAttribute("sucursales", sucursales);
        return "empleado/editarEmpleado";
    }

    // Procesar el formulario de edición de empleado
    @PostMapping("/mantenimientos/empleados/editar/{id}")
    public String actualizarEmpleado(@PathVariable int id, @ModelAttribute EmpleadoModel empleadoActualizado) {
        // Asignar horas predeterminadas si no se proporcionan
        if (empleadoActualizado.getHoraEntrada() == null) {
            empleadoActualizado.setHoraEntrada(LocalTime.of(9, 0));  // Hora predeterminada de entrada
        }
        if (empleadoActualizado.getHoraSalida() == null) {
            empleadoActualizado.setHoraSalida(LocalTime.of(18, 0));  // Hora predeterminada de salida
        }

        // Asegurarse de que la sucursal esté presente
        if (empleadoActualizado.getSucursal() == null) {
            return "error";  // O redirigir a una página de error
        }
        empleadoService.update(empleadoActualizado, id);
        return "redirect:/mantenimientos/empleados";  // Redirige a la lista de empleados después de la actualización
    }

    // Eliminar un empleado (en este caso, cambiar su estado a "false")
    @PostMapping("/mantenimientos/empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        empleadoService.delete(id);
        return "redirect:/mantenimientos/empleados";  // Redirige a la lista de empleados
    }

    // Habilitar un empleado
    @PostMapping("/mantenimientos/empleados/habilitar/{id}")
    public String habilitarEmpleado(@PathVariable int id) {
        empleadoService.enable(id);
        return "redirect:/mantenimientos/empleados";  // Redirige a la lista de empleados
    }

    // Deshabilitar un empleado
    @PostMapping("/mantenimientos/empleados/deshabilitar/{id}")
    public String deshabilitarEmpleado(@PathVariable int id) {
        empleadoService.disable(id);
        return "redirect:/mantenimientos/empleados";  // Redirige a la lista de empleados
    }
    
    
}
