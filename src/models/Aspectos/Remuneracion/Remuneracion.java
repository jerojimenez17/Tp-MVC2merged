package models.Aspectos.Remuneracion;

import models.Aspectos.IAspectos;

public abstract class Remuneracion implements IAspectos {
	
	public abstract double versus(IAspectos i);
    public abstract double versusRemuneracionMenorQue();

    public abstract double versusRemuneracionEntreV1yV2();

    public abstract double versusRemuneracionMayorQue();
}
