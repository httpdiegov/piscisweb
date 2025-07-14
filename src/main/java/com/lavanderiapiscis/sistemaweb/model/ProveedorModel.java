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
@Entity(name = "ProveedorModel")
@Table(name = "Proveedor")
public class ProveedorModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ProveedorID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "BoletaID", nullable = false)
	private BoletaModel boleta;
	
	@Column(name = "RUC", length = 11, nullable = false, unique = true)
	private String ruc;
	
	@Column(name = "RazonSocial", length = 30,nullable = false, unique = false)
	private String razonSocial;
	
	@Column(name = "Direccion", length = 100,nullable = false, unique = false)
	private String direccion;
	
	@Column(name = "Correo", length = 100,nullable = false, unique = false)
	private String correo;
	
	@Column(name = "Numero", length = 9,nullable = false, unique = false)
	private String numero;
	
	@Column(name = "Estado", nullable = false, unique = false)
	private boolean estado;

}
