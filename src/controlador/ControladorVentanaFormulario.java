package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import models.Agencia;
import models.FormularioBusqueda;
import models.Ticket;
import models.Aspectos.DecoratorAspecto;
import models.Aspectos.DecoratorAspectoPeso;
import models.Aspectos.CargaHoraria.CargaHoraria;
import models.Aspectos.CargaHoraria.JornadaCompleta;
import models.Aspectos.CargaHoraria.JornadaExtendida;
import models.Aspectos.CargaHoraria.JornadaMedia;
import models.Aspectos.Estudios.Estudios;
import models.Aspectos.Estudios.Primario;
import models.Aspectos.Estudios.Secundario;
import models.Aspectos.Estudios.Terciario;
import models.Aspectos.Experiencia.Experiencia;
import models.Aspectos.Experiencia.ExperienciaMedia;
import models.Aspectos.Experiencia.ExperienciaMucha;
import models.Aspectos.Experiencia.ExperienciaNada;
import models.Aspectos.Locacion.Locacion;
import models.Aspectos.Locacion.LocacionHomeOffice;
import models.Aspectos.Locacion.LocacionIndistinto;
import models.Aspectos.Locacion.LocacionPresencial;
import models.Aspectos.RangoEtario.EdadEntreV1yV2;
import models.Aspectos.RangoEtario.EdadMayorQue;
import models.Aspectos.RangoEtario.EdadMenorQue;
import models.Aspectos.RangoEtario.RangoEtario;
import models.Aspectos.Remuneracion.Remuneracion;
import models.Aspectos.Remuneracion.RemuneracionEntreV1yV2;
import models.Aspectos.Remuneracion.RemuneracionMayorQue;
import models.Aspectos.Remuneracion.RemuneracionMenorQue;
import models.Aspectos.TipoPuesto.Junior;
import models.Aspectos.TipoPuesto.Managment;
import models.Aspectos.TipoPuesto.Senior;
import models.Aspectos.TipoPuesto.TipoPuesto;
import vista.IVistaFormulario;
import vista.VentanaFormulario;

public class ControladorVentanaFormulario extends Observable implements ActionListener{
	private IVistaFormulario vista=null;
	private Ticket ticket=null;
	private Agencia agencia=null;
	
