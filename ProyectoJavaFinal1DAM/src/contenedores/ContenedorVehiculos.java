package contenedores;

import java.util.ArrayList;

import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioNoEncontrado;
import exceptions.VehiculoNoEncontrado;
import models.Vehiculo;
import models.Usuario;

public class ContenedorVehiculos {

	private ArrayList<Vehiculo> vehiculos;
	private int index;

	public ContenedorVehiculos() {
		vehiculos = new ArrayList<Vehiculo>();
		index = 0;
	}

	public Vehiculo obtenerVehiculo() {
		if (!vehiculos.isEmpty())
			return obtenerVehiculo(index);
		else
			return null;
	}

	public Vehiculo obtenerVehiculo(int index) {
		if (vehiculos.get(index) != null) {
			return vehiculos.get(index);
		} else {
			throw new VehiculoNoEncontrado();
		}
	}

	public Vehiculo obtenVehiculo(String matricula) {
		for (Vehiculo v : vehiculos) {
			if (v.getMatricula().equals(matricula))
				return v;
		}
		throw new VehiculoNoEncontrado();
	}

	public boolean aniadirCliente(Vehiculo vehiculo) {
		return vehiculos.add(vehiculo);
	}

	public boolean eliminarCliente(Vehiculo vehiculo) {
		return vehiculos.remove(vehiculo);
	}

	public void aumentarIndex() {
		if (index < vehiculos.size() - 1 && !vehiculos.isEmpty())
			index++;
	}

	public void disminuirIndex() {
		if (index > 0 && !vehiculos.isEmpty()) {
			index--;
		}
	}

	public int getIndex() {
		if (vehiculos.isEmpty())
			return index;
		else
			return index + 1;
	}

	public int getSize() {
		return vehiculos.size();
	}
}
