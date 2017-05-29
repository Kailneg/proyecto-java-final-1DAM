package contenedores;

import java.util.ArrayList;

import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioNoEncontrado;
import models.Vehiculo;
import models.Usuario;

public class ContenedorVehiculos {
	
	private ArrayList<Vehiculo> vehiculos;
	
	public ContenedorVehiculos() {
		vehiculos = new ArrayList<Vehiculo>();
	}
	
	public Vehiculo obtenVehiculo(String matricula) throws UsuarioNoEncontrado {
		for (Vehiculo v : vehiculos) {
			if (v.getMatricula().equals(matricula))
				return v;
		}
		throw new ClienteNoEncontrado();
	}

	public boolean aniadirCliente(Vehiculo vehiculo) {
		return vehiculos.add(vehiculo);
	}

	public boolean eliminarCliente(Usuario vehiculo) {
		return vehiculos.remove(vehiculo);
	}
}
