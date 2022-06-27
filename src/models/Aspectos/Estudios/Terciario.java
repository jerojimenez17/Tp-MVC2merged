package models.Aspectos.Estudios;

import models.Aspectos.IAspectos;

public class Terciario extends Estudios {
    @Override
    public double versus(IAspectos a) {
        return ((Estudios)a).versusTerciario();
    }

    @Override
    public double versusPrimario() {
        return -2;
    }

    @Override
    public double versusSecundario() {
        return -1.5;
    }

    @Override
    public double versusTerciario( ) {
        return 1;
    }
    @Override
    public String toString() {
    	return " Estudios Terciarios";
    }

}
