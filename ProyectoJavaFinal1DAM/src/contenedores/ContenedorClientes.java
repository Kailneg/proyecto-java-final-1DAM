package contenedores;

import java.util.ArrayList;
import java.util.List;

import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioNoEncontrado;
import models.Cliente;
import models.Usuario;
import models.Vehiculo;

public class ContenedorClientes {
	
	private ArrayList<Cliente> clientes;
	private int index;
	
	public ContenedorClientes() {
		clientes = new ArrayList<Cliente>();
		
		// --- CLIENTES DE PRUEBA
		clientes.add(new Cliente("78932156L", "John", "Smith", "Calle La Triana, 23", 689137520, "johnsmith@hotmail.com"));
		clientes.add(new Cliente("78867832N", "Carlos", "Mendez", "Av. Carlos de Haya, 45", 69735812, "carlitos_elmejor@gmail.com"));
		// --- CLIENTES DE PRUEBA
		
		index = 0;
	}
	
	public List<Cliente> getCopiaClientes(){
		return clientes.subList(0, clientes.size());
	}
	
	public Cliente obtenCliente(String cliente) {
		for (Cliente u : clientes) {
			if (u.getNombre().equals(cliente))
				return u;
		}
		throw new ClienteNoEncontrado();
	}
	
	public Cliente obtenerCliente() {
		if (!clientes.isEmpty()) {
			return obtenerCliente(index);
		} else {
			return null;
		}
	}
	
	public Cliente obtenerCliente(int index) {
		if (clientes.get(index) != null) {
			return clientes.get(index);
		} else {
			return null;
		}
	}
	
	public boolean borrarCliente(Cliente v) {
		return clientes.remove(v);
	}
	
	public int cantidadClientes() {
		return clientes.size();
	}
	
	public void aumentarIndex() {
		if (index < clientes.size() - 1 && !clientes.isEmpty())
			index++;
	}

	public void disminuirIndex() {
		if (index > 0 && !clientes.isEmpty()) {
			index--;
		}
	}

	public boolean aniadirCliente(Cliente cliente) {
		return clientes.add(cliente);
	}

	public boolean eliminarCliente(Usuario cliente) {
		return clientes.remove(cliente);
	}
	
	public int getIndex() {
		if (clientes.isEmpty())
			return index;
		else
			return index + 1;
	}

	public int getSize() {
		return clientes.size();
	}
}
