package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;

import models.Empleado;
import models.TicketEmpleador;

public interface IVistaEmpleador {
	void addActionListener(ActionListener listener);
	JRadioButton getRBSelected();
	void enableHayTicket();
	DefaultListModel<TicketEmpleador> getModeloListaTicket();
	DefaultListModel<Empleado> getModeloListaEmpleado();
	TicketEmpleador getTicketSelected();
	Empleado getEmpleadoSelected();
}
