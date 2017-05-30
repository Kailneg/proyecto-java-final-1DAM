package controller;

import javax.swing.JOptionPane;

import GUI.VentanaClientes;
import contenedores.ContenedorClientes;
import contenedores.ContenedorPrincipal;
import globals.Constantes;
import models.Cliente;
import models.Vehiculo;

public class ControladorCliente {

	private ControladorPrincipal controladorPrincipal;
	private ContenedorClientes contenedorClientes;
	private VentanaClientes clientes;

	public ControladorCliente(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.contenedorClientes = ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes();
		clientes = new VentanaClientes(this);
	}

	public void mostrarClientes() {
		clientes.mostrarVentana();
		if (!Constantes.MODO_CREAR) {
			cargarCliente();
		}
	}

	public Cliente obtenerClienteActual() {
		return ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().obtenerCliente();
	}

	public void ocultarClientes() {
		clientes.ocultarVentana();
	}
	
	public int getNumeroClientes() {
		return ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().cantidadClientes();
	}

	public Cliente guardarCliente() {
		try {
			contenedorClientes.aniadirCliente(new Cliente(clientes.getNIF(), clientes.getNombre(),
					clientes.getApellidos(), clientes.getDireccion(), clientes.getTelefono(), clientes.getEmail()));
			return obtenerClienteActual();
		} catch (Exception e) {
			return null;
		}
	}

	public void pulsarAtras() {
		clientes.ocultarVentana();
		controladorPrincipal.getControladorVehiculo().mostrarVehiculos();
	}

	public void pulsarLeftArrow() {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().disminuirIndex();
		cargarCliente();
	}

	public void pulsarRightArrow() {
		ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().aumentarIndex();
		cargarCliente();
	}

	public void pulsarBorrarCliente() {
		if (!ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes()
				.borrarCliente(obtenerClienteActual())) {
			JOptionPane.showMessageDialog(null, "No se ha podido borrar el cliente actual", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Borrado el cliente numero " + (getNumeroClientes() + 1), "rip",
					JOptionPane.INFORMATION_MESSAGE);
		}
		cargarCliente();
	}
	
	private void cargarCliente() {
		if (obtenerClienteActual() != null) {
			clientes.setNIF(obtenerClienteActual().getDni());
			clientes.setNombre(obtenerClienteActual().getNombre());
			clientes.setApellidos(obtenerClienteActual().getApellidos());
			clientes.setDireccion(obtenerClienteActual().getDireccion());
			clientes.setTelefono(String.valueOf(obtenerClienteActual().getTelefono()));
			clientes.setEmail(obtenerClienteActual().getEmail());
		} else {
			clientes.setNIF("");
			clientes.setNombre("");
			clientes.setApellidos("");
			clientes.setDireccion("");
			clientes.setTelefono("");
			clientes.setEmail("");
		}
	}
}
