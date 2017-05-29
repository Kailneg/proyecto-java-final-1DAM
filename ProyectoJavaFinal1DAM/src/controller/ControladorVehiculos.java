package controller;

import javax.swing.JOptionPane;

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

	public void mostrarVehiculos() {
		vehiculos.mostrarVentana();
	}

	public void ocultarVehiculos() {
		vehiculos.ocultarVentana();
	}

	public void pulsarClientes() {
		vehiculos.ocultarVentana();
		controladorPrincipal.getControladorCliente().mostrarClientes();
	}

	public void pulsarReparaciones() {
		vehiculos.ocultarVentana();
		controladorPrincipal.getControladorReparaciones().mostrarReparaciones();
	}

	public void pulsarAtras() {
		vehiculos.ocultarVentana();
		controladorPrincipal.getControladorMenu().mostrarMenu();
	}

	public TipoCombustible convertidorTipoCombustible() {
		switch (vehiculos.tipoCombustibleIntToEnum().getSelectedIndex()) {
		case 0:
			return TipoCombustible.DIESEL;
		case 1:
			return TipoCombustible.ELECTRICO;
		case 2:
			return TipoCombustible.GASOLINA;
		case 3:
			return TipoCombustible.GLP;
		case 4:
			return TipoCombustible.HIBRIDO;
		default:
			return null;

		}
	}

	public void guardarVehiculo(String matricula, String marca, String modelo, int puertas, int anioMatriculacion,
			int cv) {
		try {
			ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().aniadirCliente(new Vehiculo(matricula,
					marca, modelo, puertas, anioMatriculacion, cv, convertidorTipoCombustible()));
			System.out.println(ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
