package controller;

import GUI.VentanaClientes;
import GUI.VentanaVehiculos;

public class ControladorCliente {
	
	private ControladorPrincipal controladorPrincipal;
	private VentanaClientes clientes;
	
	public ControladorCliente(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		clientes = new VentanaClientes(this);
	}
	
	public void mostrarClientes(){
		clientes.mostrarVentana();
	}
	
	public void ocultarClientes(){
		clientes.ocultarVentana();
	}
	
	public void pulsarCrear(){
		//TODO: hay que completar
	}
	
	public void pulsarAtras(){
		clientes.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
}
