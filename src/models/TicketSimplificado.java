/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author JeroJimenez
 */
public class TicketSimplificado {
    private final List<String> tiposTrabajo = Arrays.asList("COMERCIO LOCAL", "COMERCIO INTERNACIONAL", "SALUD");
    private final List<String> tiposLocacion = Arrays.asList("HOME_OFFICE", "PRESENCIAL", "AMBAS");
    private int eleccionTipoTrabajo;
    private int eleccionLocacion;
    Empleador empleador;

    public TicketSimplificado(int eleccionTipoTrabajo, int eleccionLocacion, Empleador empleador) {
        this.empleador = empleador;
        this.eleccionLocacion = eleccionLocacion;
        this.eleccionTipoTrabajo = eleccionTipoTrabajo;
    }

    public int getEleccionLocacion() {
        return this.eleccionLocacion;
    }

    @Override
    public String toString() {
        return "Trabajo" + this.tiposTrabajo.get(eleccionTipoTrabajo) + "\nLocacion"
                + this.tiposLocacion.get(eleccionLocacion);
    }
}
