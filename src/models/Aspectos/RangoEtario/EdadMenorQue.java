package models.Aspectos.RangoEtario;

import models.Aspectos.IAspectos;

public class EdadMenorQue extends RangoEtario {

    @Override
    public double versus(IAspectos a) {
        return ((RangoEtario)a).versusEdadMenorQue();
    }

    @Override
    public double versusEdadMayorQue() {
        return -1;
    }

    @Override
    public double versusEdadMenorQue() {
        return 1;
    }

    @Override
    public double versusEdadEntreV1yV2() {
        return -0.5;
    }
    @Override
    public String toString() {
    	return " Menor a 30";
    }
}
