package models;

public class Comision  {
	private Person persona;
	private double comision;
	
	public Comision(Person persona,double comision) {
		this.persona=persona;
		this.comision=comision;
	}
	
	public double getComision() {
		return this.comision;
	}
	public Person getPersona() {
		return this.persona;
	}
}
