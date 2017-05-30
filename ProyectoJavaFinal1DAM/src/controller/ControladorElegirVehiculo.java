package controller;

import javax.swing.JOptionPane;

import GUI.VentanaEleccionVehiculo;
import GUI.VentanaLogin;
import contenedores.ContenedorPrincipal;
import contenedores.ContenedorUsuarios;
import enums.TipoCombustible;
import enums.TipoVehiculo;
import exceptions.ContraseniaNoEncontrada;
import exceptions.UsuarioNoEncontrado;

public class ControladorElegirVehiculo {

	private ContenedorUsuarios usuarios;
	private ControladorPrincipal controladorPrincipal;
	private VentanaEleccionVehiculo eleccionVehiculo;

	public ControladorElegirVehiculo(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.usuarios = ContenedorPrincipal.getContenedorPrincipal().getContenedorUsuarios();
		this.eleccionVehiculo = new VentanaEleccionVehiculo(this);
	}

	public void mostrarElegir() {
		eleccionVehiculo.mostrarVentana();
	}

	public void ocultarElegir() {
		eleccionVehiculo.ocultarVentana();
	}

	public void pulsarCoche() {
		eleccionVehiculo.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().setTipoVehiculo(TipoVehiculo.Coche);
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}

	public void pulsarMoto() {
		eleccionVehiculo.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().setTipoVehiculo(TipoVehiculo.Moto);
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}

	public void pulsarCamion() {
		eleccionVehiculo.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().setTipoVehiculo(TipoVehiculo.Camion);
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}

	public void pulsarBici() {
		eleccionVehiculo.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().setTipoVehiculo(TipoVehiculo.Bicicleta);
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}
}
