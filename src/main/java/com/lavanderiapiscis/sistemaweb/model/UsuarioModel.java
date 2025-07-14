package com.lavanderiapiscis.sistemaweb.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "UsuarioModel")
@Table(name = "Usuario")
public class UsuarioModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "UsuarioID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "EmpleadoID", nullable = false)
	private EmpleadoModel empleado;
	
	@Column(name = "CorreoElectronico", length = 100, nullable = false, unique = true)
	private String correo;
	
	@Column(name = "Clave", length = 100, nullable = false, unique = false)
	private String clave;
	
	@Column(name = "Numero", nullable = false, unique = false)
	private int numero;
	
	@Column(name = "RolID", length = 8, nullable = false, unique = true)
	private String rol;
	
	@Column(name = "Estado", nullable = false, unique = false)
	private boolean estado;
	
	

}
