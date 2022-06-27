package models.Aspectos.Locacion;

import models.Aspectos.IAspectos;

public abstract class Locacion implements IAspectos {
	public abstract double versus(IAspectos i);
	
    public abstract double versusHomeOffice();
    
    public abstract double versusPresencial();

    public abstract double versusIndistinto();

}
