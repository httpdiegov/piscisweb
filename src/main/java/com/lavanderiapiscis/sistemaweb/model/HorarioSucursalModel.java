package com.lavanderiapiscis.sistemaweb.model;

import java.io.Serializable;
import java.time.LocalTime;

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
@Entity(name = "HorarioSucursalModel")
@Table(name = "HorarioSucursal")
public class HorarioSucursalModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "HorarioSucursalID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NombreHorario", nullable = false)
	private String nombreHorario;
	
	@Column(name = "HoraAbrir", nullable = false)
	private LocalTime horaAbrir;
	
	@Column(name = "HoraCerrar", nullable = false)
	private LocalTime horaCerrar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SucursalID", nullable = false)
	private SucursalModel sucursal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DiaID", nullable = false)
	private DiaModel dia;
	
	@Column(name = "Estado", nullable = false, unique = false)
	private boolean estado;
	
}
