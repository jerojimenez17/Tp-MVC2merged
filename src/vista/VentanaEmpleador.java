package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.Empleado;
import models.Entrevista;
import models.TicketEmpleador;

public class VentanaEmpleador extends JFrame implements IVistaEmpleador, MouseListener{

	private JPanel contentPane;
	private JLabel LabelTitulo;
	private JPanel panelPrincipal;
	private JScrollPane scrollPane;
	private JList<TicketEmpleador> listTickets;
	private JLabel LabelTickets;
	private JPanel panelBotones;
	private JScrollPane scrollPane_1;
	private JList <Empleado>list;
	private JLabel LabelEmpleados;
	private JPanel panel;
	private JButton btnNuevoTicket;
	private JPanel panelNuevoTicket;
	private JPanel panelEstadoTicket;
	private JRadioButton rdbtnActivar;
	private JRadioButton rdbtnSuspender;
	private JRadioButton rdbtnCancelar;
	private JButton btnModificarTicket;
	private JPanel panelModificar;
	private JPanel panel_1;
	private JButton btnElegir;
	private JPanel panel_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel<TicketEmpleador> modeloListaTicket;
	private DefaultListModel<Empleado> modeloListaEmpleado;
	

	

	/**
	 * Create the frame.
	 */
	public VentanaEmpleador() {
		setTitle("Sistema Empleo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 381);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.LabelTitulo = new JLabel("Vista Empleador, Usuario: ");
		this.LabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.LabelTitulo, BorderLayout.NORTH);
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelPrincipal.add(this.scrollPane);
		
		this.listTickets = new JList();
		this.listTickets.addMouseListener(this);
		this.scrollPane.setViewportView(this.listTickets);
		
		this.LabelTickets = new JLabel("Tickets");
		this.LabelTickets.setBackground(new Color(240, 240, 240));
		this.LabelTickets.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.LabelTickets);
		
		this.panelBotones = new JPanel();
		this.panelPrincipal.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panelBotones.add(this.panel);
		
		this.panelNuevoTicket = new JPanel();
		this.panelBotones.add(this.panelNuevoTicket);
		
		this.btnNuevoTicket = new JButton("Nuevo Ticket");
		this.panelNuevoTicket.add(this.btnNuevoTicket);
		
		this.panelEstadoTicket = new JPanel();
		this.panelBotones.add(this.panelEstadoTicket);
		this.panelEstadoTicket.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.rdbtnActivar = new JRadioButton("Activar");
		this.rdbtnActivar.setEnabled(false);
		this.rdbtnActivar.addMouseListener(this);
		buttonGroup.add(this.rdbtnActivar);
		this.panelEstadoTicket.add(this.rdbtnActivar);
		
		this.rdbtnSuspender = new JRadioButton("Suspender");
		this.rdbtnSuspender.setEnabled(false);
		this.rdbtnSuspender.addMouseListener(this);
		buttonGroup.add(this.rdbtnSuspender);
		this.panelEstadoTicket.add(this.rdbtnSuspender);
		
		this.rdbtnCancelar = new JRadioButton("Cancelar");
		this.rdbtnCancelar.setEnabled(false);
		this.rdbtnCancelar.addMouseListener(this);
		buttonGroup.add(this.rdbtnCancelar);
		this.panelEstadoTicket.add(this.rdbtnCancelar);
		
		this.panelModificar = new JPanel();
		this.panelBotones.add(this.panelModificar);
		
		this.btnModificarTicket = new JButton("Modificar");
		this.btnModificarTicket.setEnabled(false);
		this.panelModificar.add(this.btnModificarTicket);
		
		this.panel_1 = new JPanel();
		this.panelBotones.add(this.panel_1);
		
		this.panel_2 = new JPanel();
		this.panelBotones.add(this.panel_2);
		
		this.btnElegir = new JButton("Elegir");
		this.btnElegir.setEnabled(false);
		this.panel_2.add(this.btnElegir);
		
		this.scrollPane_1 = new JScrollPane();
		this.panelPrincipal.add(this.scrollPane_1);
		
		this.list = new JList();
		this.scrollPane_1.setViewportView(this.list);
		
		this.LabelEmpleados = new JLabel("Lista Empleados");
		this.LabelEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane_1.setColumnHeaderView(this.LabelEmpleados);
		
		
		this.modeloListaTicket = new DefaultListModel<TicketEmpleador>();
		this.listTickets.setModel(modeloListaTicket);
		this.modeloListaEmpleado=new DefaultListModel<Empleado>();
		this.list.setModel(modeloListaEmpleado);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnElegir.addActionListener(listener);
		this.btnModificarTicket.addActionListener(listener);
		this.btnNuevoTicket.addActionListener(listener);
	}

	@Override
	public JRadioButton getRBSelected() {
		JRadioButton rb=null;
		if(this.rdbtnActivar.isSelected())
			rb=this.rdbtnActivar;
		else if(this.rdbtnCancelar.isSelected())
			rb=this.rdbtnCancelar;
		else if(this.rdbtnSuspender.isSelected())
			rb=this.rdbtnSuspender;
		return rb;
	}
	

	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if(this.listTickets.getSelectedValue()!=null)
			if(this.rdbtnActivar.isSelected()||this.rdbtnCancelar.isSelected()||this.rdbtnSuspender.isSelected())
				this.btnModificarTicket.setEnabled(true);
		
	}

	@Override
	public void enableHayTicket() {
		this.rdbtnActivar.setEnabled(true);
		this.rdbtnCancelar.setEnabled(true);
		this.rdbtnSuspender.setEnabled(true);
	}
	
	public void completarTitulo(String nombre) {
		String titulo=this.LabelTitulo.getText();
		titulo+=nombre;
		this.LabelTitulo.setText(titulo);
	}

	@Override
	public DefaultListModel<TicketEmpleador> getModeloListaTicket() {
		// TODO Auto-generated method stub
		return this.modeloListaTicket;
	}

	@Override
	public TicketEmpleador getTicketSelected() {
		// TODO Auto-generated method stub
		return this.listTickets.getSelectedValue();
	}
	@Override
	public DefaultListModel<Empleado> getModeloListaEmpleado() {
		// TODO Auto-generated method stub
		return this.modeloListaEmpleado;
	}

	@Override
	public Empleado getEmpleadoSelected() {
		// TODO Auto-generated method stub
		return this.list.getSelectedValue();
	}
	
}
