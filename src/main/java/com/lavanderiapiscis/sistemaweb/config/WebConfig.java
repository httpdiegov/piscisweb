package com.lavanderiapiscis.sistemaweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

//Define quees una clase de configuracion
@Configuration
public class WebConfig implements WebMvcConfigurer{
//Creamos un metood para definir la resolucion de plantillas
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		//declaramos una variable de tipo ClassLoaderTemplateResolver
		var templateResolver = new ClassLoaderTemplateResolver();
		
		//definimos las carpetas donde se encontraran las pagians web
		templateResolver.setPrefix("templates/");
		
		//deshabilitamos al opcion de cacheable de la aplicacion
		templateResolver.setCacheable(false);
		//definimso el tipo de paginas que van a cargar
		templateResolver.setSuffix(".html");
		
		//definimos el modo de las plantillas de las paginas
		templateResolver.setTemplateMode("HTML5");
		
		//definimos que se permitan caracteres especiales
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		//declaramos un objeto de tipo SpringTemplateEngine
		
		var templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}
	
	// creamos un bean para la resolucion de vistas
	@Bean
	public ViewResolver viewResolver() {
		var viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
}
