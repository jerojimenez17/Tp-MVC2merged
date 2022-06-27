package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exceptions.ContrasenaIncorrectaException;
import exceptions.NoSeEncontroUsuarioException;
import exceptions.NombreExistenteException;

public class Agencia extends Usuario {
	private transient String rangoLaboral;
	private List<Empleado> empleados;
	protected static final String[] tiposPuesto = { "Junior", "Senior", "Management" };
	private List<Empleador> empleadores;
	private transient List<TicketEmpleador> ticketsEmpleadores;
	private transient List<TicketEmpleado> ticketsEmpleados;
	protected List<Entrevista> entrevistas;// saco static
	private List<Contratacion> contrataciones;
	protected static final int RANGO_ETARIO_INF = 30;
	protected static final int RANGO_ETARIO_SUP = 50;

	protected static final String EDAD_MENOR = "Menor de 30";
	protected static final String EDAD_MEDIO = "Entre 30 y 50";
	protected static final String EDAD_MAYOR = "Mayor de 50";

	private transient BolsaDeTrabajo bolsaDeTrabajo;

	public Agencia(String userName, String password) {
		super(userName, password);
		this.contrataciones = new ArrayList<>();
		this.empleadores = new ArrayList<>();
		this.empleados = new ArrayList<>();
		this.ticketsEmpleadores = new ArrayList<>();
		this.ticketsEmpleados = new ArrayList<>();
		this.entrevistas = new ArrayList<>();
		this.bolsaDeTrabajo = new BolsaDeTrabajo();
	}

	public void addEmpleador(Empleador e) {
		empleadores.add(e);
	}

	public void addEmpleado(Empleado e) {
		empleados.add(e);
	}

	public BolsaDeTrabajo getBolsaDeTrabajo() {

		return this.bolsaDeTrabajo;
	}

