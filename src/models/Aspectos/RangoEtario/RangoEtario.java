package models.Aspectos.RangoEtario;

import models.Aspectos.IAspectos;

public abstract class RangoEtario implements IAspectos {
	public abstract double versus(IAspectos i);
	
    public abstract double versusEdadMenorQue();

    public abstract double versusEdadEntreV1yV2();

    public abstract double versusEdadMayorQue();
}
