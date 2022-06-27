package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;


public class VentanaInicial2 extends JFrame implements KeyListener, IVistaLogin{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelBoton;
	private JPanel panelUsrname;
	private JPanel panelPassword;
	private JPanel panelTipoUsuario;
	private JLabel LabelUsername;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textUsername;
	private JLabel LabelPassword;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPasswordField textPassword;
	private JRadioButton rdbtnEmpleado;
	private JRadioButton rdbtnEmpleador;
	private JRadioButton rdbtnAgencia;
	private JLabel LabelUsuario;
	private JButton BotonLogin;
	private JPanel panel_4;
	private JButton BotonRegistrar;
	private JPanel panel_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	

	/**
	 * Create the frame.
	 */
	public VentanaInicial2() {
		setTitle("Sistema Empleo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panelUsrname = new JPanel();
		this.contentPane.add(this.panelUsrname);
		this.panelUsrname.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.LabelUsername = new JLabel("Nombre de Usuario");
		this.LabelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelUsrname.add(this.LabelUsername);
		
		this.panel = new JPanel();
		this.panelUsrname.add(this.panel);
		this.panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		
		this.textUsername = new JTextField();
		this.textUsername.setColumns(10);
		this.textUsername.addKeyListener(this);
		this.panel.add(this.textUsername);
		
		this.panelPassword = new JPanel();
		this.contentPane.add(this.panelPassword);
		this.panelPassword.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.LabelPassword = new JLabel("Contrase\u00F1a");
		this.LabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelPassword.add(this.LabelPassword);
		
		this.panel_2 = new JPanel();
		this.panelPassword.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_2.add(this.panel_3);
		
		this.textPassword = new JPasswordField();
		this.textPassword.addKeyListener(this);
		this.panel_2.add(this.textPassword);
		
		this.panelTipoUsuario = new JPanel();
		this.contentPane.add(this.panelTipoUsuario);
		this.panelTipoUsuario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.LabelUsuario = new JLabel("Usuario");
		this.panelTipoUsuario.add(this.LabelUsuario);
		
		this.rdbtnEmpleado = new JRadioButton("Empleado");
		buttonGroup.add(this.rdbtnEmpleado);
		this.panelTipoUsuario.add(this.rdbtnEmpleado);
		
		this.rdbtnEmpleador = new JRadioButton("Empleador");
		buttonGroup.add(this.rdbtnEmpleador);
		this.panelTipoUsuario.add(this.rdbtnEmpleador);
		
		this.rdbtnAgencia = new JRadioButton("Agencia");
		buttonGroup.add(this.rdbtnAgencia);
		this.panelTipoUsuario.add(this.rdbtnAgencia);
		
		this.panelBoton = new JPanel();
		this.contentPane.add(this.panelBoton);
		this.panelBoton.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_4 = new JPanel();
		this.panelBoton.add(this.panel_4);
		
		this.BotonLogin = new JButton("Iniciar Sesion");
		this.panel_4.add(this.BotonLogin);
		this.BotonLogin.setEnabled(false);
		this.BotonLogin.setActionCommand("Login");
		
		this.panel_5 = new JPanel();
		this.panelBoton.add(this.panel_5);
		
		this.BotonRegistrar = new JButton("Registrarse");
		this.panel_5.add(this.BotonRegistrar);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	
	@SuppressWarnings("deprecation")
	public void keyReleased(KeyEvent e) {
		//System.out.print("Username escrito? "+ (this.textUsername.getText().length()>0));
		//System.out.print("Password escrita? "+ (this.textPassword.getText().length()>0));
		
		this.BotonLogin.setEnabled(this.textUsername.getText().length()>0 && this.textPassword.getText().length()>0);
	}
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.textUsername.getText();
	}

	@SuppressWarnings("deprecation")
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.textPassword.getText();
	}
	
	@Override
	public JRadioButton getRadioButton() {
		JRadioButton radioButton=null;
		if(this.rdbtnAgencia.isSelected())
			radioButton=this.rdbtnAgencia;
		else if(this.rdbtnEmpleado.isSelected())
			radioButton=this.rdbtnEmpleado;
		else if(this.rdbtnEmpleador.isSelected())
			radioButton=this.rdbtnEmpleador;
		return radioButton;
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.BotonLogin.addActionListener(listener);
		this.BotonRegistrar.addActionListener(listener);
		//this.rdbtnAgencia.addActionListener(listener);
		//this.rdbtnEmpleado.addActionListener(listener);
		//this.rdbtnEmpleador.addActionListener(listener);	
	}
	
	@Override
	public void emergenteRButtonNull() {
		JOptionPane.showMessageDialog(this, "Se debe seleccionar un tipo de usuario para logearse");
	}

	@Override
	public void emergenteUsuario(String comentario) {
		JOptionPane.showMessageDialog(this, comentario);
	}

	@Override
	public void emergenteContrasena() {
		JOptionPane.showMessageDialog(this, "Contrasena incorrecta");
		
	}

	
}
