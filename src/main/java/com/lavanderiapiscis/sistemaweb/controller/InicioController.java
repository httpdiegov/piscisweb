package com.lavanderiapiscis.sistemaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InicioController {
	
	@GetMapping
	public String MostrarInicio() {
		return "index";
	}
	
	//creamos una ruta para el menu principal
	
	@PostMapping("/menu_principal")
	public String MostrarMenuPrincipal() {
		return "menu_principal";
	}
	
	@GetMapping("/menu_principal")
	public String MostrarMenuPrincipalGET() {
		return "menu_principal";
	}
	
	@GetMapping("/mantenimientos")
	public String MostraMantenimientos() {
		return "mantenimientos";
	}
}
