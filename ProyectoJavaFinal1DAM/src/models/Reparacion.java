package models;

import java.util.Calendar;
import java.util.Date;

import enums.EstadoReparacion;

public class Reparacion {

	// VARIABLES
	private int idReparacion;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private float presupuesto;
	private String propietario;
	private EstadoReparacion estado;
	private String comentarios;

	// CONSTRUCTOR
	/**
	 * Crea un objeto Reparacion con todos sus atributos
	 * @param idReparacion El identificador de la reparacion
	 * @param propietario Es el dueño del vehiculo
	 * @param presupuesto Lo que se estima que va a costar la reparacion
	 * @param fechaInicio Es la fecha y hora de cuando se comienza a reparar el vehiculo
	 * @param fechaFin Es la fecha y hora de cuando se termina de reparar el vehiculo
	 * @param estado Es la situacion en la que se encuentra el vehiculo en cuanto a la reparacion
	 * @param comentarios Observaciones que pueda hacer el dueño o el propio mecanico sobre el coche
	 */
	public Reparacion(int idReparacion, String propietario, float presupuesto,
			Calendar fechaInicio, Calendar fechaFin, EstadoReparacion estado, String comentarios) {
		this.idReparacion = idReparacion;
		this.presupuesto = presupuesto;
		this.estado = estado;
		this.comentarios = comentarios;
	}

	// GETTERS
	/**
	 * Devuelve el atributo ID
	 * @return atributo id de reparacion
	 */
	public int getIdReparacion() {
		return idReparacion;
	}

	/**
	 * Devuelve el atributo Fecha inicio
	 * @return atributo fecha inicio de reparacion
	 */
	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Devuelve el atributo Fecha fin
	 * @return atributo fecha fin de reparacion
	 */
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Devuelve el atributo Propietario
	 * @return atributo propietario de reparacion
	 */
	public String getPropietario(){
		return propietario;
	}
	
	/**
	 * Devuelve el atributo Presupuesto
	 * @return atributo presupuesto de reparacion
	 */
	public float getPresupuesto() {
		return presupuesto;
	}
	
	/**
	 * Devuelve el atributo Estado
	 * @return atributo estado de reparacion
	 */
	public EstadoReparacion getEstado() {
		return estado;
	}
	 /**
	  * Devuelve el atributo comentarios
	  * @return atributo comentarios de reparacion
	  */
	public String getComentarios() {
		return comentarios;
	}

	
	// SETTERS
	/**
	 * Fija el atributo id de reparacion con el valor pasado por parametro
	 * @param idReparacion nuevo id que tendrá el atributo
	 */
	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	/**
	 * Fija el atributo fecha fin de reparacion con el valor pasado por parametro
	 * @param fechaFin nueva fecha final que tendrá el atributo
	 */
	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Fija el atributo presupuesto de reparacion con el valor pasado por parametro
	 * @param presupuesto nuevo presupuesto que tendrá el atributo
	 */
	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * Fija el atributo estado de reparacion con el valor pasado por parametro
	 * @param estado nuevo estado que tendrá el atributo
	 */
	public void setEstado(EstadoReparacion estado) {
		this.estado = estado;
	}

	/**
	 * Fija el atributo comentarios de reparacion con el valor pasado por parametro
	 * @param comentarios nuevo comentario que tendrá el atributo
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	
	//TOSTRING
	/**
	 * Imprime todos los atributos de reparacion
	 */
	@Override
	public String toString() {
		return "Reparacion [idReparacion=" + idReparacion + 
				", fechaInicio=" + fechaInicio.get(Calendar.DATE) +
				"/"+ (fechaInicio.get(Calendar.MONTH)+1) + "/" + fechaInicio.get(Calendar.YEAR)+
				", fechaFin=" + fechaFin.get(Calendar.DATE) +
				"/"+ (fechaFin.get(Calendar.MONTH)+1) + "/" + fechaFin.get(Calendar.YEAR)+
				 ", presupuesto=" + presupuesto + ", estado=" + estado + ", comentarios=" + comentarios + "]";
	}


}
