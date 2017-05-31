package controller;

import java.util.Calendar;

import javax.swing.JOptionPane;

import GUI.VentanaReparaciones;
import contenedores.ContenedorPrincipal;
import contenedores.ContenedorReparaciones;
import enums.EstadoReparacion;
import globals.Constantes;
import models.Reparacion;

public class ControladorReparaciones {
	
	private ControladorPrincipal controladorPrincipal;
	private ContenedorReparaciones contenedorReparaciones;
	private VentanaReparaciones reparaciones;
	private boolean firstTime = true;
	
	public ControladorReparaciones(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.contenedorReparaciones = ContenedorPrincipal.getContenedorPrincipal().getcontenedorReparaciones();
		reparaciones = new VentanaReparaciones(this);
	}
	
	public void mostrarReparaciones(){
		reparaciones.mostrarVentana();
		if (!Constantes.MODO_CREAR) {
			firstTime = false;
		} else {
			firstTime = true;
		}
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
					new Reparacion(reparaciones.getID(), reparaciones.getPropietario(), reparaciones.getMecanico(), 
							reparaciones.getPresupuesto(), reparaciones.getFechaInicio(), reparaciones.getFechaFin(), 
							reparaciones.getEstado(), reparaciones.getComentarios(), reparaciones.getCostePiezas(), reparaciones.getTotal()));
			firstTime = true;
			cargarReparacion();
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
		if (firstTime) {
			reparaciones.setID("");
			reparaciones.setPropietario("");
			reparaciones.setFechaInicio("");
			reparaciones.setFechaFin("");
			reparaciones.setMecanico("");
			reparaciones.setPresupuesto("");
			reparaciones.setComentarios("");
			reparaciones.setEstado(EstadoReparacion.Pediente);
			reparaciones.setTotal("");
			reparaciones.setCostePiezas("");
			reparaciones.setPresupuesto("");
			firstTime = false;
			
		} else if (obtenerReparacionActual() != null) {
			reparaciones.setID(String.valueOf(contenedorReparaciones.obtenerReparacion().getIdReparacion()));
			reparaciones.setPropietario(contenedorReparaciones.obtenerReparacion().getPropietario());
			reparaciones.setFechaInicio(contenedorReparaciones.obtenerReparacion().getFechaInicioString());
			reparaciones.setFechaFin(contenedorReparaciones.obtenerReparacion().getFechaFinString());
			reparaciones.setPresupuesto(String.valueOf(contenedorReparaciones.obtenerReparacion().getPresupuesto()));
			reparaciones.setMecanico(contenedorReparaciones.obtenerReparacion().getMecanico());
			reparaciones.setComentarios(contenedorReparaciones.obtenerReparacion().getComentarios());
			reparaciones.setEstado(contenedorReparaciones.obtenerReparacion().getEstado());
			reparaciones.setTotal(String.valueOf(contenedorReparaciones.obtenerReparacion().getTotal()));
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
