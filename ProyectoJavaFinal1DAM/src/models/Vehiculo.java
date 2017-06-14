package models;

import java.util.Calendar;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import enums.TipoCombustible;
import enums.TipoVehiculo;
import interfaces.Guardable;

public class Vehiculo implements Guardable {

	// VARIABLES
	private String matricula, marca, modelo;
	private long puertas, cv;
	private Calendar fechaMatriculacion;
	private TipoCombustible combustible;
	private TipoVehiculo tipo;

	// CONSTRUCTOR
	/**
	 * Crea un objeto de tipo Vehiculo con todos los atributos posibles.
	 * 
	 * @param matricula
	 *            matricula del vehículo
	 * @param marca
	 *            marca del vehículo
	 * @param modelo
	 *            modelo del vehículo
	 * @param puertas
	 *            numero de puertas
	 * @param fechaMatriculacion
	 *            fecha de matriculación del vehículo
	 * @param cv
	 *            potencia del vehículo en caballos
	 * @param combustible
	 *            tipo del combustible del vehículo
	 * @param tipo
	 *            tipo del vehículo
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

	public Vehiculo(DBObject dbObject) {
		this.matricula = (String) dbObject.get("matricula");
		this.marca = (String) dbObject.get("marca");
		this.modelo = (String) dbObject.get("modelo");
		this.puertas = (long) dbObject.get("long");
		this.fechaMatriculacion = parsearFecha((String) dbObject.get("fecha"));
		this.cv = (long) dbObject.get("cv");
		this.combustible = parsearCombustible((String) dbObject.get("combustible"));
		this.tipo = parsearVehiculo((String) dbObject.get("tipo"));
	}

	// GETTERS
	/**
	 * Devuelve el atributo Matricula
	 * 
	 * @return atributo matricula de la instancia
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Devuelve el atributo Marca
	 * 
	 * @return atributo marca de la instancia
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Devuelve el atributo Modelo
	 * 
	 * @return atributo modelo de la instancia
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Devuelve el atributo Puertas
	 * 
	 * @return atributo puertas de la instancia
	 */
	public long getPuertas() {
		return puertas;
	}

	/**
	 * Devuelve el atributo DiaMatriculacion
	 * 
	 * @return atributo DiaMatriculacion de la instancia
	 */
	public int getDiaMatriculacion() {
		return fechaMatriculacion.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Devuelve el atributo MesMatriculacion
	 * 
	 * @return atributo MesMatriculacion de la instancia
	 */
	public int getMesMatriculacion() {
		return fechaMatriculacion.get(Calendar.MONTH) + 1; // Es zero-based
	}

	/**
	 * Devuelve el atributo AnioMatriculacion
	 * 
	 * @return atributo AnioMatriculacion de la instancia
	 */
	public int getAnioMatriculacion() {
		return fechaMatriculacion.get(Calendar.YEAR);
	}
	
	public String getFechaMatriculacion() {
		return getDiaMatriculacion() + "-" + getMesMatriculacion()
		+ "-" + getAnioMatriculacion();
	}

	/**
	 * Devuelve el atributo Potencia
	 * 
	 * @return atributo cv de la instancia
	 */
	public long getPotencia() {
		return cv;
	}

	/**
	 * Devuelve el atributo Combustible
	 * 
	 * @return atributo combustible de la instancia
	 */
	public TipoCombustible getCombustible() {
		return combustible;
	}

	/**
	 * Devuelve el atributo TipoVehiculo
	 * 
	 * @return atributo tipo de la instancia
	 */
	public TipoVehiculo getTipoVehiculo() {
		return tipo;
	}

	// SETTERS

	/**
	 * Fija el atributo Combustible de la instancia al valor pasado por
	 * parámetros.
	 * 
	 * @param combustible
	 *            el nuevo valor que tendrá el atributo combustible.
	 */
	public void setCombustible(TipoCombustible combustible) {
		this.combustible = combustible;
	}

	/**
	 * Fija el atributo FechaMatriculacion de la instancia al valor pasado por
	 * parámetros.
	 * 
	 * @param fecha
	 *            el nuevo valor que tendrá el atributo fechaMatriculacion.
	 */
	public void setFechaMatriculacion(Calendar fecha) {
		this.fechaMatriculacion = fecha;
	}

	/***
	 * Imprime la matricula, marca, modelo, número de puertas y la fecha de
	 * matriculación
	 */
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas
				+ ", fechaMatriculacion=" + fechaMatriculacion.get(Calendar.DATE) + "/"
				+ (fechaMatriculacion.get(Calendar.MONTH) + 1) + "/" + fechaMatriculacion.get(Calendar.YEAR) + ", cv="
				+ cv + ", combustible=" + combustible + ", tipo=" + tipo + "]";
	}

	private Calendar parsearFecha(String s) {
		Calendar c = Calendar.getInstance();
		// Formato dd-mm-yyy
		// Dia
		c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(s.substring(0, 2)));
		// Mes
		c.set(Calendar.MONTH, Integer.parseInt(s.substring(3, 5)));
		// Anio
		c.set(Calendar.YEAR, Integer.parseInt(s.substring(6, 10)));
		return c;
	}

	private TipoCombustible parsearCombustible(String s) {
		return TipoCombustible.valueOf(s);
	}

	private TipoVehiculo parsearVehiculo(String s) {
		return TipoVehiculo.valueOf(s);
	}

	@Override
	public DBObject guardar() {
		BasicDBObject registro = new BasicDBObject("matricula", this.getMatricula());
		registro.append("marca", this.getMarca());
		registro.append("modelo", this.getModelo());
		registro.append("puertas", this.getPuertas());
		registro.append("fecha", this.getFechaMatriculacion());
		registro.append("cv", this.getPotencia());
		registro.append("combustible", this.getCombustible().name());
		registro.append("tipo", this.getTipoVehiculo().name());
		return registro;
	}

}
