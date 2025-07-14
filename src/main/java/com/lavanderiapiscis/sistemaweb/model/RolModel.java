package com.lavanderiapiscis.sistemaweb.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "RolModel")
@Table(name = "Rol")
public class RolModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "RolID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NombreRol", length = 20, nullable = false, unique = false)
	private String nombreRol;
	
	@Column(name = "Descripcion", length = 200, nullable = false, unique = false)
	private String descripcion;
	
	@Builder.Default
	@Column(name = "Estado", nullable = false, unique = true)
	private boolean estado = true;

	
	

}
