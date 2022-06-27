package models.Aspectos.CargaHoraria;

import models.Aspectos.IAspectos;

public abstract class CargaHoraria implements IAspectos {

    public abstract double versus(IAspectos c);
    public abstract double versusMediaJornada();
    public abstract double versusJornadaCompleta();
    public abstract double versusJornadaExtendida();
}
