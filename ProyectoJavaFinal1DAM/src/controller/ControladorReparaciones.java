package controller;

import java.util.Arrays;
import java.util.Date;

import GUI.VentanaClientes;
import GUI.VentanaReparaciones;
import contenedores.ContenedorPrincipal;
import contenedores.ContenedorReparaciones;
import models.Cliente;
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
	}
	
	public void ocultarReparaciones(){
		reparaciones.ocultarVentana();
	}
	
	public void pulsarCrear(){
		contenedorReparaciones.aniadirReparacion(
				new Reparacion(reparaciones.getIdReparacion(), reparaciones.getPropietario(), 
						reparaciones.getPresupuesto(), reparaciones.getFechaInicio(), reparaciones.getFechaFin(), 
						reparaciones.getEstado(), reparaciones.getComentarios()));
		System.out.println(Arrays.toString(ContenedorPrincipal.getContenedorPrincipal()
				.getcontenedorReparaciones().getCopiaReparaciones().toArray()));
	}
	
	public void pulsarAtras(){
		reparaciones.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
}
