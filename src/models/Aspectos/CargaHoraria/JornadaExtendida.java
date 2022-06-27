package models.Aspectos.CargaHoraria;

import models.Aspectos.IAspectos;

public class JornadaExtendida extends CargaHoraria {

    @Override
    public double versus(IAspectos a) {
        return ((CargaHoraria) a).versusJornadaExtendida();
    }

    @Override
    public double versusJornadaCompleta() {
        return -0.5;
    }

    @Override
    public double versusMediaJornada() {
        return -1;
    }

    @Override
    public double versusJornadaExtendida() {
        return 1;
    }
    @Override
    public String toString() {
    	return " JornadaExtendida";
    }
}
