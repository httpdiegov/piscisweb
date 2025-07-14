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
@Entity(name = "DetalleBoletaModel")
@Table(name = "DetalleBoleta")
public class DetalleBoletaModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "DetalleID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "BoletaID", nullable = false)
	private BoletaModel boleta;
	
	@Column(name = "TipoCobro", nullable = false, unique = false)
	private String tipoCobro;
	
	@Column(name = "PrendaNombre", length = 100,nullable = true, unique = false)
	private String prendaNombre;
	
	@Column(name = "Peso", nullable = true, unique = false)
	private double peso;
	
	@Column(name = "Precio", nullable = true, unique = false)
	private double precio;


}
