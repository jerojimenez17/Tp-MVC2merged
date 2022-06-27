package vista;

import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public interface IVistaFormulario {
	void addActionListener(ActionListener listener);
	JRadioButton getRdbLocacion();
	JRadioButton getRdbRemuneracion();
	JRadioButton getRdbCargaHorario();
	JRadioButton getRdbTipoPuesto();
	JRadioButton getRdbLRangoEtario();
	JRadioButton getRdbExperiencia();
	JRadioButton getRdbEstudios();
	//void remuneraciones(String V1,String V2);
	void emergentePesoIncorrecto();
	String getPesoLocacion();
	String getPesoRemuneracion();
	String getPesoCargaHoraria();
	String getPesoPuestoLaboral();
	String getPesoRangoEtario();
	String getPesoExperiencia();
	String getPesoEstudios();
	
}
