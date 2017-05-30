package controller;

import java.util.Arrays;

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
				new Reparacion(reparaciones.getIdReparacion(), reparaciones.getFechaInicio(), 
						reparaciones.getFechaFin(), reparaciones.getPropietario(), 
						reparaciones.getPresupuesto(), reparaciones.getEstado(), reparaciones.getComentarios()));
		System.out.println(Arrays.toString(ContenedorPrincipal.getContenedorPrincipal()
				.getcontenedorReparaciones().getCopiaReparaciones().toArray()));
	}
	
	public void pulsarAtras(){
		reparaciones.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
	
	public void pulsarTest(){
		reparaciones.setModoEscritura(!reparaciones.getIsModoEscritura());
		reparaciones.cargarReparacion(contenedorReparaciones.obtenReparacion(5));
	}
}
