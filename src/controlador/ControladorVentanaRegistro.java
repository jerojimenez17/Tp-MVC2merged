package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JRadioButton;

import exceptions.NombreExistenteException;
import models.Agencia;
import models.Empleado;
import models.Empleador;
import vista.IVistaRegistro;
import vista.VentanaInicial2;
import vista.VentanaRegistro;

public class ControladorVentanaRegistro implements ActionListener {
	private IVistaRegistro vista = null;
	private Agencia agencia = null;

	public ControladorVentanaRegistro(IVistaRegistro vista, Agencia agencia) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.agencia = agencia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Registrarse")) {
			//getUsuarioTipo no puede dar null por bloueo de boton registrarse
			JRadioButton radioButtonUsuario=this.vista.getUsuarioTipo();
			if (radioButtonUsuario.getText().equals("Empleado")) {
				//System.out.println("BOTON REGISTRARSE COMO USUARIO EMPLEADO");
				if(this.formatoFechaCorrecto(this.vista.getFechaNacimiento())) {//formato correcto deberia estar aca o en agencia?
					Empleado empleado=new Empleado(this.vista.getUsername(),this.vista.getPassword(),this.vista.getNombre(),
							this.vista.getApellido(),this.vista.getTelefono(),this.vista.getDNI(),LocalDate.parse(this.vista.getFechaNacimiento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),this.agencia.getBolsaDeTrabajo());
					try {
						this.agencia.empleadoValido(empleado);
						VentanaInicial2 ventanaLogin=new VentanaInicial2();
						ControladorVentanaLogin controladorLogin=new ControladorVentanaLogin(ventanaLogin,this.agencia);
						VentanaRegistro v=(VentanaRegistro)this.vista;
						v.setVisible(false);
						ventanaLogin.setVisible(true);
					} catch (NombreExistenteException e1) {
						this.vista.emergenteNombreExistente();
					}
				}
				else {
					this.vista.emergenteFechaIncorrecta();
				}	
			} else if (radioButtonUsuario.getText().equals("Empleador")) {
					Empleador empleador=new Empleador(this.vista.getUsername(),this.vista.getPassword(),this.vista.getNombre(),
							this.vista.getPersonaTipo().getText(),this.vista.getRubro().getText(),this.agencia.getBolsaDeTrabajo());
					try {
						this.agencia.empleadorValido(empleador);
						VentanaInicial2 ventanaLogin=new VentanaInicial2();
						ControladorVentanaLogin controladorLogin=new ControladorVentanaLogin(ventanaLogin,this.agencia);
						VentanaRegistro v=(VentanaRegistro)this.vista;
						v.setVisible(false);
						ventanaLogin.setVisible(true);
					} catch (NombreExistenteException e1) {
						this.vista.emergenteNombreExistente();
					}			
			}		
		}
		else {
			this.vista.keyPressed(null);
		}
	}

	public boolean formatoFechaCorrecto(String fecha) {
		boolean correcta=false;
		if(fecha.length()==10) {
			if(fecha.charAt(2)=='/' && fecha.charAt(5)=='/') {
				int dia,mes,anio;
				dia= Integer.parseInt(fecha.substring(0, 2));
				mes= Integer.parseInt(fecha.substring(3, 5));
				anio= Integer.parseInt(fecha.substring(6, 10));
				if(dia>0 && dia<=31 && mes>0 && mes<=12 && anio>0 && anio<=9999)
					correcta=true;
			}
		}
		return correcta;
	}

}
