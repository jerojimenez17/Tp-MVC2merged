package models;

import java.io.Serializable;

public class Contratacion implements Serializable{
	private TicketEmpleador ticketEmpleador;
	private Empleador empleador;
	private Empleado empleado;
	private double sueldoAcordado;
	
	public double getSueldoAcordado() {
		return sueldoAcordado;
	}

	public void setSueldoAcordado(double sueldoAcordado) {
		this.sueldoAcordado = sueldoAcordado;
	}

	public Contratacion(TicketEmpleador ticketEmpleador, Empleador empleador, Empleado empleado,double sueldo) {
		this.ticketEmpleador = ticketEmpleador;
		this.empleador = empleador;
		this.empleado = empleado;
		this.sueldoAcordado=sueldo;
	}

	public TicketEmpleador getTicketEmpleador() {
		return ticketEmpleador;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	@Override
	public String toString() {
		return "Contratacion [empleador=" + empleador + ", empleado=" + empleado + ", sueldoAcordado=" + sueldoAcordado
				+ "]";
	}
	
	
	
	
	

}