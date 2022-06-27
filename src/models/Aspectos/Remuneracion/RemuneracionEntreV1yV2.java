package models.Aspectos.Remuneracion;

import models.Aspectos.IAspectos;

public class RemuneracionEntreV1yV2 extends Remuneracion {

    @Override
    public double versus(IAspectos a) {
        return ((Remuneracion)a).versusRemuneracionEntreV1yV2();
    }

    @Override
    public double versusRemuneracionEntreV1yV2() {
        return 1;
    }

    @Override
    public double versusRemuneracionMenorQue() {
        return 1;
    }

    @Override
    public double versusRemuneracionMayorQue() {
        return -0.5;
    }
    @Override
    public String toString() {
    	return " Entre v1 y v2";  //Utilizar constantes
    }
}
