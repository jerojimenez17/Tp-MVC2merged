package models.Aspectos.Estudios;

import models.Aspectos.IAspectos;

public class Secundario extends Estudios {
    @Override
    public double versus(IAspectos a) {
        return ((Estudios)a).versusSecundario();
    }

    @Override
    public double versusPrimario() {
        return -0.5;
    }

    @Override
    public double versusSecundario() {
        return 1;
    }

    @Override
    public double versusTerciario() {
        return 1.5;
    }
    @Override
    public String toString() {
    	return " Estudios Secundarios";
    }

}
