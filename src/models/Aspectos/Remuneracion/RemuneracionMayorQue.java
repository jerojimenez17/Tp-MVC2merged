package models.Aspectos.Remuneracion;

import models.Aspectos.IAspectos;

public class RemuneracionMayorQue extends Remuneracion {

    @Override
    public double versus(IAspectos a) {
        return ((Remuneracion)a).versusRemuneracionMayorQue();
    }

    @Override
    public double versusRemuneracionMayorQue() {
        return 1;
    }

    @Override
    public double versusRemuneracionMenorQue() {
        return -1;
    }

    @Override
    public double versusRemuneracionEntreV1yV2() {
        return -0.5;
    }
    @Override
    public String toString() {
    	return " Mayor a v2";
    }

}
