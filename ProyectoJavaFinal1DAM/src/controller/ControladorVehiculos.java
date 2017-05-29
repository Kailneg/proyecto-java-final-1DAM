package controller;

import GUI.VentanaMenu;
import GUI.VentanaVehiculos;

public class ControladorVehiculos {
	
	private ControladorPrincipal controladorPrincipal;
	private VentanaVehiculos vehiculos;
	
	public ControladorVehiculos(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		vehiculos = new VentanaVehiculos(this);
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
