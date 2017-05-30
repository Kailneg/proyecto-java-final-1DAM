package models;

import java.util.Calendar;

import enums.TipoCombustible;
import enums.TipoVehiculo;

public class Vehiculo {

	// VARIABLES
	private String matricula, marca, modelo;
	private int puertas, cv;
	private Calendar fechaMatriculacion;
	private TipoCombustible combustible;
	private TipoVehiculo tipo;

	// CONSTRUCTOR
	public Vehiculo(String matricula, String marca, String modelo, int puertas, Calendar fechaMatriculacion, int cv,
			TipoCombustible combustible, TipoVehiculo tipo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
		this.fechaMatriculacion = fechaMatriculacion;
		this.cv = cv;
		this.combustible = combustible;
		this.tipo = tipo;
	}

	// Getters - Setters

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

	public int getDiaMatriculacion() {
		return fechaMatriculacion.get(Calendar.DAY_OF_MONTH);
	}

	public int getMesMatriculacion() {
		return fechaMatriculacion.get(Calendar.MONTH) + 1; // Es zero-based
	}

	public int getAnioMatriculacion() {
		return fechaMatriculacion.get(Calendar.YEAR);
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

	public void setFechaMatriculacion(Calendar fecha) {
		this.fechaMatriculacion = fecha;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas
				+ ", fechaMatriculacion=" + fechaMatriculacion.get(Calendar.DATE) + "/"
				+ (fechaMatriculacion.get(Calendar.MONTH) + 1) + "/" + fechaMatriculacion.get(Calendar.YEAR) + ", cv="
				+ cv + ", combustible=" + combustible + ", tipo=" + tipo + "]";
	}

}
