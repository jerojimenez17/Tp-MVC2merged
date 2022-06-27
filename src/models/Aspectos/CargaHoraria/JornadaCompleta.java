package models.Aspectos.CargaHoraria;

import models.Aspectos.IAspectos;

public class JornadaCompleta extends CargaHoraria {

    @Override
    public double versus(IAspectos a) {
        return  ((CargaHoraria) a).versusJornadaCompleta();
    }

    @Override
    public double versusJornadaCompleta() {
        return 1;
    }

    @Override
    public double versusMediaJornada() {
        return -0.5;
    }

    @Override
    public double versusJornadaExtendida() {
        return -0.5;
    }

    @Override
    public String toString() {
    	return " JornadaCompleta";
    }
}
