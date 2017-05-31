package controller;

import java.util.Calendar;

import javax.swing.JOptionPane;

import GUI.VentanaReparaciones;
import contenedores.ContenedorPrincipal;
import contenedores.ContenedorReparaciones;
import models.Reparacion;

public class ControladorReparaciones {
	
	private ControladorPrincipal controladorPrincipal;
	private ContenedorReparaciones contenedorReparaciones;
	private VentanaReparaciones reparaciones;
	
	public ControladorReparaciones(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.contenedorReparaciones = ContenedorPrincipal.getContenedorPrincipal().getcontenedorReparaciones();
		reparaciones = new VentanaReparaciones(this);
	}
	
	public void mostrarReparaciones(){
		reparaciones.mostrarVentana();
		cargarReparacion();
	}
	
	public void ocultarReparaciones(){
		reparaciones.ocultarVentana();
	}
	
	public Reparacion obtenerReparacionActual() {
		return contenedorReparaciones.obtenerReparacion();
	}
	
	public void pulsarCrear(){
		try {
			contenedorReparaciones.aniadirReparacion(
					new Reparacion(reparaciones.getID(), reparaciones.getPropietario(), 
							reparaciones.getPresupuesto(), reparaciones.getFechaInicio(), reparaciones.getFechaFin(), 
							reparaciones.getEstado(), reparaciones.getComentarios(), reparaciones.getCostePiezas()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se admiten campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void pulsarAtras(){
		reparaciones.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
	
	public void pulsarLeftArrow() {
		contenedorReparaciones.disminuirIndex();
		cargarReparacion();
	}

	public void pulsarRightArrow() {
		contenedorReparaciones.aumentarIndex();
		cargarReparacion();
	}
	
	private void cargarReparacion() {
		if (obtenerReparacionActual() != null) {
			reparaciones.setID(String.valueOf(contenedorReparaciones.obtenerReparacion().getIdReparacion()));
			reparaciones.setPropietario(contenedorReparaciones.obtenerReparacion().getPropietario());
			reparaciones.setFechaInicio(contenedorReparaciones.obtenerReparacion().getFechaInicioString());
			reparaciones.setFechaFin(contenedorReparaciones.obtenerReparacion().getFechaFinString());
			reparaciones.setPresupuesto(String.valueOf(contenedorReparaciones.obtenerReparacion().getPresupuesto()));
			reparaciones.setComentarios(contenedorReparaciones.obtenerReparacion().getComentarios());
			reparaciones.setEstado(contenedorReparaciones.obtenerReparacion().getEstado());
			reparaciones.setCostePiezas(String.valueOf(contenedorReparaciones.obtenerReparacion().getCostePiezas()));
			reparaciones.setPresupuesto(calcularPresupuesTotal());
		}
	}
	
	private String calcularPresupuesTotal() {
		Calendar aux = Calendar.getInstance();
		aux.setTimeInMillis(reparaciones.getFechaFin().getTimeInMillis() - reparaciones.getFechaInicio().getTimeInMillis());
		reparaciones.setTiempoTotal(aux.get(Calendar.HOUR_OF_DAY) - 1 + ":" + aux.get(Calendar.MINUTE) + ":"
				+ aux.get(Calendar.SECOND));

		// Calculando total
		int total = 0;
		total += reparaciones.getCostePiezas();
		total += aux.getTimeInMillis() / 1000 / 60;

		return String.valueOf(total);
	}
}
