package controller;

import GUI.VentanaVehiculos;
import contenedores.ContenedorPrincipal;
import enums.TipoVehiculo;
import models.Vehiculo;

public class ControladorVehiculos {

	private ControladorPrincipal controladorPrincipal;
	private VentanaVehiculos vehiculos;

	public ControladorVehiculos(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		vehiculos = new VentanaVehiculos(this);
	}

	public void mostrarVehiculos() {
		vehiculos.mostrarVentana();// Mostrar ventana con enabled a false
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

	public Vehiculo obtenerVehiculoActual() {
		return ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().obtenerVehiculo();
	}

	public void setTipoVehiculo(TipoVehiculo t) {
		vehiculos.setTipoVehiculo(t);
	}

	public Vehiculo guardarVehiculo(String matricula, String marca, String modelo, String puertas,
			String anioMatriculacion, String cv) {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos()
				.aniadirCliente(new Vehiculo(matricula, marca, modelo, Integer.parseInt(puertas),
						Integer.parseInt(anioMatriculacion), Integer.parseInt(cv), vehiculos.getTipoCombustible(),
						vehiculos.getTipoVehiculo()));
		actualizarCantidadCoches();
		return obtenerVehiculoActual();
	}

	public Vehiculo pulsarLeftArrow() {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().disminuirIndex();
		actualizarCantidadCoches();
		return obtenerVehiculoActual();
	}

	public Vehiculo pulsarRightArrow() {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().aumentarIndex();
		actualizarCantidadCoches();
		return obtenerVehiculoActual();
	}

	private void actualizarCantidadCoches() {
		vehiculos.setCantidadVehiculos(ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().getIndex()
				+ "/" + ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().getSize());
	}
}
