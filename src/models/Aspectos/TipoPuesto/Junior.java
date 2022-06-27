package models.Aspectos.TipoPuesto;

import models.Aspectos.IAspectos;

public class Junior extends TipoPuesto {

   
    public double versus(IAspectos a) {
        return ((TipoPuesto)a).versusJunior();
    }

    @Override
    public double versusJunior() {
        return 1;
    }
    @Override
    public double porcentaje() {
    	return 0.8;
    }

    @Override
    public double versusManagment() {
        return -1;
    }

    @Override
    public double versusSenior() {
        return -0.5;
    }

    @Override
    public String toString() {
    	return "Junior";
    }



}
