package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import exceptions.ContrasenaIncorrectaException;
import exceptions.NoSeEncontroUsuarioException;
import models.Agencia;
import models.Empleado;
import models.Empleador;
import vista.IVistaLogin;
import vista.VentanaAgencia;
import vista.VentanaEmpleado;
import vista.VentanaEmpleador;
import vista.VentanaInicial2;
import vista.VentanaRegistro;

public class ControladorVentanaLogin implements ActionListener {
	private IVistaLogin vista = null;
	private Agencia agencia = null;

	public ControladorVentanaLogin(IVistaLogin vista, Agencia agencia) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.agencia = agencia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton radioButton;
		if (e.getActionCommand().equals("Registrarse")) {
			System.out.println("BOTON REGISTRARSE");
			VentanaRegistro ventanaRegistro=new VentanaRegistro();
			ControladorVentanaRegistro controladorVentanaRegistro=new ControladorVentanaRegistro(ventanaRegistro,this.agencia);
			ventanaRegistro.setVisible(true);
			VentanaInicial2 v=(VentanaInicial2)this.vista;
			v.setVisible(false);
		} else if (e.getActionCommand().equals("Login")) {
			radioButton = this.vista.getRadioButton();
			if (radioButton != null) {
				if (this.vista.getRadioButton().getText().equals("Agencia")) {
					System.out.println("BOTON LOGIN COMO USUARIO AGENCIA");
					try {
						this.agencia.loginAgencia(this.vista.getUsername(), this.vista.getPassword());
						VentanaAgencia ventanaAgencia=new VentanaAgencia();
						ventanaAgencia.completarTitulo(this.agencia.getUsername());
						ControladorVentanaAgencia controladorAgencia=new ControladorVentanaAgencia(ventanaAgencia,this.agencia);
						VentanaInicial2 v=(VentanaInicial2)this.vista;
						v.setVisible(false);
						ventanaAgencia.setVisible(true);
					} catch (NoSeEncontroUsuarioException e1) {
						this.vista.emergenteUsuario("Username incorrecto para el usuario tipo Agencia");
					} catch (ContrasenaIncorrectaException e1) {
						this.vista.emergenteContrasena();
					}		
				} else if (this.vista.getRadioButton().getText().equals("Empleado")) {
					System.out.println("BOTON LOGIN COMO USUARIO EMPLEADO");
					Empleado empleado=null;
					try {
						empleado=this.agencia.loginEmpleado(this.vista.getUsername(), this.vista.getPassword());
						System.out.println(empleado);
						VentanaEmpleado ventanaEmpleado=new VentanaEmpleado();
						System.out.println("nueva ventana empleado");
						ventanaEmpleado.completarTitulo(empleado.getUsername());
						System.out.println("se completo titulo");
						ControladorVentanaEmpleado controladorEmpleado=new ControladorVentanaEmpleado(ventanaEmpleado,this.agencia,empleado);
						System.out.println("se creo controlador");
						VentanaInicial2 v=(VentanaInicial2)this.vista;
						System.out.println("se casteo vista");
						v.setVisible(false);
						System.out.println("se oculto vista login");
						ventanaEmpleado.setVisible(true);
						System.out.println("intento hacer visible");
					} catch (NoSeEncontroUsuarioException e1) {
						this.vista.emergenteUsuario("Username incorrecto para el usuario tipo Empleado");
					} catch (ContrasenaIncorrectaException e1) {
						this.vista.emergenteContrasena();
					}
					
				} else if (this.vista.getRadioButton().getText().equals("Empleador")) {
					System.out.println("BOTON LOGIN COMO USUARIO EMPLEADOR");
					Empleador empleador=null;
					try {
						empleador=this.agencia.loginEmpleador(this.vista.getUsername(), this.vista.getPassword());
						VentanaEmpleador ventanaEmpleador=new VentanaEmpleador();
						ventanaEmpleador.completarTitulo(empleador.getUsername());
						ControladorVentanaEmpleador controladorEmpleador=new ControladorVentanaEmpleador(ventanaEmpleador,this.agencia,empleador);
						VentanaInicial2 v=(VentanaInicial2)this.vista;
						v.setVisible(false);
						ventanaEmpleador.setVisible(true);
					} catch (NoSeEncontroUsuarioException e1) {
						this.vista.emergenteUsuario("Username incorrecto para el usuario tipo Empleador");
					} catch (ContrasenaIncorrectaException e1) {
						this.vista.emergenteContrasena();
					}
					}
			}
			else this.vista.emergenteRButtonNull();
		}
	}
}
