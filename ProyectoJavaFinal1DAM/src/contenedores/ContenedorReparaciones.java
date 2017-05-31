package contenedores;

import java.util.ArrayList;
import java.util.List;

import exceptions.ReparacionNoEncontrada;
import models.Reparacion;

public class ContenedorReparaciones {
	
	//ATRIBUTOS
	private ArrayList<Reparacion> reparaciones;
	private int index;
	
	//CONSTRUCTOR
	/**
	 * Crea un objeto contenedorReparaciones
	 */
	public ContenedorReparaciones() {
		reparaciones = new ArrayList<Reparacion>();
		index = 0;
	}
	
	//GETTERS
	/**
	 * Devuelve una copia de la lista de Reparaciones
	 * @return copia listaReparaciones
	 */
	public List<Reparacion> getCopiaReparaciones(){
		return reparaciones.subList(0, reparaciones.size());
	}
	/**
	 * Devuelve un parte de reparacion en concreto
	 * @param idReparacion el identificador de cada parte de reparacion
	 * @return la reparacion solicitada
	 */
	public Reparacion obtenReparacion(int idReparacion) {
		for (Reparacion r : reparaciones) {
			if (r.getIdReparacion() == idReparacion)
				return r;
		}
		throw new ReparacionNoEncontrada();
	}
	/**
	 * Añade un parte de reparacion a la lista de reparaciones
	 * @param reparacion el parte que se desea añadir
	 * @return true si lo consigue o false si no
	 */
	public boolean aniadirReparacion(Reparacion reparacion) {
		return reparaciones.add(reparacion);
	}
	/**
	 * Borra una reparacion de la lista de reparaciones
	 * @param reparacion el parte de reparacion que se desea añadir
	 * @return true si lo consigue o false si no
	 */
	public boolean borrarReparacion(Reparacion reparacion) {
		return reparaciones.remove(reparacion);
	}
	/**
	 * Obtener un indice de reparacion de la lista
	 * @return el indice del parte
	 */
	public Reparacion obtenerReparacion() {
		if (!reparaciones.isEmpty()) {
			return obtenerReparacion(index);
		} else {
			return null;
		}
	}
	/**
	 * Obtiene el parte de reparacion
	 * @param index la posicion del parte en la lista
	 * @return el parte
	 */
	public Reparacion obtenerReparacion(int index) {
		if (reparaciones.get(index) != null) {
			return reparaciones.get(index);
		} else {
			return null;
		}
	}
	/**
	 * Aumenta en 1 el indice
	 */
	public void aumentarIndex() {
		if (index < reparaciones.size() - 1 && !reparaciones.isEmpty())
			index++;
	}
	/**
	 * Disminuye en 1 el indice
	 */
	public void disminuirIndex() {
		if (index > 0 && !reparaciones.isEmpty()) {
			index--;
		}
	}
	/**
	 * Obtiene el primer indice de la lista
	 * @return si está vacía obtiene el 0 si no el 1
	 */
	public int getIndex() {
		if (reparaciones.isEmpty())
			return index;
		else
			return index + 1;
	}
	/**
	 * Obtener tamaño de la lista
	 * @return el tamaño
	 */
	public int getSize() {
		return reparaciones.size();
	}
}
