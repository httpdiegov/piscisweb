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
@Entity(name = "InsumoModel")
@Table(name = "Insumo")
public class InsumoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "InsumoID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ProveedorID", nullable = false)
    private ProveedorModel proveedor;

    @Column(name = "NombreInsumo", length = 30, nullable = false)
    private String nombreInsumo;

    @Column(name = "StockMinimo", nullable = true)
    private Integer stockMinimo;

    @Column(name = "StockActual", nullable = true)
    private Integer stockActual;

    @Column(name = "Estado", nullable = false)
    private boolean estado;
}