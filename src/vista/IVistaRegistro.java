package vista;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

import javax.swing.JRadioButton;

public interface IVistaRegistro {
	void addActionListener(ActionListener listener);
	String getUsername();
	String getPassword();
	String getNombre();
	JRadioButton getUsuarioTipo();
	JRadioButton getPersonaTipo();
	JRadioButton getRubro();
	String getApellido();
	String getTelefono();
	String getDNI();
	String getFechaNacimiento();
	void emergenteFechaIncorrecta();
	void keyPressed(KeyEvent e);
	
	void emergenteNombreExistente();
}
