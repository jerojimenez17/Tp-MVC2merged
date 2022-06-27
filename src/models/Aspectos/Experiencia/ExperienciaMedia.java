package models.Aspectos.Experiencia;

import models.Aspectos.IAspectos;

public class ExperienciaMedia extends Experiencia {

    @Override
    public double versus(IAspectos a) {
        return ((Experiencia)a).versusExperienciaMedia();
    }

    @Override
    public double versusExperienciaMucha() {
        return 1.5;
    }

    @Override
    public double versusExperienciaNada() {
        return -0.5;
    }

    @Override
    public double versusExperienciaMedia( ) {
        return 1;
    }
    @Override
    public String toString() {
    	return " Experiencia Media";
    }

}
