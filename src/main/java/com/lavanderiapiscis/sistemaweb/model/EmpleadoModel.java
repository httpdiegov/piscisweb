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
@Entity(name = "EmpleadoModel")
@Table(name = "Empleado")
public class EmpleadoModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "EmpleadoID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "SucursalID", nullable = false)
	private SucursalModel sucursal;
	
	@Column(name = "Nombres", length = 20, nullable = false, unique = false)
	private String nombre;
	
	@Column(name = "Apellido", length = 20, nullable = false, unique = false)
	private String apellido;
	
	@Column(name = "DNI", length = 8, nullable = false, unique = true)
	private String dni;
	
	@Column(name = "Numero", length = 9, nullable = false, unique = false)
	private int numero;
	
	@Column(name = "Estado", nullable = false, unique = false)
	private boolean estado;
	
	

}
