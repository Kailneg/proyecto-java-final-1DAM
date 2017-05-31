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
	/**
	 * Crea un objeto de tipo Vehiculo con todos los atributos posibles.
	 * @param matricula matricula del vehículo
	 * @param marca marca del vehículo
	 * @param modelo modelo del vehículo
	 * @param puertas numero de puertas
	 * @param fechaMatriculacion fecha de matriculación del vehículo
	 * @param cv potencia del vehículo en caballos
	 * @param combustible tipo del combustible del vehículo
	 * @param tipo tipo del vehículo
	 */
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

	// GETTERS
	/**
	 * Devuelve el atributo Matricula
	 * @return atributo matricula de la instancia
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * Devuelve el atributo Marca
	 * @return atributo marca de la instancia
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * Devuelve el atributo Modelo
	 * @return atributo modelo de la instancia
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * Devuelve el atributo Puertas
	 * @return atributo puertas de la instancia
	 */
	public int getPuertas() {
		return puertas;
	}
	/**
	 * Devuelve el atributo DiaMatriculacion
	 * @return atributo DiaMatriculacion de la instancia
	 */
	public int getDiaMatriculacion() {
		return fechaMatriculacion.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * Devuelve el atributo MesMatriculacion
	 * @return atributo MesMatriculacion de la instancia
	 */
	public int getMesMatriculacion() {
		return fechaMatriculacion.get(Calendar.MONTH) + 1; // Es zero-based
	}
	/**
	 * Devuelve el atributo AnioMatriculacion
	 * @return atributo AnioMatriculacion de la instancia
	 */
	public int getAnioMatriculacion() {
		return fechaMatriculacion.get(Calendar.YEAR);
	}
	/**
	 * Devuelve el atributo Potencia
	 * @return atributo cv de la instancia
	 */
	public int getPotencia() {
		return cv;
	}
	/**
	 * Devuelve el atributo Combustible
	 * @return atributo combustible de la instancia
	 */
	public TipoCombustible getCombustible() {
		return combustible;
	}
	/**
	 * Devuelve el atributo TipoVehiculo
	 * @return atributo tipo de la instancia
	 */
	public TipoVehiculo getTipoVehiculo() {
		return tipo;
	}
	
	// SETTERS

	/**
	 * Fija el atributo Combustible de la instancia al valor pasado por parámetros.
	 * @param combustible el nuevo valor que tendrá el atributo combustible.
	 */
	public void setCombustible(TipoCombustible combustible) {
		this.combustible = combustible;
	}
	/**
	 * Fija el atributo FechaMatriculacion de la instancia al valor pasado por parámetros.
	 * @param fecha el nuevo valor que tendrá el atributo fechaMatriculacion.
	 */
	public void setFechaMatriculacion(Calendar fecha) {
		this.fechaMatriculacion = fecha;
	}
	/***
	 * Imprime la matricula, marca, modelo, número de puertas y la fecha de matriculación
	 */
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas
				+ ", fechaMatriculacion=" + fechaMatriculacion.get(Calendar.DATE) + "/"
				+ (fechaMatriculacion.get(Calendar.MONTH) + 1) + "/" + fechaMatriculacion.get(Calendar.YEAR) + ", cv="
				+ cv + ", combustible=" + combustible + ", tipo=" + tipo + "]";
	}

}
