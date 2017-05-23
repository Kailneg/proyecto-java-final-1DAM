package models;

import enums.GasType;

public class Vehicle {
	
	//Variables
	private String matricula, marca, modelo;
	private int puertas, anioMatriculacion, cv;
	private GasType combustible;
	
	//Constructor
	public Vehicle(String matricula, String marca, String modelo, int puertas, int anioMatriculacion, int cv,
			GasType combustible) {
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

	public GasType getCombustible() {
		return combustible;
	}

	public void setCombustible(GasType combustible) {
		this.combustible = combustible;
	}
	

	

}