	public ControladorVentanaFormulario(IVistaFormulario vista,Ticket ticket,Agencia agencia) {
		this.vista=vista;
		this.vista.addActionListener(this);
		this.ticket=ticket;
		this.agencia=agencia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Aceptar")) {
			int peso1=0,peso2=0,peso3=0,peso4=0,peso5=0,peso6=0,peso7=0;
			boolean condicion=false;
			try {
				peso1=Integer.parseInt(this.vista.getPesoLocacion());
				peso2=Integer.parseInt(this.vista.getPesoRemuneracion());
				peso3=Integer.parseInt(this.vista.getPesoCargaHoraria());
				peso4=Integer.parseInt(this.vista.getPesoPuestoLaboral());
				peso5=Integer.parseInt(this.vista.getPesoRangoEtario());
				peso6=Integer.parseInt(this.vista.getPesoExperiencia());
				peso7=Integer.parseInt(this.vista.getPesoEstudios());
				if(peso1>0 && peso1<=10 && peso2>0 && peso2<=10 && peso3>0 && peso3<=10 &&
					peso4>0 && peso4<=10 && peso5>0 && peso5<=10 && peso6>0 && peso6<=10 &&
					peso7>0 && peso7<=10)
					condicion=true;
				else
					this.vista.emergentePesoIncorrecto();
			}catch(NumberFormatException exception) {
				this.vista.emergentePesoIncorrecto();
			}
			
			
			if(condicion) {
				this.ticket.setFormulario(this.crearFormulario());
				VentanaFormulario v=(VentanaFormulario)this.vista;
				v.setVisible(false);
				this.setChanged();
				this.notifyObservers();
				/*System.out.println(this.vista.getRdbLocacion().getText()+" peso= "+peso1);
				System.out.println(this.vista.getRdbRemuneracion().getText()+" peso= "+peso2);
				System.out.println(this.vista.getRdbCargaHorario().getText()+" peso= "+peso3);
				System.out.println(this.vista.getRdbTipoPuesto().getText()+" peso= "+peso4);
				System.out.println(this.vista.getRdbLRangoEtario().getText()+" peso= "+peso5);
				System.out.println(this.vista.getRdbExperiencia().getText()+" peso= "+peso6);
				System.out.println(this.vista.getRdbEstudios().getText()+" peso= "+peso7);*/
			}
		}
		else if(e.getActionCommand().equals("Cancelar")) {
			VentanaFormulario v=(VentanaFormulario)this.vista;
			v.setVisible(false);
			this.setChanged();
			this.notifyObservers();
			
			
		}	
	}
	public FormularioBusqueda crearFormulario() {
		Locacion locacion=null;
		Remuneracion remuneracion=null;
		CargaHoraria cargaHoraria=null;
		TipoPuesto tipoPuesto=null;
		RangoEtario rangoEtario=null;
		Experiencia experiencia=null;
		Estudios estudios=null;
		int peso;
		/**/
		if(this.vista.getRdbLocacion().getText().equals("Home Office")) 
			locacion=new LocacionHomeOffice();
		else if(this.vista.getRdbLocacion().getText().equals("Presencial"))	
			locacion =new LocacionPresencial();
		else if(this.vista.getRdbLocacion().getText().equals("Indistinto"))
			locacion =new LocacionIndistinto();
		peso=Integer.parseInt(this.vista.getPesoLocacion());
		DecoratorAspecto decoratorLocacionn=new DecoratorAspectoPeso(locacion,peso);
		
		if(this.vista.getRdbRemuneracion().getText().equals("Menor a 50K")) 
			remuneracion=new RemuneracionMenorQue();
		else if(this.vista.getRdbRemuneracion().getText().equals("Entre 50 y 80 K"))	
			remuneracion =new RemuneracionEntreV1yV2();
		else if(this.vista.getRdbRemuneracion().getText().equals("Mas de 80K"))
			remuneracion=new RemuneracionMayorQue();
		peso=Integer.parseInt(this.vista.getPesoRemuneracion());
		DecoratorAspecto decoratorRemuneracion=new DecoratorAspectoPeso(remuneracion,peso);
		
		if(this.vista.getRdbCargaHorario().getText().equals("Media")) 
			cargaHoraria=new JornadaMedia();
		else if(this.vista.getRdbCargaHorario().getText().equals("Completa"))	
			cargaHoraria =new JornadaCompleta();
		else if(this.vista.getRdbCargaHorario().getText().equals("Extendida"))
			cargaHoraria=new JornadaExtendida();
		peso=Integer.parseInt(this.vista.getPesoCargaHoraria());
		DecoratorAspecto decoratorCargaHoraria=new DecoratorAspectoPeso(cargaHoraria,peso);
		
		if(this.vista.getRdbTipoPuesto().getText().equals("Junior")) 
			tipoPuesto=new Junior();
		else if(this.vista.getRdbTipoPuesto().getText().equals("Senior"))	
			tipoPuesto =new Senior();
		else if(this.vista.getRdbTipoPuesto().getText().equals("Managment"))
			tipoPuesto=new Managment();
		peso=Integer.parseInt(this.vista.getPesoPuestoLaboral());
		DecoratorAspecto decoratorTipoPuesto=new DecoratorAspectoPeso(tipoPuesto,peso);
		
		if(this.vista.getRdbLRangoEtario().getText().equals("Menor a 40")) 
			rangoEtario=new EdadMenorQue();
		else if(this.vista.getRdbLRangoEtario().getText().equals("Entre 40 y 50"))	
			rangoEtario =new EdadEntreV1yV2();
		else if(this.vista.getRdbLRangoEtario().getText().equals("Mayor de 50"))
			rangoEtario=new EdadMayorQue();
		peso=Integer.parseInt(this.vista.getPesoRangoEtario());
		DecoratorAspecto decoratorRangoEtario=new DecoratorAspectoPeso(rangoEtario,peso);
		
		if(this.vista.getRdbExperiencia().getText().equals("Nada")) 
			experiencia=new ExperienciaNada();
		else if(this.vista.getRdbExperiencia().getText().equals("Media"))	
			experiencia =new ExperienciaMedia();
		else if(this.vista.getRdbExperiencia().getText().equals("Mucha"))
			experiencia=new ExperienciaMucha();
		peso=Integer.parseInt(this.vista.getPesoExperiencia());
		DecoratorAspecto decoratorExperiencia=new DecoratorAspectoPeso(experiencia,peso);
		
		if(this.vista.getRdbEstudios().getText().equals("Primario")) 
			estudios=new Primario();
		else if(this.vista.getRdbEstudios().getText().equals("Secundario"))	
			estudios =new Secundario();
		else if(this.vista.getRdbEstudios().getText().equals("Terciario"))
			estudios=new Terciario();
		peso=Integer.parseInt(this.vista.getPesoEstudios());
		DecoratorAspecto decoratorEstudios=new DecoratorAspectoPeso(estudios,peso);
		

		FormularioBusqueda formulario=this.ticket.crearFormulario(decoratorLocacionn, decoratorTipoPuesto, decoratorRangoEtario, decoratorExperiencia, decoratorEstudios, decoratorRemuneracion, decoratorCargaHoraria);	
		return formulario;
	}
}
