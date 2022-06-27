package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Person extends Usuario {

	private String name;
	private String type;
	private double puntaje;
	private ListaAsignaciones asignaciones = new ListaAsignaciones();
	private transient List<Entrevista> elecciones = new ArrayList<>();
	protected static final String PERSONA_FISICA = "FISICA";
	protected static final String PERSONA_JURIDICA = "JURIDICA";
	private TicketSimplificado ticketSimplifacadoObtenido;

	public TicketSimplificado getTicketSimplificado() {
		return this.ticketSimplifacadoObtenido;
	}

	public Person(String username, String password, String name, String type) {
		super(username, password);
		this.name = name;
		this.type = type;
		this.puntaje = 0;
	}

	public Person(String username, String password, String name, String type, double puntaje) {
		super(username, password);
		this.name = name;
		this.type = type;
		this.puntaje = puntaje;
	}

	public abstract boolean isEmpleado();

	public ListaAsignaciones getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(ListaAsignaciones asignaciones) {
		this.asignaciones = asignaciones;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getPuntaje() {
		return puntaje;
	}

	// Inicia la ronda de elecciones, por el momento se elije arbitariamente el
	// primer elemento, cuando se implemente interfaz se guardara en elecciones el O
	// LOS objeto clickeado
	public void inicarRondaElecciones() {
		List<Entrevista> listaAsignaciones = new ArrayList<>();
		listaAsignaciones = this.asignaciones.getList();
		Object[] asigna = listaAsignaciones.toArray();
		elecciones.add((Entrevista) asigna[0]);
	}

	public List<Entrevista> getElecciones() {
		return elecciones;
	}

	public void setElecciones(List<Entrevista> elecciones) {
		this.elecciones = elecciones;
	}

	public void modificarPuntaje(double x) {
		this.puntaje += x;
	}

	@Override
	public String toString() {
		String nombre = type.toUpperCase().equals(PERSONA_FISICA) ? "Nombre: " + getName()
				: "Razon Social: " + getName();
		return super.toString() + nombre + "\nPersona: " + getType() + "\nPuntuacion: " + getPuntaje();
	}

}
