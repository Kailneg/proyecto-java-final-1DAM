package controller;

import java.util.NoSuchElementException;

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
	private boolean firstTime = true;

	public ControladorCliente(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.contenedorClientes = ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes();
		clientes = new VentanaClientes(this);
	}

	public void mostrarClientes() {
		clientes.mostrarVentana();

		if (!Constantes.MODO_CREAR) {
			firstTime = false;
		} else {
			firstTime = true;
		}

		cargarCliente();
	}

	public Cliente obtenerClienteActual() {
		return ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().obtenerCliente();
	}

	public void ocultarClientes() {
		clientes.ocultarVentana();
	}

	public long getNumeroClientes() {
		return ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().cantidadClientes();
	}

	public Cliente guardarCliente() {
		boolean todoBien = true;
		todoBien = !clientes.getNIF().trim().isEmpty();
		todoBien = !clientes.getNombre().trim().isEmpty();
		if (!todoBien)
			throw new NoSuchElementException("Faltan campos obligatorios");
		
		clientes.getTelefono();

		if (contenedorClientes.aniadirCliente(new Cliente(clientes.getNIF(), clientes.getNombre(),
				clientes.getApellidos(), clientes.getDireccion(), clientes.getTelefono(), clientes.getEmail()))) {
			firstTime = true;
			cargarCliente();
			return obtenerClienteActual();
		}
		return obtenerClienteActual();
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
		if (!ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().borrarCliente(clientes.getNIF())) {
			JOptionPane.showMessageDialog(null, "No se ha podido borrar el cliente actual", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Borrado cliente", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);
		}
		cargarCliente();
	}

	private void cargarCliente() {
		if (firstTime) {
			clientes.setNIF("");
			clientes.setNombre("");
			clientes.setApellidos("");
			clientes.setDireccion("");
			clientes.setTelefono("");
			clientes.setEmail("");
			firstTime = false;
		} else if (obtenerClienteActual() != null) {
			clientes.setNIF(obtenerClienteActual().getDni());
			clientes.setNombre(obtenerClienteActual().getNombre());
			clientes.setApellidos(obtenerClienteActual().getApellidos());
			clientes.setDireccion(obtenerClienteActual().getDireccion());
			clientes.setTelefono(String.valueOf(obtenerClienteActual().getTelefono()));
			clientes.setEmail(obtenerClienteActual().getEmail());
		}
	}
}
