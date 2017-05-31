package contenedores;

import java.util.ArrayList;
import java.util.List;

import exceptions.ReparacionNoEncontrada;
import models.Reparacion;

public class ContenedorReparaciones {
	
	private ArrayList<Reparacion> reparaciones;
	private int index;
	
	public ContenedorReparaciones() {
		reparaciones = new ArrayList<Reparacion>();
		index = 0;
	}
	
	public List<Reparacion> getCopiaReparaciones(){
		return reparaciones.subList(0, reparaciones.size());
	}
	
	public Reparacion obtenReparacion(int idReparacion) {
		for (Reparacion r : reparaciones) {
			if (r.getIdReparacion() == idReparacion)
				return r;
		}
		throw new ReparacionNoEncontrada();
	}

	public boolean aniadirReparacion(Reparacion reparacion) {
		return reparaciones.add(reparacion);
	}

	public boolean borrarReparacion(Reparacion reparacion) {
		return reparaciones.remove(reparacion);
	}

	public Reparacion obtenerReparacion() {
		if (!reparaciones.isEmpty()) {
			return obtenerReparacion(index);
		} else {
			return null;
		}
	}
	
	public Reparacion obtenerReparacion(int index) {
		if (reparaciones.get(index) != null) {
			return reparaciones.get(index);
		} else {
			return null;
		}
	}
	
	public void aumentarIndex() {
		if (index < reparaciones.size() - 1 && !reparaciones.isEmpty())
			index++;
	}

	public void disminuirIndex() {
		if (index > 0 && !reparaciones.isEmpty()) {
			index--;
		}
	}
	
	public int getIndex() {
		if (reparaciones.isEmpty())
			return index;
		else
			return index + 1;
	}

	public int getSize() {
		return reparaciones.size();
	}
}
