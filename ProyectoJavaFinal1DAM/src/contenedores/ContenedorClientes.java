package contenedores;

import java.util.ArrayList;
import java.util.List;

import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioNoEncontrado;
import models.Cliente;
import models.Usuario;

public class ContenedorClientes {
	
	private ArrayList<Cliente> clientes;
	
	public ContenedorClientes() {
		clientes = new ArrayList<Cliente>();
	}
	
	public List<Cliente> getCopiaClientes(){
		return clientes.subList(0, clientes.size());
	}
	
	public Cliente obtenCliente(String cliente) throws UsuarioNoEncontrado {
		for (Cliente u : clientes) {
			if (u.getNombre().equals(cliente))
				return u;
		}
		throw new ClienteNoEncontrado();
	}

	public boolean aniadirCliente(Cliente cliente) {
		return clientes.add(cliente);
	}

	public boolean eliminarCliente(Usuario cliente) {
		return clientes.remove(cliente);
	}
}
