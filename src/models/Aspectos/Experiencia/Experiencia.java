package models.Aspectos.Experiencia;

import models.Aspectos.IAspectos;

public abstract class Experiencia implements IAspectos {

	public abstract double versus(IAspectos i);
    public abstract double versusExperienciaNada();

    public abstract double versusExperienciaMedia();

    public abstract double versusExperienciaMucha();
}
