package models.Aspectos.Experiencia;

import models.Aspectos.IAspectos;

public class ExperienciaNada extends Experiencia {

    @Override
    public double versus(IAspectos a) {
        return ((Experiencia)a).versusExperienciaNada();
    }

    @Override
    public double versusExperienciaMucha() {
        return 2;
    }

    @Override
    public double versusExperienciaNada() {
        return 1;
    }

    @Override
    public double versusExperienciaMedia() {
        return 1.5;
    }
    @Override
    public String toString() {
    	return " Experiencia Nada";
    }
}
