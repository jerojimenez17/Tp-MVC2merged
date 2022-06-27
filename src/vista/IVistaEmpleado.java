package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;

import models.Empleador;

public interface IVistaEmpleado {
	void addActionListener(ActionListener listener);
	JRadioButton getRButtonActivar();
	JRadioButton getRButtonSuspender();
	JRadioButton getRButtonCancelar();
	JRadioButton getRButtonEstado();
	void actualizarLista();
	void completarTicket(String ticket);
	DefaultListModel<Empleador> getModeloLista();
	Empleador getSelectedValue();
	void emergenteNoSeCreaTicket();
}
