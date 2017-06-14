package contenedores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.mongodb.DBObject;

import enums.TipoCombustible;
import enums.TipoVehiculo;
import exceptions.VehiculoNoEncontrado;
import models.Cliente;
import models.Vehiculo;

public class ContenedorVehiculos {

	//ATRIBUTOS
	private ArrayList<Vehiculo> vehiculos;
	private ConectorMongoDB mongodb;
	private int index;

	public ContenedorVehiculos() {
		vehiculos = new ArrayList<Vehiculo>();
		mongodb = new ConectorMongoDB("Vehiculos", "matricula");
		actualizarLista();
		index = 0;
	}

	/**
	 * Obtiene el primer vehículo de la lista si no está vacía
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
	 * Borra el vehiculo que le pasemos por parametro
	 * @param v el vehiculo que deseamos borrar
	 * @return true si lo consigue o false si no
	 */
	public boolean borrarVehiculo(Vehiculo v) {
		return vehiculos.remove(v);
	}
	/**
	 * Añade el vehiculo que le pasamos por parametros a la lista 
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
	 * @return 0 si está vacía o 1 si tiene contenido
	 */
	public int getIndex() {
		if (vehiculos.isEmpty())
			return index;
		else
			return index + 1;
	}
	/**
	 * Obtiene el tamaño
	 * @return
	 */
	public int getSize() {
		return vehiculos.size();
	}
	
	private void actualizarLista() {
		List<DBObject> mongolista = mongodb.recibirDBColeccion();
		Iterator<DBObject> iterador = mongolista.iterator();
		vehiculos = new ArrayList<>();

		while (iterador.hasNext()) {
			vehiculos.add(new Vehiculo(iterador.next()));
		}
		index = vehiculos.size()-1;
	}
}
