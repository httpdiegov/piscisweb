package com.lavanderiapiscis.sistemaweb.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Entity(name = "BoletaModel")
@Table(name = "Boleta")
public class BoletaModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "BoletaID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ClienteID", nullable = false)
	private ClienteModel cliente;
	
	@ManyToOne
	@JoinColumn(name = "EmpleadoID", nullable = false)
	private EmpleadoModel empleado;
	
	@ManyToOne
	@JoinColumn(name = "SucursalID", nullable = false)
	private SucursalModel sucursal;
	
	@Column(name = "FechaEmision", nullable = false, unique = false)
	private LocalDate fechaEmision;
	
	@Column(name = "FechaEntrega", nullable = false, unique = false)
	private LocalDate fechaEntrega;
	
	@Column(name = "Total", nullable = false, unique = false)
	private double total;

}
