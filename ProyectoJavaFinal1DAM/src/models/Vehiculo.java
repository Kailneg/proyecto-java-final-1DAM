package models;

import enums.TipoCombustible;
import enums.TipoVehiculo;

public class Vehiculo {
	
	// VARIABLES
	private String matricula, marca, modelo;
	private int puertas, anioMatriculacion, cv;
	private TipoCombustible combustible;
	private TipoVehiculo tipo;
	
	// CONSTRUCTOR
	public Vehiculo(String matricula, String marca, String modelo, int puertas, int anioMatriculacion, int cv,
			TipoCombustible combustible, TipoVehiculo tipo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
		this.anioMatriculacion = anioMatriculacion;
		this.cv = cv;
		this.combustible = combustible;
		this.tipo = tipo;
	}
	
	//Getters - Setters

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getPuertas() {
		return puertas;
	}

	public int getAnioMatriculacion() {
		return anioMatriculacion;
	}

	public int getPotencia() {
		return cv;
	}

	public TipoCombustible getCombustible() {
		return combustible;
	}
	
	public TipoVehiculo getTipoVehiculo() {
		return tipo;
	}

	public void setCombustible(TipoCombustible combustible) {
		this.combustible = combustible;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas
				+ ", anioMatriculacion=" + anioMatriculacion + ", cv=" + cv + ", combustible=" + combustible + ", tipo=" + tipo + "]";
	}

}
