package models;

import java.util.Date;

public class Reparacion {

	// VARIABLES
	private int idReparacion;
	private Date fechaInicio;
	private Date fechaFin;
	private float presupuesto;
	private String estado;
	private String comentarios;

	// CONSTRUCTOR
	public Reparacion(int idReparacion, Date fechaInicio, Date fechaFin, float presupuesto, String estado,
			String comentarios) {
		this.idReparacion = idReparacion;
		this.fechaInicio = new Date();	
		this.fechaFin = fechaFin;
		this.presupuesto = presupuesto;
		this.estado = estado;
		this.comentarios = comentarios;
	}

	// GETTERS
	public int getIdReparacion() {
		return idReparacion;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	
	public float getPresupuesto() {
		return presupuesto;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getComentarios() {
		return comentarios;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	// SETTERS
	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Reparacion [idReparacion=" + idReparacion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", presupuesto=" + presupuesto + ", estado=" + estado + ", comentarios=" + comentarios + "]";
	}


}
