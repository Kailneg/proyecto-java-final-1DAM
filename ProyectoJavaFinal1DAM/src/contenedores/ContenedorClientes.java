package contenedores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioNoEncontrado;
import models.Cliente;
import models.Usuario;
import models.Vehiculo;

public class ContenedorClientes {

	// ATRIBUTOS
	private ArrayList<Cliente> clientes;
	private ConectorMongoDB mongodb;
	private int index;

	// CONSTRUCTOR
	/**
	 * Crea un objeto Contenedor cliente
	 */
	public ContenedorClientes() {
		mongodb = new ConectorMongoDB("Clientes", "dni");
		actualizarLista();
		index = 0;
	}

	/**
	 * Devuelve un cliente de la lista
	 * 
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
	 * 
	 * @param index
	 *            la posicion en la que se encuentra el cliente dentro de la
	 *            lista
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
	 * 
	 * @param v
	 *            el cliente que se quiere borrar
	 * @return true si lo borra o false si no lo consigue
	 */
	public boolean borrarCliente(String keyValue) {
		boolean retorno = mongodb.borrarUno(keyValue);
		if (retorno) {
			actualizarLista();
		}
		return retorno;
	}

	/**
	 * Obtienes el tamaño de la lista de clientes
	 * 
	 * @return tamaño de la lista
	 */
	public long cantidadClientes() {
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
	 * 
	 * @param cliente
	 *            el cliente que se quiere añadir
	 * @return true si lo consigue o false si no
	 */
	public boolean aniadirCliente(Cliente cliente) {
		boolean retorno = mongodb.insertarEnDB(cliente.guardar());
		actualizarLista();
		return retorno;
	}

	private void actualizarLista() {
		List<DBObject> mongolista = mongodb.recibirDBColeccion();
		Iterator<DBObject> iterador = mongolista.iterator();
		clientes = new ArrayList<>();

		while (iterador.hasNext()) {
			clientes.add(new Cliente(iterador.next()));
		}
		index = clientes.size()-1;
	}

	public String[] getNifs() {
		String[] s = new String[clientes.size()];
		for (int i = 0; i < s.length; i++)
			s[i] = clientes.get(i).getNIF();
		return s;
	}
}
