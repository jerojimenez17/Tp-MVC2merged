package vista;

import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public interface IVistaLogin {
	
	String getUsername();
	String getPassword();
	public JRadioButton getRadioButton();
	void emergenteRButtonNull();
	void emergenteUsuario(String comentario);
	void emergenteContrasena();
	void addActionListener(ActionListener listener);
}
