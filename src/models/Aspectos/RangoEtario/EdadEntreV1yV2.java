package models.Aspectos.RangoEtario;

import models.Aspectos.IAspectos;

public class EdadEntreV1yV2 extends RangoEtario {

    @Override
    public double versus(IAspectos a) {
        return ((RangoEtario)a).versusEdadEntreV1yV2();
    }

    @Override
    public double versusEdadMayorQue() {
        return -0.5;
    }

    @Override
    public double versusEdadMenorQue() {
        return -0.5;
    }

    @Override
    public double versusEdadEntreV1yV2() {
        return 1;
    }
    @Override
    public String toString() {
    	return "Edad entre 30 y 45";
    }

}
