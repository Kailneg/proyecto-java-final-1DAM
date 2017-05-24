package controller;

import GUI.Menu;
import GUI.Vehiculos;

public class ControladorVehiculos {
	
	private ControladorPrincipal controladorPrincipal;
	private Vehiculos vehiculos;
	
	public ControladorVehiculos(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		vehiculos = new Vehiculos(this);
	}
	
	public void mostrarVehiculos(){
		vehiculos.mostrarVentana();
	}
	
	public void ocultarVehiculos(){
		vehiculos.ocultarVentana();
	}
	
	public void pulsarClientes(){
		vehiculos.ocultarVentana();
		controladorPrincipal.getControladorCliente().mostrarClientes();
	}
	
	public void pulsarReparaciones(){
		vehiculos.ocultarVentana();
		controladorPrincipal.getControladorReparaciones().mostrarReparaciones();
	}
	
	public void pulsarAtras(){
		vehiculos.ocultarVentana();
		controladorPrincipal.getControladorMenu().mostrarMenu();
	}
}
