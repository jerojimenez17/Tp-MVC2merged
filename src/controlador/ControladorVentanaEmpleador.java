package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import models.Agencia;
import models.Empleador;
import models.Entrevista;
import models.TicketEmpleador;
import vista.IVistaEmpleador;

public class ControladorVentanaEmpleador implements ActionListener,Observer{
	private IVistaEmpleador vista=null;
	private Agencia agencia=null;
	private Empleador empleador=null;
	
	public ControladorVentanaEmpleador(IVistaEmpleador vista, Agencia agencia, Empleador empleador) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.agencia = agencia;
		this.empleador = empleador;
		this.actualizarListas();
		if(this.empleador.getTickets().size()>0)
			this.vista.enableHayTicket();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.actualizarListas();
		
		if(e.getActionCommand().equals("Nuevo Ticket")) {
			//crear nuevo ticket igual ue en controlador ventana empleado y agregar donde poner 
			// la cantidad de empleados solicitados
		}
		else if(e.getActionCommand().equals("Modificar")) {
			//modificar ticket igual ue en controlador ventana empleado
		}
		else if(e.getActionCommand().equals("Elegir")){
			this.empleador.elegir(this.vista.getEmpleadoSelected(), this.vista.getTicketSelected());
		}else if(e.getActionCommand().equals("Elegir Ticket")) {
			//agregar boton Elegir Ticket para actualizar la lista de empleados segun el ticket selecto
		}
	}
	
	public void actualizarListas() {
		Iterator<TicketEmpleador> itTicket=this.empleador.getTicketsEmitidos().iterator();
		this.vista.getModeloListaTicket().clear();
		while(itTicket.hasNext()) {
			this.vista.getModeloListaTicket().addElement(itTicket.next());
		}
		
		if(this.vista.getTicketSelected()!=null) {
			Iterator<Entrevista> it=this.empleador.getAsignaciones().getList().iterator();
			this.vista.getModeloListaEmpleado().clear();
			while(it.hasNext()) {
				Entrevista entrevista=it.next();
				if(entrevista.getTicketEmpleador().equals(this.vista.getTicketSelected()))
					this.vista.getModeloListaEmpleado().addElement(entrevista.getEmpleado());
			}
		}
			
	}

	@Override
	public void update(Observable o, Object arg) {
		/*ControladorVentanaFormulario cont=(ControladorVentanaFormulario)o;
		if(this.observados.contains(o)) {
			this.vista.completarTicket(empleado.getTicket().toString());
			this.vista.actualizarLista();
			this.actionPerformed(null);
		}else
			throw new IllegalArgumentException();*/
	}
	
	
}
