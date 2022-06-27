package models.Aspectos.Locacion;

import models.Aspectos.IAspectos;

public class LocacionPresencial extends Locacion {

    @Override
    public double versus(IAspectos a) {
        return ((Locacion)a).versusPresencial();
    }

    @Override
    public double versusHomeOffice() {
        return -1;
    }

    @Override
    public double versusPresencial() {
        return 1;
    }

    @Override
    public double versusIndistinto() {
        return -1;
    }
    @Override
    public String toString() {
    	return " Presencial";
    }
}
