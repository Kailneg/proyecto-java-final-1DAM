package controller;

import GUI.VentanaVehiculos;
import contenedores.ContenedorPrincipal;
import enums.TipoCombustible;
import models.Vehiculo;

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
	
	public void guardarVehiculo(String matricula, String marca, String modelo, int puertas, int anioMatriculacion, int cv,
			TipoCombustible combustible) {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().aniadirCliente(new Vehiculo(matricula, marca, modelo, puertas, anioMatriculacion, cv, combustible));
	}
}
