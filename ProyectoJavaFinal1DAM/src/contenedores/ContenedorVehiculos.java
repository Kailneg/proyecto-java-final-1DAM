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
		return obtenerVehiculo(index);
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
		if (!vehiculos.isEmpty()) {
			if (index > 0 && index < vehiculos.size()) {
				index++;
			}
		}
	}

	public void disminuirIndex() {
		if (!vehiculos.isEmpty()) {
			if (index > 0 && index < vehiculos.size()) {
				index--;
			}
		}
	}

	public int getIndex() {
		return index;
	}

	public int getSize() {
		return vehiculos.size();
	}
}
