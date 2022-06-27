package models.Aspectos;

public class DecoratorAspectoPeso extends DecoratorAspecto {
    private double peso;

    public DecoratorAspectoPeso(IAspectos encapsulado, double peso) {
        super(encapsulado);
        this.peso = peso;
    }

    @Override
    public double versus(IAspectos aspectoAComparar) {
        double valorComparacion = this.encapsulado.versus(aspectoAComparar);
        return peso * valorComparacion;
    }
}
