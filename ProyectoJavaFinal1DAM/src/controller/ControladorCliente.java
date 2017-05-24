package controller;

import GUI.Cliente;
import GUI.Vehiculos;

public class ControladorCliente {
	
	private ControladorPrincipal controladorPrincipal;
	private Cliente clientes;
	
	public ControladorCliente(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		clientes = new Cliente(this);
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
