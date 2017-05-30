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
	public Reparacion(int idReparacion, Calendar fechaInicio, Calendar fechaFin, String propietario, float presupuesto,
			EstadoReparacion estado, String comentarios) {
		this.idReparacion = idReparacion;
		this.fechaInicio = fechaInicio;	
		this.fechaFin = fechaFin;
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
