package models;

import java.io.Serializable;

public class Entrevista implements Serializable{
    private Empleado empleado;
    private Empleador empleador;
    private TicketEmpleador ticketEmpleador;
    private TicketEmpleado ticketEmpleado;
    private double compatibilidad=0;

	public Entrevista(Empleador empleador, Empleado empleado, TicketEmpleador ticketEmpleador, TicketEmpleado ticketEmpleado) {
		this.empleador = empleador;
		this.empleado = empleado;
		this.ticketEmpleador = ticketEmpleador;
		this.ticketEmpleado = ticketEmpleado;
	}
    public Entrevista(TicketEmpleador ticketEmpleador2, TicketEmpleado ticket) {
		this.ticketEmpleador = ticketEmpleador2;
		this.ticketEmpleado = ticket;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public Empleador getEmpleador() {
        return this.empleador;
    }

    public void setTicketEmpleado(TicketEmpleado ticketEmpleado) {
        this.empleado.setTicket(ticketEmpleado);
    }

    public TicketEmpleador getTicketEmpleador() {
        return this.ticketEmpleador;
    }

    public void setTicketEmpleador(TicketEmpleador ticketEmpleador) {
        this.ticketEmpleador = ticketEmpleador;
    }

    public double getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(double compatibilidad) {
        this.compatibilidad = compatibilidad;
    }
	public boolean contieneUsuario(Usuario usuario) { 
		return empleador.equals(usuario) || empleado.equals(usuario);
	}
	 
	@Override
	public String toString() { 
		return "Entrevista:\n\n"
				+ "Empleador: " + empleador.toString() + "\n\n"
				+ "Empleado: " + empleado.toString() + "\n\n"
						+ "Puntaje Obtenido: " + compatibilidad;
	}
}
