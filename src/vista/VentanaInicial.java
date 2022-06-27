package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

public class VentanaInicial extends JFrame implements KeyListener, IVistaLogin {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JPanel panelIz;
	private JPanel panelUsername;
	private JPanel panelPassword;

    @Override
    public void emergenteUsuario(String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emergenteContrasena() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	private JPanel panel_2;
	private JLabel LabelUsername;
	private JLabel LabelPassword;
	private JButton BotonLogin;
	private JPanel panelDer;
	private JPanel panelUsername_1;
	private JPanel panelPassword_1;
	private JPanel panel;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JButton BotonRegistrar;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_1;
	private JPanel panel_3;

	

	/**
	 * Create the frame.
	 */
	public VentanaInicial() {
		setTitle("Sistema Empleo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelIz = new JPanel();
		this.panelPrincipal.add(this.panelIz);
		this.panelIz.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panelUsername = new JPanel();
		this.panelIz.add(this.panelUsername);
		this.panelUsername.setLayout(new BorderLayout(0, 0));
		
		this.LabelUsername = new JLabel("Nombre de Usuario");
		this.LabelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelUsername.add(this.LabelUsername, BorderLayout.CENTER);
		
		this.panelPassword = new JPanel();
		this.panelIz.add(this.panelPassword);
		this.panelPassword.setLayout(new BorderLayout(0, 0));
		
		this.LabelPassword = new JLabel("Contrase\u00F1a");
		this.LabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelPassword.add(this.LabelPassword, BorderLayout.CENTER);
		
		this.panel_4 = new JPanel();
		this.panelIz.add(this.panel_4);
		
		this.panel_2 = new JPanel();
		this.panel_4.add(this.panel_2);
		this.panel_2.setLayout(new BorderLayout(0, 0));
		
		this.BotonLogin = new JButton("Iniciar Sesion");
		this.BotonLogin.setActionCommand("Login");
		//this.BotonLogin.addActionListener(this);
		this.BotonLogin.setEnabled(false);
		this.panel_2.add(this.BotonLogin, BorderLayout.CENTER);
		
		this.panelDer = new JPanel();
		this.panelPrincipal.add(this.panelDer);
		this.panelDer.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panelUsername_1 = new JPanel();
		this.panelDer.add(this.panelUsername_1);
		
		this.textUsername = new JTextField();
		//this.textUsername.addActionListener(this);
		this.textUsername.addKeyListener(this);
		this.panelUsername_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panelUsername_1.add(this.panel_1);
		this.panelUsername_1.add(this.textUsername);
		this.textUsername.setColumns(10);
		
		this.panelPassword_1 = new JPanel();
		this.panelDer.add(this.panelPassword_1);
		
		this.textPassword = new JPasswordField();
		//this.textPassword.addActionListener(this);
		this.textPassword.addKeyListener(this);
		this.panelPassword_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panelPassword_1.add(this.panel_3);
		this.panelPassword_1.add(this.textPassword);
		
		this.panel_5 = new JPanel();
		this.panelDer.add(this.panel_5);
		
		this.panel = new JPanel();
		this.panel_5.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.BotonRegistrar = new JButton("Registrarse");
		//this.BotonRegistrar.addActionListener(this);
		this.panel.add(this.BotonRegistrar, BorderLayout.CENTER);
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		this.BotonLogin.setEnabled(this.textUsername.getText().length()>0 && this.textPassword.getText().length()>0);
	
	}
	public void keyTyped(KeyEvent e) {
	}
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.textUsername.getText();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.textPassword.getText();
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.BotonLogin.addActionListener(listener);
		this.BotonRegistrar.addActionListener(listener);
	}

	@Override
	public JRadioButton getRadioButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emergenteRButtonNull() {
		// TODO Auto-generated method stub
		
	}
}
