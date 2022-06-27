package models.Aspectos.TipoPuesto;

import models.Aspectos.IAspectos;

public class Senior extends TipoPuesto {

    @Override
    public double versus(IAspectos a) {
        return  ((TipoPuesto)a).versusSenior();
    }

    @Override
    public double versusJunior() {
        return -0.5;
    }

    @Override
    public double versusManagment() {
        return -0.5;
    }
    @Override
    public double porcentaje() {
    	return 0.9;
    }

    @Override
    public double versusSenior() {
        return 1;
    }
    @Override
    public String toString() {
    	return "Senior";
    }
}
