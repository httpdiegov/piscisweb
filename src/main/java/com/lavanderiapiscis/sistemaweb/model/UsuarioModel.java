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
@Entity(name = "UsuarioModel")
@Table(name = "Usuario")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UsuarioID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmpleadoID", nullable = false)
    private EmpleadoModel empleado = new EmpleadoModel();

    @Column(name = "CorreoElectronico", length = 100, nullable = false, unique = true)
    private String correo;

    @Column(name = "Clave", length = 100, nullable = false)
    private String clave;

    @Column(name = "Numero", nullable = false)
    private int numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RolID", nullable = false)
    private RolModel rol;

    @Column(name = "Estado", nullable = false)
    private boolean estado;
}