	public List<Empleador> getEmpleadores() {
		return empleadores;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public List<Entrevista> getEntrevistas() {
		return entrevistas;
	}

	public void iniciarRondaEncuentros() {
		for (Empleador empleador : empleadores) {
			for (TicketEmpleador ticketEmpleador : empleador.getTicketsEmitidos()) {
				for (Empleado empleado : empleados) {
					if (/*
						 * ticketEmpleador.getEstado() == Ticket.ESTADO_ACTIVO
						 * && empleado.getTicket().getEstado() == Ticket.ESTADO_ACTIVO
						 */
					ticketEmpleador.getState().toString().equals("activo")
							&& empleado.getTicket().getState().toString().equals("activo")) {
						Entrevista entrevista = new Entrevista(empleador, empleado, ticketEmpleador,
								empleado.getTicket());

						entrevista.setCompatibilidad(compatibilidad(empleado.getTicket(), ticketEmpleador));
						entrevistas.add(entrevista);
						entrevistas.sort((e1, e2) -> e1.getCompatibilidad() > e2.getCompatibilidad() ? -1 : 1);
					}
				}
			}
		}
	}

	// Calcula la compatibilidad entre un ticket de empleado y un ticket de
	// empleador, toma el valor obtenido y lo multiplica por el peso de la
	// caracteristica, establecido por el empleador o 1 por defecto?
	private double compatibilidad(TicketEmpleado empleado, TicketEmpleador ticketEmpleador) {
		return ticketEmpleador.getFormulario().getLocacion().versus(empleado.getFormulario().getLocacion())
				+ ticketEmpleador.getFormulario().getCargaHoraria().versus(empleado.getFormulario().getCargaHoraria())
				+ ticketEmpleador.getFormulario().getEleccionEdad().versus(empleado.getFormulario().getEleccionEdad())
				+ ticketEmpleador.getFormulario().getEstudios().versus(empleado.getFormulario().getEstudios())
				+ ticketEmpleador.getFormulario().getExperiencia().versus(empleado.getFormulario().getExperiencia())
				+ ticketEmpleador.getFormulario().getRemuneracion().versus(empleado.getFormulario().getRemuneracion())
				+ ticketEmpleador.getFormulario().getTipoPuesto().versus(empleado.getFormulario().getTipoPuesto());
	}

	// Recibe un Ticket de empleador y devuelve su lista de asignaciones, filtrando
	// la lista de
	// entrevistas, TO DO: filtrar por ticket

	// usuario es Empleador o Empleado, pero uso el equals de Usuario
	// Supongo asignaciones ordenada
	public ListaAsignaciones getAsignaciones(Person usuario) {
		List<Entrevista> asignaciones = new ArrayList<>();
		for (Entrevista entrevista : entrevistas) {
			if (entrevista.contieneUsuario(usuario)) {
				asignaciones.add(entrevista);
			}

		}

		ListaAsignaciones asig = new ListaAsignaciones(asignaciones, LocalDate.now());

		return asig;
	}

	// Se evalua por cada empleador su lista de elecciones, si esta eleccion tambien
	// esta en las elecciones de el empleado hay contratacion
	public void IniciarRondaContratacion() {
		for (Empleador empleador : empleadores) {
			for (Entrevista eleccionEmpleador : empleador.getElecciones())
				if (eleccionEmpleador.getEmpleado().getElecciones().contains(eleccionEmpleador)) {
					contratacion(eleccionEmpleador);
				}
		}
	}

	private void contratacion(Entrevista e) {
		double sueldoAcordado = 10000; // Este sera el sueldo acordado entre las partes que sera pedido al momento de
										// la contratacion
		Contratacion contratacion = new Contratacion(e.getTicketEmpleador(), e.getEmpleador(), e.getEmpleado(),
				sueldoAcordado);
		e.getEmpleado().addContratacion(contratacion);
		e.getEmpleador().addContratacion(contratacion);
		System.out.println(contratacion);
		System.out.println("///////hay tantas contrataciones: " + this.getContrataciones().size());
		this.contrataciones.add(contratacion);

		System.out.println("///////hay tantas contrataciones: " + this.getContrataciones().size());
		// System.out.println(e.getEmpleado().getContrataciones().size());

		System.out.println("************************" + contratacion);
		e.getTicketEmpleador().addEmpleadoObtenido();
		if (e.getTicketEmpleador().getState().toString() == "finalizado") {
			e.getEmpleador().modificarPuntaje(50);
		}
		e.getEmpleado().getTicket().setResultadoExito();
		e.getEmpleado().getTicket().setState(new FinalizarState(e.getEmpleado().getTicket()));
		e.getEmpleado().modificarPuntaje(10);

	}

	public void setPuntaje(Person p) {
		if (p.isEmpleado()) { // Si es empleado
			for (Empleador empleador : empleadores) { // Recorro los empleadores
				int i = 0;
				for (Entrevista entrevista : empleador.getAsignaciones().getList()) { // Recorro sus asignaciones
					if (i == 0 && entrevista.getEmpleado().equals(p)) { // SI ES EL PRIMERO Y LA ENTREVISTA CONTIENE AL
																		// EMPLEADO
						p.modificarPuntaje(5); // modifico puntaje al empleado +5
					} else if (i == empleador.getAsignaciones().getList().size()
							&& empleador.getAsignaciones().getList().contains(p)) { // Si es el ultimo y la entrevista
																					// lo contiene
						p.modificarPuntaje(-5);
					}
					i++;
				}
			}
		} else {
			boolean ningunaEleccion = true;
			for (Empleado empleado : empleados) {
				int i = 0;
				for (Entrevista entrevista : empleado.getAsignaciones().getList()) { // To Do usar while
					if (i == 0 && entrevista.getEmpleador().equals(p)) {
						p.modificarPuntaje(10);
						ningunaEleccion = false;
					} else if (entrevista.getEmpleador().equals(p)) {
						ningunaEleccion = false;
					}
				}
			}
			if (ningunaEleccion) {
				p.modificarPuntaje(-5);
			}
		}
	}

	public void comision() {
		for (Contratacion contratacion : contrataciones) {
			double comicionEmpleado, comicionEmpleador;
			double porcentajeEmpleado = 0, porcentajeEmpleador = 0;
			if (contratacion.getEmpleador().getType().equals("Fisica")) {
				if (contratacion.getEmpleador().getRubro().equals("Salud"))
					porcentajeEmpleador += 0.6;
				else if (contratacion.getEmpleador().getRubro().equals("Comercio Local"))
					porcentajeEmpleador += 0.7;
				else // ES COMERCIO INTERNACIONAL
					porcentajeEmpleador += 0.8;
			} else {// ES PERSONA JURIDICA
				if (contratacion.getEmpleador().getRubro().equals("Salud"))
					porcentajeEmpleador += 0.8;
				else if (contratacion.getEmpleador().getRubro().equals("Comercio Local"))
					porcentajeEmpleador += 0.9;
				else // ES COMERCIO INTERNACIONAL
					porcentajeEmpleador += 1.0;
			}
			porcentajeEmpleador -= contratacion.getEmpleador().getPuntaje() / 100;
			comicionEmpleador = contratacion.getSueldoAcordado() * (1 + porcentajeEmpleador);
			if (contratacion.getEmpleado().getTicket().getFormulario().getTipoPuesto().toString() == "Junior") {
				porcentajeEmpleado += 0.8;
			} else if (contratacion.getEmpleado().getTicket().getFormulario().getTipoPuesto().toString() == "Senior") {
				porcentajeEmpleado += 0.9;
			} else {
				porcentajeEmpleado += 1;
			}
			porcentajeEmpleado -= contratacion.getEmpleado().getPuntaje() / 100;
			comicionEmpleado = contratacion.getSueldoAcordado() * (1 + porcentajeEmpleado);
			System.out.println(
					"El empleador " + contratacion.getEmpleador().getName() + " tiene que pagar " + comicionEmpleador);
			System.out.println(
					"El empleado " + contratacion.getEmpleado().getName() + " tiene que pagar " + comicionEmpleado);
		}

	}

	public Agencia loginAgencia(String username, String password)
			throws NoSeEncontroUsuarioException, ContrasenaIncorrectaException {
		Agencia agencia = null;
		if (this.getUsername().equals(username))
			if (this.isValid(username, password))
				agencia = this;
			else
				throw new ContrasenaIncorrectaException("Contrasena incorrecta, no se pudo logear");
		else
			throw new NoSeEncontroUsuarioException(" usuario inexistente, no se pudo logear", username);

		return agencia;
	}

	// LOGIN USUARIO EMPLEADO CON EXCEPTIONS DE LOGIN
	public Empleado loginEmpleado(String username, String password)
			throws NoSeEncontroUsuarioException, ContrasenaIncorrectaException {
		Empleado empleado = null;
		int i = 0;
		while (i < this.empleados.size() && this.empleados.get(i).getUsername().equals(username) == false)
			i++;
		if (i == this.empleados.size())
			throw new NoSeEncontroUsuarioException(" usuario inexistente, no se pudo logear", username);// System.out.println("Nombre
																										// de usuario
																										// inexistente,
																										// no se pudo
																										// logear");//TIRAR
																										// EXCEPTION
		else if (this.empleados.get(i).isValid(username, password))
			empleado = this.empleados.get(i);
		else
			throw new ContrasenaIncorrectaException("Contrasena incorrecta, no se pudo logear");// System.out.println("Contrasena
																								// incorrecta, no se
																								// pudo logear");//TIRAR
																								// EXCEPTION

		return empleado;
	}

	// LOGIN USUARIO EMPLEADOR CON EXCEPTIONS DE LOGIN
	public Empleador loginEmpleador(String username, String password)
			throws NoSeEncontroUsuarioException, ContrasenaIncorrectaException {
		Empleador empleador = null;
		int i = 0;
		while (i < this.empleadores.size() && this.empleadores.get(i).getUsername().equals(username) == false)
			i++;
		if (i == this.empleadores.size())
			throw new NoSeEncontroUsuarioException(" usuario inexistente, no se pudo logear", username);// System.out.println("Nombre
																										// de usuario
																										// inexistente,
																										// no se pudo
																										// logear");//TIRAR
																										// EXCEPTION
		else if (this.empleadores.get(i).isValid(username, password))
			empleador = this.empleadores.get(i);
		else
			throw new ContrasenaIncorrectaException("Contrasena incorrecta, no se pudo logear");// System.out.println("Contrasena
																								// incorrecta, no se
																								// pudo logear");//TIRAR
																								// EXCEPTION

		return empleador;
	}

	// REVISAR ANTES DE AGREGAR EMPLEADO O EMPLEADOR
	public void empleadoValido(Empleado e) throws NombreExistenteException {
		int i = 0;
		while (i < this.empleados.size() && this.empleados.get(i).getUsername().equals(e.getUsername()) == false)
			i++;
		if (i == this.empleados.size()) {
			this.empleados.add(e);
		} else
			throw new NombreExistenteException("Nombre de usuario existente", e.getUsername());
		// System.out.println("Nombre de usuario existente, no se creo nuevo usuario");
	}

	public void empleadorValido(Empleador e) throws NombreExistenteException {
		int i = 0;
		while (i < this.empleadores.size() && this.empleadores.get(i).getUsername().equals(e.getUsername()) == false)
			i++;
		if (i == this.empleadores.size()) {
			this.empleadores.add(e);

		} else
			throw new NombreExistenteException("Nombre de usuario existente", e.getUsername());
	}

}