package com.lavanderiapiscis.sistemaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	@GetMapping
	public String MostrarInicio() {
		return "index";
	}
	
	//creamos una ruta para el menu principal
	
	@GetMapping("/menuprincipal")
	public String MostrarMenuPrincipal() {
		return "menuprincipal";
	}
}
