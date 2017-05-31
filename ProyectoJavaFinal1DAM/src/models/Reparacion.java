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
	public int getIdReparacion() {
		return idReparacion;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	public String getPropietario(){
		return propietario;
	}
	
	public float getPresupuesto() {
		return presupuesto;
	}
	
	public EstadoReparacion getEstado() {
		return estado;
	}
	
	public String getComentarios() {
		return comentarios;
	}

	
	// SETTERS
	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setEstado(EstadoReparacion estado) {
		this.estado = estado;
	}

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
