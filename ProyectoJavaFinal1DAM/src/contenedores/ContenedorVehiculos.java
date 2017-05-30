package contenedores;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import enums.TipoCombustible;
import enums.TipoVehiculo;
import exceptions.VehiculoNoEncontrado;
import models.Vehiculo;

public class ContenedorVehiculos {

	private ArrayList<Vehiculo> vehiculos;
	private int index;

	public ContenedorVehiculos() {
		vehiculos = new ArrayList<Vehiculo>();
		
		// --- VEHICULOS DE PRUEBA
		vehiculos.add(new Vehiculo("7898MA", "Ferrari", "Enzo", 2, 2004, 660, TipoCombustible.Gasolina, TipoVehiculo.Coche));
		vehiculos.add(new Vehiculo("6347GCP", "Mercedes", "Actros", 2, 2010, 460, TipoCombustible.Gasolina, TipoVehiculo.Camion));
		// --- VEHICULOS DE PRUEBA
		
		index = 0;
	}

	public Vehiculo obtenerVehiculo() {
		if (!vehiculos.isEmpty()) {
			return obtenerVehiculo(index);
		} else {
			return null;
		}
	}

	public Vehiculo obtenerVehiculo(int index) {
		if (vehiculos.get(index) != null) {
			return vehiculos.get(index);
		} else {
			return null;
		}
	}

	public Vehiculo obtenerVehiculo(String matricula) {
		for (Vehiculo v : vehiculos) {
			if (v.getMatricula().equals(matricula))
				return v;
		}
		throw new VehiculoNoEncontrado();
	}

	public boolean borrarVehiculo(Vehiculo v) {
		return vehiculos.remove(v);
	}

	public boolean aniadirVehiculo(Vehiculo vehiculo) {
		return vehiculos.add(vehiculo);
	}

	public boolean eliminarVehiculo(Vehiculo vehiculo) {
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
