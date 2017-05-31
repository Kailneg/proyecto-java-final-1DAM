package contenedores;

import java.util.ArrayList;
import java.util.Calendar;
import enums.TipoCombustible;
import enums.TipoVehiculo;
import exceptions.VehiculoNoEncontrado;
import models.Vehiculo;

public class ContenedorVehiculos {

	//ATRIBUTOS
	private ArrayList<Vehiculo> vehiculos;
	private int index;

	public ContenedorVehiculos() {
		vehiculos = new ArrayList<Vehiculo>();
		
		// --- VEHICULOS DE PRUEBA
		vehiculos.add(new Vehiculo("7898MA", "Ferrari", "Enzo", 2, Calendar.getInstance(), 660, TipoCombustible.Gasolina, TipoVehiculo.Coche));
		vehiculos.add(new Vehiculo("6347GCP", "Mercedes", "Actros", 2, Calendar.getInstance(), 460, TipoCombustible.Gasolina, TipoVehiculo.Camion));
		// --- VEHICULOS DE PRUEBA
		
		index = 0;
	}

	/**
	 * Obtiene el primer veh�culo de la lista si no est� vac�a
	 * @return el vehiculo
	 */
	public Vehiculo obtenerVehiculo() {
		if (!vehiculos.isEmpty()) {
			return obtenerVehiculo(index);
		} else {
			return null;
		}
	}
	/**
	 * Obtiene el vehiculo de la lista
	 * @param index la posicion en la que se encuentra el vehiculo
	 * @return el vehiculo correspondiente a ese indice
	 */
	public Vehiculo obtenerVehiculo(int index) {
		if (vehiculos.get(index) != null) {
			return vehiculos.get(index);
		} else {
			return null;
		}
	}
	/**
	 * Obtiene el vehiculo segun la matricula
	 * @param matricula parametro de busqueda 
	 * @return el vehiculo 
	 */
	public Vehiculo obtenerVehiculo(String matricula) {
		for (Vehiculo v : vehiculos) {
			if (v.getMatricula().equals(matricula))
				return v;
		}
		throw new VehiculoNoEncontrado();
	}
	/**
	 * Borra el vehiculo que le pasemos por parametro
	 * @param v el vehiculo que deseamos borrar
	 * @return true si lo consigue o false si no
	 */
	public boolean borrarVehiculo(Vehiculo v) {
		return vehiculos.remove(v);
	}
	/**
	 * A�ade el vehiculo que le pasamos por parametros a la lista 
	 * @param vehiculo el vehiculo que queremos insertar
	 * @return true si lo consigue o false si no
	 */
	public boolean aniadirVehiculo(Vehiculo vehiculo) {
		return vehiculos.add(vehiculo);
	}

	/**
	 * Aumenta en 1 el indice de la lista
	 */
	public void aumentarIndex() {
		if (index < vehiculos.size() - 1 && !vehiculos.isEmpty())
			index++;
	}
	/**
	 * Disminuye en 1 el indice de la lista
	 */
	public void disminuirIndex() {
		if (index > 0 && !vehiculos.isEmpty()) {
			index--;
		}
	}

	/**
	 * Obtiene el primer indice de la lista
	 * @return 0 si est� vac�a o 1 si tiene contenido
	 */
	public int getIndex() {
		if (vehiculos.isEmpty())
			return index;
		else
			return index + 1;
	}
	/**
	 * Obtiene el tama�o
	 * @return
	 */
	public int getSize() {
		return vehiculos.size();
	}
}
