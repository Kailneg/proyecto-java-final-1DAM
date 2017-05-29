package models;

import java.util.Calendar;
import java.util.Date;

public class Reparacion {

	// VARIABLES
	private int idReparacion;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private float presupuesto;
	private String estado;
	private String comentarios;

	// CONSTRUCTOR
	public Reparacion(int idReparacion, Calendar fechaInicio, Calendar fechaFin, float presupuesto, String estado,
			String comentarios) {
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
	
	public float getPresupuesto() {
		return presupuesto;
	}
	
	public String getEstado() {
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

	public void setEstado(String estado) {
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
