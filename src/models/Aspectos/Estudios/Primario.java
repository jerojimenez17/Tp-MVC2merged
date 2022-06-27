package models.Aspectos.Estudios;

import models.Aspectos.IAspectos;

public class Primario extends Estudios {

    @Override
    public double versus(IAspectos a) {
        return ((Estudios)a).versusPrimario();
    }

    @Override
    public double versusPrimario() {
        return 1;
    }

    @Override
    public double versusSecundario() {
        return 1.5;
    }

    @Override
    public double versusTerciario() {
        return 2;
    }
    @Override
    public String toString() {
    	return " Estudios Primarios";
    }
}
