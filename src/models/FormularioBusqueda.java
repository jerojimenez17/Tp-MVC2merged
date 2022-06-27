package models;

import java.io.Serializable;

import models.Aspectos.IAspectos;

public class FormularioBusqueda implements Serializable{

	private IAspectos locacion;
	private IAspectos tipoPuesto;
	private IAspectos eleccionEdad;
	private IAspectos experiencia;
	private IAspectos estudios;
	private IAspectos remuneracion;
	private IAspectos cargaHoraria;

	public FormularioBusqueda(IAspectos decoratorLocacion, IAspectos decoratorTipoPuesto,
			IAspectos decoratorEleccionEdad,
			IAspectos decoratorExperiencia,
			IAspectos decoratorEstudios, IAspectos decoratorRemuneracion,
			IAspectos decoratorCargaHoraria) {

		this.locacion =  decoratorLocacion;
		this.tipoPuesto =  decoratorTipoPuesto;
		this.eleccionEdad = decoratorEleccionEdad;
		this.experiencia =  decoratorExperiencia;
		this.estudios =  decoratorEstudios;
		this.remuneracion = decoratorRemuneracion;
		this.cargaHoraria = decoratorCargaHoraria;
	}

	public IAspectos getLocacion() {
		return locacion;
	}

	public IAspectos getTipoPuesto() {
		return tipoPuesto;
	}


	public void setTipoPuesto(IAspectos tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}

	public IAspectos getEleccionEdad() {
		return eleccionEdad;
	}

	public void setEleccionEdad(IAspectos eleccionEdad) {
		this.eleccionEdad = eleccionEdad;
	}

	public IAspectos getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(IAspectos experiencia) {
		this.experiencia = experiencia;
	}

	public IAspectos getEstudios() {
		return estudios;
	}

	public void setEstudios(IAspectos estudios) {
		this.estudios = estudios;
	}

	public IAspectos getRemuneracion() {
		return remuneracion;
	}

	public void setRemuneracion(IAspectos remuneracion) {
		this.remuneracion = remuneracion;
	}

	public IAspectos getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(IAspectos cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "\nLocacion" + getLocacion() + "\nTipo de Trabajo" + getTipoPuesto() + "\nEstudios: " + getEstudios()
				+ "\nExperiencia: " + getExperiencia() + "\nEdad: " + getEleccionEdad() + "\nRemuneracion: "
				+ getRemuneracion() + "\nCarga Horaria: "
				+ getCargaHoraria();
	}

}
