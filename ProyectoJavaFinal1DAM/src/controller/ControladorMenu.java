package controller;

import GUI.VentanaMenu;

public class ControladorMenu {
	
	private ControladorPrincipal controladorPrincipal;
	private VentanaMenu menu;
	
	public ControladorMenu(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		menu = new VentanaMenu(this);
	}
	
	public void mostrarMenu(){
		menu.mostrarVentana();
	}
	
	public void ocultarMenu(){
		menu.ocultarVentana();
	}
	
	public void pulsarBuscar(){
		menu.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
	
	public void pulsarNuevo(){
		menu.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos(/*modoLectura*/false);
	}
}
