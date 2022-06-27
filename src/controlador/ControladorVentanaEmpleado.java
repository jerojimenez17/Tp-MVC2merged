package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JRadioButton;

import models.Agencia;
import models.Empleado;
import models.Entrevista;
import models.FormularioBusqueda;
import vista.IVistaEmpleado;
import vista.VentanaFormulario;

public class ControladorVentanaEmpleado implements ActionListener,Observer{
	private IVistaEmpleado vista=null;
	private Agencia agencia=null;
	private Empleado empleado=null;
	private ArrayList<ControladorVentanaFormulario> observados=new ArrayList<>();

	public ControladorVentanaEmpleado(IVistaEmpleado vista,Agencia agencia,Empleado empleado) {
		this.agencia=agencia;
		this.vista=vista;
		this.empleado=empleado;
		this.actualizarLista();
		this.vista.addActionListener(this);
		if(this.empleado.getTicket().getFormulario()!=null) 
			this.vista.completarTicket(empleado.getTicket().toString());		
		//if(empleado.getTicket()!=null)this.vista.completarTicket(empleado.getTicket().toString());	
	}
	public void addObserver(ControladorVentanaFormulario cont) {
		cont.addObserver(this);
		this.observados.add(cont);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.actualizarLista();
		
		if(e.getActionCommand().equals("Nuevo Ticket")) {
			System.out.println("boton nuevo ticket");
			if(this.empleado.nuevoTicket()) {
				
				VentanaFormulario ventanaFormulario=new VentanaFormulario();
				ControladorVentanaFormulario controladorFormulario=new ControladorVentanaFormulario(ventanaFormulario,this.empleado.getTicket(),this.agencia);
				this.addObserver(controladorFormulario);
				ventanaFormulario.setVisible(true);
				
			}
		}
		else if(e.getActionCommand().equals("Modificar")) {
			JRadioButton rb=this.vista.getRButtonEstado();
			if(rb.getText().equals("Suspender"))
				this.empleado.getTicket().getState().pausar();
			else if(rb.getText().equals("Cancelar"))
				this.empleado.getTicket().getState().cancelar();
			else if(rb.getText().equals("Activar"))
				this.empleado.getTicket().getState().activar();
			this.vista.completarTicket(empleado.getTicket().toString());
		}
		else if(e.getActionCommand().equals("Elegir")) {
			this.empleado.elegir(this.vista.getSelectedValue());
		}
	}
	
	public void actualizarLista() {
		Iterator<Entrevista> it=this.empleado.getAsignaciones().getList().iterator();
		this.vista.getModeloLista().clear();
		while(it.hasNext()) {
			this.vista.getModeloLista().addElement(it.next().getEmpleador());
		}
		
	}


	@Override
	public void update(Observable o, Object arg) {
		ControladorVentanaFormulario cont=(ControladorVentanaFormulario)o;
		if(this.observados.contains(o)) {
			this.vista.completarTicket(empleado.getTicket().toString());
			this.vista.actualizarLista();
			this.actionPerformed(null);
		}else
			throw new IllegalArgumentException();
	}
}
