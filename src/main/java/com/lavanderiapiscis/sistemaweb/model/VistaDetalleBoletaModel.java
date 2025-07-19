package com.lavanderiapiscis.sistemaweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@IdClass(VistaDetalleBoletaId.class)  // Aquí indicas la clase que define la clave compuesta
@Table(name = "VistaDetalleBoleta")
public class VistaDetalleBoletaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BoletaID")
    private int boletaId;

    @Id
    @Column(name = "DetalleID")
    private int detalleID;

    @Column(name = "FechaEmision")
    private LocalDate fechaEmision;

    @Column(name = "FechaEntrega")
    private LocalDate fechaEntrega;

    @Column(name = "NombreCliente")
    private String nombreCliente;

    @Column(name = "DNICliente")
    private String dniCliente;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "AtendidoPor")
    private String atendidoPor;

    @Column(name = "NombreLavanderia")
    private String nombreLavanderia;

    @Column(name = "DireccionLavanderia")
    private String direccionLavanderia;

    @Column(name = "Distrito")
    private String distrito;

    @Column(name = "Prenda")
    private String prenda;

    @Column(name = "TipoCobro")
    private String tipoCobro;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "PrecioUnitario")
    private Double precioUnitario;

    @Column(name = "Peso")
    private Double peso;

    @Column(name = "Subtotal")
    private Double subtotal;

    @Column(name = "Total")
    private Double total;

    @Column(name = "IGV")
    private Double igv;

    @Column(name = "TotalConIGV")
    private Double totalConIGV;
}
