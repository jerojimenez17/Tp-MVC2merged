package models.Aspectos;

import java.io.Serializable;

public abstract class DecoratorAspecto implements IAspectos {

	protected IAspectos encapsulado;

	public DecoratorAspecto(IAspectos encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.encapsulado.toString();
	}

}
