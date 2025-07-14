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
@Entity(name = "DistritoModel")
@Table(name = "Distrito")
public class DistritoModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "DistritoID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NombreDistrito", length = 50, nullable = false, unique = false)
	private String distrito;
	
	@Column(name = "Estado", nullable = false, unique = false)
	private boolean estado;
	
	

}
