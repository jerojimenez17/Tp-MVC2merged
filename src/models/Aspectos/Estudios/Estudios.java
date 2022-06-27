package models.Aspectos.Estudios;

import models.Aspectos.IAspectos;

public abstract class Estudios implements IAspectos {

    public abstract double versus(IAspectos i);

    public abstract double versusSecundario();

    public abstract double versusTerciario();
    public abstract double versusPrimario();

}
