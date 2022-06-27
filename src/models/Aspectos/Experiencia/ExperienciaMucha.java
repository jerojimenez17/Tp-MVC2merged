package models.Aspectos.Experiencia;

import models.Aspectos.IAspectos;

public class ExperienciaMucha extends Experiencia {

    @Override
    public double versus(IAspectos a) {
        return ((Experiencia)a).versusExperienciaMucha();
    }

    @Override
    public double versusExperienciaMucha() {
        return 1;
    }

    @Override
    public double versusExperienciaNada() {
        return -2;
    }

    @Override
    public double versusExperienciaMedia() {
        return -1.5;
    }
    @Override
    public String toString() {
    	return " Experiencia Mucha";
    }
}
