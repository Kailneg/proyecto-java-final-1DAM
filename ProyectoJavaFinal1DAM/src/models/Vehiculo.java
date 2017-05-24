package models;

import enums.TipoCombustible;

public class Vehiculo {
	
	// VARIABLES
	private String matricula, marca, modelo;
	private int puertas, anioMatriculacion, cv;
	private TipoCombustible combustible;
	
	// CONSTRUCTOR
	public Vehiculo(String matricula, String marca, String modelo, int puertas, int anioMatriculacion, int cv,
			TipoCombustible combustible) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
		this.anioMatriculacion = anioMatriculacion;
		this.cv = cv;
		this.combustible = combustible;
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

	public int getCv() {
		return cv;
	}

	public TipoCombustible getCombustible() {
		return combustible;
	}

	public void setCombustible(TipoCombustible combustible) {
		this.combustible = combustible;
	}
	

	

}
