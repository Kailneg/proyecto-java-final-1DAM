package controller;

import java.util.Arrays;

import GUI.VentanaClientes;
import GUI.VentanaVehiculos;
import contenedores.ContenedorPrincipal;
import models.Cliente;

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
		ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().aniadirCliente(
				new Cliente(clientes.getNIF(), clientes.getNombre(), clientes.getApellidos(),
						clientes.getDireccion(), clientes.getTelefono(), clientes.getEmail()));
		System.out.println(Arrays.toString(ContenedorPrincipal.getContenedorPrincipal()
				.getContenedorClientes().getCopiaClientes().toArray()));
	}
	
	public void pulsarAtras(){
		clientes.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
}
