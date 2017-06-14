package controller;

import javax.swing.JOptionPane;

import GUI.VentanaVehiculos;
import contenedores.ContenedorPrincipal;
import enums.TipoCombustible;
import enums.TipoVehiculo;
import globals.Constantes;
import models.Vehiculo;

public class ControladorVehiculos {

	private ControladorPrincipal controladorPrincipal;
	private VentanaVehiculos vehiculos;
	private boolean firstTime = true;

	public ControladorVehiculos(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		vehiculos = new VentanaVehiculos(this);
	}

	public void mostrarVehiculos() {
		vehiculos.mostrarVentana();
		if (!Constantes.MODO_CREAR) {
			firstTime = false;
		} else {
			firstTime = true;
		}
		cargarVehiculo();
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

	public void guardarVehiculo() {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().aniadirVehiculo(
				new Vehiculo(vehiculos.getTxt_matricula(), vehiculos.getTxt_marca(), vehiculos.getTxt_modelo(), 
						Integer.parseInt(vehiculos.getPuertas()), vehiculos.getFechaMatriculacion(), 
						Integer.parseInt(vehiculos.getTxt_potencia()) , vehiculos.getTipoCombustible(), vehiculos.getTipoVehiculo(),
						vehiculos.getTxt_N()));
		firstTime = true;
		cargarVehiculo();
	}

	public void pulsarLeftArrow() {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().disminuirIndex();
		cargarVehiculo();
	}

	public void pulsarRightArrow() {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().aumentarIndex();
		cargarVehiculo();
	}
	
	public void pulsarBorrarVehiculo() {
		if (!ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().borrarVehiculo(obtenerVehiculoActual())) {
			JOptionPane.showMessageDialog(null, "No se ha podido borrar el vehiculo actual", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			cargarVehiculo();
		}
	}
	
	private void cargarVehiculo() {
		if (firstTime) {
			vehiculos.setMarca("");
			vehiculos.setMatricula("");
			vehiculos.setModelo("");
			vehiculos.setPuertas("");
			vehiculos.setPotencia("");
			vehiculos.setTipoCombustible(TipoCombustible.Electrico);
			vehiculos.setTipoVehiculo(TipoVehiculo.Coche);
			firstTime = false;
			
		} else if (obtenerVehiculoActual() != null) {
				vehiculos.setMarca(obtenerVehiculoActual().getMarca());
				vehiculos.setMatricula(obtenerVehiculoActual().getMatricula());
				vehiculos.setModelo(obtenerVehiculoActual().getModelo());
				vehiculos.setPuertas(String.valueOf(obtenerVehiculoActual().getPuertas()));
				vehiculos.setPotencia(String.valueOf(obtenerVehiculoActual().getPotencia()));
				vehiculos.setTipoCombustible(obtenerVehiculoActual().getCombustible());
				vehiculos.setTipoVehiculo(obtenerVehiculoActual().getTipoVehiculo());
				
		}
		actualizarCantidadCoches();
	}

	private void actualizarCantidadCoches() {
		vehiculos.setCantidadVehiculos(ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().getIndex()
				+ "/" + ContenedorPrincipal.getContenedorPrincipal().getContenedorVehiculos().getSize());
	}
}
