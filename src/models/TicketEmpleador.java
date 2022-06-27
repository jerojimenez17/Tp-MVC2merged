package models;

import java.util.ArrayList;
import java.util.List;

// Representa al ticket de busqueda de empleado
public class TicketEmpleador extends Ticket {
	private int empleadosSolicitados;
	private int empleadosObtenidos;
	private FormularioBusqueda form;
	public TicketEmpleador(int empleadosSolicitados, int empleadosObtenidos) {
		super();
		this.empleadosSolicitados = empleadosSolicitados;
		this.empleadosObtenidos = empleadosObtenidos;
	}

	// devuelve la cantidad de empleados solicitantes
	public int getCantidadSolicitados() {
		return empleadosSolicitados;
	}

	// devuelve la cantidad de empleados obtenidos
	public int getCantidadObtenidos() {
		return empleadosObtenidos;
	}

	// agrega un empleado a la lista de empleados obtenidos
	public void addEmpleadoObtenido() {
		if (empleadosObtenidos < empleadosSolicitados) {
			empleadosObtenidos++;
		}
		if (empleadosObtenidos == empleadosSolicitados) {
			super.setEstadoFinalizado();
			
		}
	}

	
}
