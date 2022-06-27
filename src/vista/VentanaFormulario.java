package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class VentanaFormulario extends JFrame implements MouseListener,IVistaFormulario, KeyListener{

	private JPanel contentPane;
	private JLabel LabelTituloVentana;
	private JPanel panelPrincipal;
	private JPanel panelLocacion;
	private JPanel panelRemuneracion;
	private JPanel panelCargaHoraria;
	private JPanel panelTipoPuesto;
	private JPanel panelRangoEtario;
	private JPanel panelExperiencia;
	private JPanel panelEstudios;
	private JPanel panelBotones;
	private JLabel LabelLocacion;
	private JRadioButton rdbtnHomeOffice;
	private JRadioButton rdbtnPresencial;
	private JRadioButton rdbtnCualuiera;
	private JLabel LabelRemuneracion;
	private JRadioButton rdbtnHastaV1;
	private JRadioButton rdbtnEntreV1V2;
	private JRadioButton rdbtnMasDeV2;
	private JLabel LabelCargaHoraria;
	private JRadioButton rdbtnMedia;
	private JRadioButton rdbtnCompleta;
	private JRadioButton rdbtnExtendida;
	private JLabel LabelTipoPuesto;
	private JRadioButton rdbtnJunior;
	private JRadioButton rdbtnSenior;
	private JRadioButton rdbtnManagment;
	private JLabel LabelRangoEtario;
	private JRadioButton rdbtnMenor40;
	private JRadioButton rdbtnEntre4050;
	private JRadioButton rdbtnMayor50;
	private JLabel LabelExperiencia;
	private JRadioButton rdbtnNada;
	private JRadioButton rdbtnExpMedia;
	private JRadioButton rdbtnMucha;
	private JLabel LabelEstudios;
	private JRadioButton rdbtnPrimario;
	private JRadioButton rdbtnSecundario;
	private JRadioButton rdbtnTerciario;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JPanel panel;
	private JPanel panel_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private JTextField textPesoLocacion;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField textPesoRemuneracion;
	private JPanel panel_4;
	private JTextField textPesoCargaHoraria;
	private JPanel panel_5;
	private JTextField textPesoPuestoLaboral;
	private JPanel panel_6;
	private JTextField textPesoRangoEtario;
	private JPanel panel_7;
	private JTextField textPesoExperiencia;
	private JPanel panel_8;
	private JTextField textPesoEstudios;

	

	/**
	 * Create the frame.
	 */
	public VentanaFormulario() {
		setTitle("Sistema Empleo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 341);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.LabelTituloVentana = new JLabel("Formulario de Busueda");
		this.LabelTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.LabelTituloVentana, BorderLayout.NORTH);
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(8, 0, 0, 0));
		
		this.panelLocacion = new JPanel();
		this.panelPrincipal.add(this.panelLocacion);
		this.panelLocacion.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.LabelLocacion = new JLabel("Locacion:");
		this.panelLocacion.add(this.LabelLocacion);
		
		this.rdbtnHomeOffice = new JRadioButton("Home Office");
		this.rdbtnHomeOffice.addMouseListener(this);
		buttonGroup.add(this.rdbtnHomeOffice);
		this.panelLocacion.add(this.rdbtnHomeOffice);
		
		this.rdbtnPresencial = new JRadioButton("Presencial");
		this.rdbtnPresencial.addMouseListener(this);
		buttonGroup.add(this.rdbtnPresencial);
		this.panelLocacion.add(this.rdbtnPresencial);
		
		this.rdbtnCualuiera = new JRadioButton("Cualuiera");
		this.rdbtnCualuiera.addMouseListener(this);
		buttonGroup.add(this.rdbtnCualuiera);
		this.panelLocacion.add(this.rdbtnCualuiera);
		
		this.panel_2 = new JPanel();
		this.panelLocacion.add(this.panel_2);
		
		this.textPesoLocacion = new JTextField();
		this.textPesoLocacion.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textPesoLocacion.addKeyListener(this);
		this.panel_2.add(this.textPesoLocacion);
		this.textPesoLocacion.setColumns(10);
		
		this.panelRemuneracion = new JPanel();
		this.panelPrincipal.add(this.panelRemuneracion);
		this.panelRemuneracion.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.LabelRemuneracion = new JLabel("Remuneracion: ");
		this.panelRemuneracion.add(this.LabelRemuneracion);
		
		this.rdbtnHastaV1 = new JRadioButton("Menor a 50K");
		this.rdbtnHastaV1.addMouseListener(this);
		buttonGroup_1.add(this.rdbtnHastaV1);
		this.panelRemuneracion.add(this.rdbtnHastaV1);
		
		this.rdbtnEntreV1V2 = new JRadioButton("Entre 50 y 80 K");
		this.rdbtnEntreV1V2.addMouseListener(this);
		buttonGroup_1.add(this.rdbtnEntreV1V2);
		this.panelRemuneracion.add(this.rdbtnEntreV1V2);
		
		this.rdbtnMasDeV2 = new JRadioButton("Mas de 80K");
		this.rdbtnMasDeV2.addMouseListener(this);
		buttonGroup_1.add(this.rdbtnMasDeV2);
		this.panelRemuneracion.add(this.rdbtnMasDeV2);
		
		this.panel_3 = new JPanel();
		this.panelRemuneracion.add(this.panel_3);
		
		this.textPesoRemuneracion = new JTextField();
		this.textPesoRemuneracion.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textPesoRemuneracion.addKeyListener(this);
		this.textPesoRemuneracion.setColumns(10);
		this.panel_3.add(this.textPesoRemuneracion);
		
		this.panelCargaHoraria = new JPanel();
		this.panelPrincipal.add(this.panelCargaHoraria);
		this.panelCargaHoraria.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.LabelCargaHoraria = new JLabel("Carga Horaria:");
		this.panelCargaHoraria.add(this.LabelCargaHoraria);
		
		this.rdbtnMedia = new JRadioButton("Media");
		this.rdbtnMedia.addMouseListener(this);
		buttonGroup_2.add(this.rdbtnMedia);
		this.panelCargaHoraria.add(this.rdbtnMedia);
		
		this.rdbtnCompleta = new JRadioButton("Completa");
		this.rdbtnCompleta.addMouseListener(this);
		buttonGroup_2.add(this.rdbtnCompleta);
		this.panelCargaHoraria.add(this.rdbtnCompleta);
		
		this.rdbtnExtendida = new JRadioButton("Extendida");
		this.rdbtnExtendida.addMouseListener(this);
		buttonGroup_2.add(this.rdbtnExtendida);
		this.panelCargaHoraria.add(this.rdbtnExtendida);
		
		this.panel_4 = new JPanel();
		this.panelCargaHoraria.add(this.panel_4);
		
		this.textPesoCargaHoraria = new JTextField();
		this.textPesoCargaHoraria.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textPesoCargaHoraria.addKeyListener(this);
		this.textPesoCargaHoraria.setColumns(10);
		this.panel_4.add(this.textPesoCargaHoraria);
		
		this.panelTipoPuesto = new JPanel();
		this.panelPrincipal.add(this.panelTipoPuesto);
		this.panelTipoPuesto.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.LabelTipoPuesto = new JLabel("Puesto Laboral:");
		this.panelTipoPuesto.add(this.LabelTipoPuesto);
		
		this.rdbtnJunior = new JRadioButton("Junior");
		this.rdbtnJunior.addMouseListener(this);
		buttonGroup_3.add(this.rdbtnJunior);
		this.panelTipoPuesto.add(this.rdbtnJunior);
		
		this.rdbtnSenior = new JRadioButton("Senior");
		this.rdbtnSenior.addMouseListener(this);
		buttonGroup_3.add(this.rdbtnSenior);
		this.panelTipoPuesto.add(this.rdbtnSenior);
		
		this.rdbtnManagment = new JRadioButton("Managment");
		this.rdbtnManagment.addMouseListener(this);
		buttonGroup_3.add(this.rdbtnManagment);
		this.panelTipoPuesto.add(this.rdbtnManagment);
		
		this.panel_5 = new JPanel();
		this.panelTipoPuesto.add(this.panel_5);
		
		this.textPesoPuestoLaboral = new JTextField();
		this.textPesoPuestoLaboral.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textPesoPuestoLaboral.addKeyListener(this);
		this.textPesoPuestoLaboral.setColumns(10);
		this.panel_5.add(this.textPesoPuestoLaboral);
		
		this.panelRangoEtario = new JPanel();
		this.panelPrincipal.add(this.panelRangoEtario);
		this.panelRangoEtario.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.LabelRangoEtario = new JLabel("Rango Etario:");
		this.panelRangoEtario.add(this.LabelRangoEtario);
		
		this.rdbtnMenor40 = new JRadioButton("Menor a 40");
		this.rdbtnMenor40.addMouseListener(this);
		buttonGroup_4.add(this.rdbtnMenor40);
		this.panelRangoEtario.add(this.rdbtnMenor40);
		
		this.rdbtnEntre4050 = new JRadioButton("Entre 40 y 50");
		this.rdbtnEntre4050.addMouseListener(this);
		buttonGroup_4.add(this.rdbtnEntre4050);
		this.panelRangoEtario.add(this.rdbtnEntre4050);
		
		this.rdbtnMayor50 = new JRadioButton("Mayor de 50");
		this.rdbtnMayor50.addMouseListener(this);
		buttonGroup_4.add(this.rdbtnMayor50);
		this.panelRangoEtario.add(this.rdbtnMayor50);
		
		this.panel_6 = new JPanel();
		this.panelRangoEtario.add(this.panel_6);
		
		this.textPesoRangoEtario = new JTextField();
		this.textPesoRangoEtario.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textPesoRangoEtario.addKeyListener(this);
		this.textPesoRangoEtario.setColumns(10);
		this.panel_6.add(this.textPesoRangoEtario);
		
		this.panelExperiencia = new JPanel();
		this.panelPrincipal.add(this.panelExperiencia);
		this.panelExperiencia.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.LabelExperiencia = new JLabel("Experiencia:");
		this.panelExperiencia.add(this.LabelExperiencia);
		
		this.rdbtnNada = new JRadioButton("Nada");
		this.rdbtnNada.addMouseListener(this);
		buttonGroup_5.add(this.rdbtnNada);
		this.panelExperiencia.add(this.rdbtnNada);
		
		this.rdbtnExpMedia = new JRadioButton("Media");
		this.rdbtnExpMedia.addMouseListener(this);
		buttonGroup_5.add(this.rdbtnExpMedia);
		this.panelExperiencia.add(this.rdbtnExpMedia);
		
		this.rdbtnMucha = new JRadioButton("Mucha");
		this.rdbtnMucha.addMouseListener(this);
		buttonGroup_5.add(this.rdbtnMucha);
		this.panelExperiencia.add(this.rdbtnMucha);
		
		this.panel_7 = new JPanel();
		this.panelExperiencia.add(this.panel_7);
		
		this.textPesoExperiencia = new JTextField();
		this.textPesoExperiencia.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textPesoExperiencia.addKeyListener(this);
		this.textPesoExperiencia.setColumns(10);
		this.panel_7.add(this.textPesoExperiencia);
		
		this.panelEstudios = new JPanel();
		this.panelPrincipal.add(this.panelEstudios);
		this.panelEstudios.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.LabelEstudios = new JLabel("Estudios:");
		this.panelEstudios.add(this.LabelEstudios);
		
		this.rdbtnPrimario = new JRadioButton("Primario");
		this.rdbtnPrimario.addMouseListener(this);
		buttonGroup_6.add(this.rdbtnPrimario);
		this.panelEstudios.add(this.rdbtnPrimario);
		
		this.rdbtnSecundario = new JRadioButton("Secundario");
		this.rdbtnSecundario.addMouseListener(this);
		buttonGroup_6.add(this.rdbtnSecundario);
		this.panelEstudios.add(this.rdbtnSecundario);
		
		this.rdbtnTerciario = new JRadioButton("Terciario");
		this.rdbtnTerciario.addMouseListener(this);
		buttonGroup_6.add(this.rdbtnTerciario);
		this.panelEstudios.add(this.rdbtnTerciario);
		
		this.panel_8 = new JPanel();
		this.panelEstudios.add(this.panel_8);
		
		this.textPesoEstudios = new JTextField();
		this.textPesoEstudios.setHorizontalAlignment(SwingConstants.RIGHT);
		this.textPesoEstudios.addKeyListener(this);
		this.textPesoEstudios.setColumns(10);
		this.panel_8.add(this.textPesoEstudios);
		
		this.panelBotones = new JPanel();
		this.panelPrincipal.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel = new JPanel();
		this.panelBotones.add(this.panel);
		
		this.btnCancelar = new JButton("Cancelar");
		this.panel.add(this.btnCancelar);
		
		this.panel_1 = new JPanel();
		this.panelBotones.add(this.panel_1);
		
		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setEnabled(false);
		this.panel_1.add(this.btnAceptar);
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
		
		this.keyReleased(null);
			
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAceptar.addActionListener(listener);
		this.btnCancelar.addActionListener(listener);
	}

	@Override
	public JRadioButton getRdbLocacion() {
		JRadioButton radioButton=null;
		if(this.rdbtnHomeOffice.isSelected())
			radioButton=this.rdbtnHomeOffice;
		else if(this.rdbtnPresencial.isSelected())
			radioButton=this.rdbtnPresencial;
		else if(this.rdbtnCualuiera.isSelected())
			radioButton=this.rdbtnCualuiera;
		return radioButton;
	}

	@Override
	public JRadioButton getRdbRemuneracion() {
		JRadioButton radioButton=null;
		if(this.rdbtnHastaV1.isSelected())
			radioButton=this.rdbtnHastaV1;
		else if(this.rdbtnEntreV1V2.isSelected())
			radioButton=this.rdbtnEntreV1V2;
		else if(this.rdbtnMasDeV2.isSelected())
			radioButton=this.rdbtnMasDeV2;
		return radioButton;
	}

	@Override
	public JRadioButton getRdbCargaHorario() {
		JRadioButton radioButton=null;
		if(this.rdbtnMedia.isSelected())
			radioButton=this.rdbtnMedia;
		else if(this.rdbtnCompleta.isSelected())
			radioButton=this.rdbtnCompleta;
		else if(this.rdbtnExtendida.isSelected())
			radioButton=this.rdbtnExtendida;
		return radioButton;
	}

	@Override
	public JRadioButton getRdbTipoPuesto() {
		JRadioButton radioButton=null;
		if(this.rdbtnJunior.isSelected())
			radioButton=this.rdbtnJunior;
		else if(this.rdbtnSenior.isSelected())
			radioButton=this.rdbtnSenior;
		else if(this.rdbtnManagment.isSelected())
			radioButton=this.rdbtnManagment;
		return radioButton;
	}

	@Override
	public JRadioButton getRdbLRangoEtario() {
		JRadioButton radioButton=null;
		if(this.rdbtnMenor40.isSelected())
			radioButton=this.rdbtnMenor40;
		else if(this.rdbtnEntre4050.isSelected())
			radioButton=this.rdbtnEntre4050;
		else if(this.rdbtnMayor50.isSelected())
			radioButton=this.rdbtnMayor50;
		return radioButton;
	}

	@Override
	public JRadioButton getRdbExperiencia() {
		JRadioButton radioButton=null;
		if(this.rdbtnNada.isSelected())
			radioButton=this.rdbtnNada;
		else if(this.rdbtnExpMedia.isSelected())
			radioButton=this.rdbtnExpMedia;
		else if(this.rdbtnMucha.isSelected())
			radioButton=this.rdbtnMucha;
		return radioButton;
	}

	@Override
	public JRadioButton getRdbEstudios() {
		JRadioButton radioButton=null;
		if(this.rdbtnPrimario.isSelected())
			radioButton=this.rdbtnPrimario;
		else if(this.rdbtnSecundario.isSelected())
			radioButton=this.rdbtnSecundario;
		else if(this.rdbtnTerciario.isSelected())
			radioButton=this.rdbtnTerciario;
		return radioButton;
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean condicionRB=false,condicionPesos=false;
		
		if(this.buttonGroup.getSelection()!=null && this.buttonGroup_1.getSelection()!=null &&
				this.buttonGroup_2.getSelection()!=null && this.buttonGroup_3.getSelection()!=null &&
				this.buttonGroup_4.getSelection()!=null && this.buttonGroup_5.getSelection()!=null &&
				this.buttonGroup_6.getSelection()!=null)
			condicionRB=true;
		if(this.textPesoLocacion.getText().length()>0 && this.textPesoRemuneracion.getText().length()>0 &&
				this.textPesoCargaHoraria.getText().length()>0 && this.textPesoPuestoLaboral.getText().length()>0 &&
				this.textPesoRangoEtario.getText().length()>0 && this.textPesoExperiencia.getText().length()>0 &&
				this.textPesoEstudios.getText().length()>0 )
			condicionPesos=true;
		else
			condicionPesos=false;
		
		
		this.btnAceptar.setEnabled(condicionRB && condicionPesos);
	
	}
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void emergentePesoIncorrecto() {
		JOptionPane.showMessageDialog(this,"Numero ingresado incorrecto, ingrese un numero el 1 al 10");
		
	}

	@Override
	public String getPesoLocacion() {
		// TODO Auto-generated method stub
		return this.textPesoLocacion.getText();
	}

	@Override
	public String getPesoRemuneracion() {
		// TODO Auto-generated method stub
		return this.textPesoRemuneracion.getText();
	}

	@Override
	public String getPesoCargaHoraria() {
		// TODO Auto-generated method stub
		return this.textPesoCargaHoraria.getText();
	}

	@Override
	public String getPesoPuestoLaboral() {
		// TODO Auto-generated method stub
		return this.textPesoPuestoLaboral.getText();
	}

	@Override
	public String getPesoRangoEtario() {
		// TODO Auto-generated method stub
		return this.textPesoRangoEtario.getText();
	}

	@Override
	public String getPesoExperiencia() {
		// TODO Auto-generated method stub
		return this.textPesoExperiencia.getText();
	}

	@Override
	public String getPesoEstudios() {
		// TODO Auto-generated method stub
		return this.textPesoEstudios.getText();
	}
	
	/*public void remuneraciones(String V1,String V2) {
	String cadena="Hasta "+V1;
	this.rdbtnHastaV1.setText(cadena);
	cadena="Entre "+V1+" y "+V2;
	this.rdbtnEntreV1V2.setText(cadena);
	cadena="Mas de "+V2;
	this.rdbtnMasDeV2.setText(cadena);
	}*/
}
