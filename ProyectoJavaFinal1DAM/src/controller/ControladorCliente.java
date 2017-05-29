package controller;

import java.util.Arrays;

import GUI.VentanaClientes;
import GUI.VentanaVehiculos;
import contenedores.ContenedorClientes;
import contenedores.ContenedorPrincipal;
import models.Cliente;

public class ControladorCliente {
	
	private ControladorPrincipal controladorPrincipal;
	private ContenedorClientes contenedorClientes;
	private VentanaClientes clientes;
	
	public ControladorCliente(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.contenedorClientes = ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes();
		clientes = new VentanaClientes(this);
	}
	
	public void mostrarClientes(){
		clientes.mostrarVentana();
	}
	
	public void ocultarClientes(){
		clientes.ocultarVentana();
	}
	
	public void pulsarCrear(){
		contenedorClientes.aniadirCliente(new Cliente(clientes.getNIF(), clientes.getNombre(), 
				clientes.getApellidos(), clientes.getDireccion(), clientes.getTelefono(), 
				clientes.getEmail()));
		System.out.println(Arrays.toString(ContenedorPrincipal.getContenedorPrincipal()
				.getContenedorClientes().getCopiaClientes().toArray()));
	}
	
	public void pulsarAtras(){
		clientes.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
}
