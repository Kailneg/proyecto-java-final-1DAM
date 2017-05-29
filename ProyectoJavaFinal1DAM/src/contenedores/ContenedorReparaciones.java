package contenedores;

import java.util.ArrayList;

import exceptions.ClienteNoEncontrado;
import exceptions.ReparacionNoEncontrada;
import exceptions.UsuarioNoEncontrado;
import models.Reparacion;
import models.Usuario;

public class ContenedorReparaciones {
	
	private ArrayList<Reparacion> reparaciones;
	
	public ContenedorReparaciones() {
		reparaciones = new ArrayList<Reparacion>();
	}
	
	public Reparacion obtenReparacion(int idReparacion) throws UsuarioNoEncontrado {
		for (Reparacion r : reparaciones) {
			if (r.getIdReparacion() == idReparacion)
				return r;
		}
		throw new ReparacionNoEncontrada();
	}

	public boolean aniadirReparacion(Reparacion reparacion) {
		return reparaciones.add(reparacion);
	}

	public boolean eliminarCliente(Reparacion reparacion) {
		return reparaciones.remove(reparacion);
	}
}