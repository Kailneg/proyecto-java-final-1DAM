package contenedores;

import java.util.ArrayList;

import exceptions.ClienteNoEncontrado;
import exceptions.ContraseniaNoEncontrada;
import exceptions.UsuarioNoEncontrado;
import models.Clientes;
import models.Usuario;

public class ContenedorClientes {
	
	private ArrayList<Clientes> clientes;
	
	public ContenedorClientes() {
		clientes = new ArrayList<Clientes>();
	}
	
	public Clientes obtenCliente(String cliente) throws UsuarioNoEncontrado {
		for (Clientes u : clientes) {
			if (u.getNombre().equals(cliente))
				return u;
		}
		throw new UsuarioNoEncontrado();
	}

	public boolean aniadirCliente(Clientes cliente) {
		return clientes.add(cliente);
	}

	public boolean eliminarCliente(Usuario cliente) {
		return clientes.remove(cliente);
	}
}
