package controller;

import GUI.Cliente;
import GUI.Reparaciones;

public class ControladorReparaciones {
	
	private ControladorPrincipal controladorPrincipal;
	private Reparaciones reparaciones;
	
	public ControladorReparaciones(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		reparaciones = new Reparaciones(this);
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
