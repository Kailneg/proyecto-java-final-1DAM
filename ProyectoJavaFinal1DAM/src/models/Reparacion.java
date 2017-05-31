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
	private float costePiezas;

	// CONSTRUCTOR
	public Reparacion(int idReparacion, String propietario, float presupuesto,
			Calendar fechaInicio, Calendar fechaFin, EstadoReparacion estado, String comentarios, float costePiezas) {
		this.idReparacion = idReparacion;
		this.presupuesto = presupuesto;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.comentarios = comentarios;
		this.costePiezas = costePiezas;
	}

	// GETTERS
	public int getIdReparacion() {
		return idReparacion;
	}
	public float getCostePiezas() {
		return costePiezas;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	
	public String getFechaInicioString() {
		return fechaInicio.get(Calendar.HOUR_OF_DAY) + ":"
				+ fechaInicio.get(Calendar.MINUTE) + ":" + fechaInicio.get(Calendar.SECOND);
	}
	
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	public String getFechaFinString() {
		return fechaFin.get(Calendar.HOUR_OF_DAY) + ":"
				+ fechaFin.get(Calendar.MINUTE) + ":" + fechaFin.get(Calendar.SECOND);
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
	
	public void setCostePiezas(float c) {
		this.costePiezas = c;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
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
