package contenedores;

import java.util.ArrayList;
import java.util.List;

import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioNoEncontrado;
import models.Cliente;
import models.Usuario;
import models.Vehiculo;

public class ContenedorClientes {
	
	//ATRIBUTOS
	private ArrayList<Cliente> clientes;
	private int index;
	
	//CONSTRUCTOR
	/**
	 * Crea un objeto Contenedor cliente
	 */
	public ContenedorClientes() {
		clientes = new ArrayList<Cliente>();
		
		// --- CLIENTES DE PRUEBA
		clientes.add(new Cliente("78932156L", "John", "Smith", "Calle La Triana, 23", 689137520, "johnsmith@hotmail.com"));
		clientes.add(new Cliente("78867832N", "Carlos", "Mendez", "Av. Carlos de Haya, 45", 69735812, "carlitos_elmejor@gmail.com"));
		// --- CLIENTES DE PRUEBA
		
		index = 0;
	}
	
	//GETTERS
	/**
	 * Devuelve una copia de todos los clientes de la lista
	 * @return una copia de la lista clientes
	 */
	public List<Cliente> getCopiaClientes(){
		return clientes.subList(0, clientes.size());
	}
	
	/**
	 * Devuelve un cliente de la lista
	 * @param cliente el cliente que deseas obtener
	 * @return el cliente deseado si está
	 */
	public Cliente obtenCliente(String cliente) {
		for (Cliente u : clientes) {
			if (u.getNombre().equals(cliente))
				return u;
		}
		throw new ClienteNoEncontrado();
	}
	
	/**
	 * Devuelve un cliente de la lista
	 * @return devuelve un cliente en funcion del indice
	 */
	public Cliente obtenerCliente() {
		if (!clientes.isEmpty()) {
			return obtenerCliente(index);
		} else {
			return null;
		}
	}
	
	/**
	 * Devuelve un cliente de la lista
	 * @param index la posicion en la que se encuentra el cliente dentro de la lista
	 * @return el cliente correspondiente a ese indice
	 */
	public Cliente obtenerCliente(int index) {
		if (clientes.get(index) != null) {
			return clientes.get(index);
		} else {
			return null;
		}
	}
	
	/**
	 * Borra un cliente de la lista
	 * @param v el cliente que se quiere borrar
	 * @return true si lo borra o false si no lo consigue
	 */
	public boolean borrarCliente(Cliente v) {
		return clientes.remove(v);
	}
	
	/**
	 * Obtienes el tamaño de la lista de clientes
	 * @return tamaño de la lista
	 */
	public int cantidadClientes() {
		return clientes.size();
	}
	
	/**
	 * Aumenta 1 el indice para recorer la lista clientes
	 */
	public void aumentarIndex() {
		if (index < clientes.size() - 1 && !clientes.isEmpty())
			index++;
	}

	/**
	 * Disminuye 1 el indice para recorer la lista clientes
	 */
	public void disminuirIndex() {
		if (index > 0 && !clientes.isEmpty()) {
			index--;
		}
	}

	/**
	 * Añade un cliente a la lista de clientes
	 * @param cliente el cliente que se quiere añadir
	 * @return true si lo consigue o false si no
	 */
	public boolean aniadirCliente(Cliente cliente) {
		return clientes.add(cliente);
	}
	
	/**
	 * Elimina un cliente de la lista clientes
	 * @param cliente el cliente que se quiere eliminar
	 * @return true si lo consigue o false si no
	 */
	public boolean eliminarCliente(Usuario cliente) {
		return clientes.remove(cliente);
	}
	
	/**
	 * Devuelve el indice de la primera posicion
	 * @return el primer indice
	 */
	public int getIndex() {
		if (clientes.isEmpty())
			return index;
		else
			return index + 1;
	}
	
	/**
	 * Obtiene el tamaño de la lista
	 * @return tamaño de la lista clientes
	 */
	public int getSize() {
		return clientes.size();
	}
}
