package com.lavanderiapiscis.sistemaweb.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Entity(name = "SucursalModel")
@Table(name = "Sucursal")
public class SucursalModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "SucursalID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DistritoID", nullable = false)
	private DistritoModel distrito;
	
	@Column(name = "NombreSucursal", length = 50, nullable = false, unique = false)
	private String nombreSucursal;
	
	@Column(name = "Direccion", length = 50, nullable = false, unique = false)
	private String direccion;
	

	
	@Column(name = "Estado", nullable = false, unique = false)
	private boolean estado;
	
	

}
