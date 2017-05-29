package controller;

import GUI.VentanaClientes;
import GUI.VentanaReparaciones;

public class ControladorReparaciones {
	
	private ControladorPrincipal controladorPrincipal;
	private VentanaReparaciones reparaciones;
	
	public ControladorReparaciones(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		reparaciones = new VentanaReparaciones(this);
	}
	
	public void mostrarReparaciones(){
		reparaciones.mostrarVentana();
	}
	
	public void ocultarReparaciones(){
		reparaciones.ocultarVentana();
	}
	
	public void pulsarCrear(){
		//TODO: hay que completar
	}
	
	public void pulsarAtras(){
		reparaciones.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
}
