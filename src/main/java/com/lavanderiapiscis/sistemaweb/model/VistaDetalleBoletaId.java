package com.lavanderiapiscis.sistemaweb.model;

import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VistaDetalleBoletaId implements Serializable {
    private int boletaId;
    private int detalleID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VistaDetalleBoletaId)) return false;
        VistaDetalleBoletaId that = (VistaDetalleBoletaId) o;
        return boletaId == that.boletaId && detalleID == that.detalleID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boletaId, detalleID);
    }
}
