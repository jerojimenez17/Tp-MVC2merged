package models.Aspectos.TipoPuesto;

import models.Aspectos.IAspectos;

public abstract class TipoPuesto implements IAspectos {

	public abstract double versus(IAspectos tipoPuesto);
	public abstract double versusJunior();
	public abstract double versusSenior();
	public abstract double versusManagment();
	
	public abstract double porcentaje();
	@Override
	public String toString() {
		return "Tipo Puesto ";
	}
}
