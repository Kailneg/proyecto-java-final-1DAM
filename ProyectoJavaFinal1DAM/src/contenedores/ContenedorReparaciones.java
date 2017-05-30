package contenedores;

import java.util.ArrayList;
import java.util.List;

import exceptions.ClienteNoEncontrado;
import exceptions.ReparacionNoEncontrada;
import exceptions.UsuarioNoEncontrado;
import models.Cliente;
import models.Reparacion;
import models.Usuario;

public class ContenedorReparaciones {
	
	private ArrayList<Reparacion> reparaciones;
	
	public ContenedorReparaciones() {
		reparaciones = new ArrayList<Reparacion>();
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

	public boolean eliminarCliente(Reparacion reparacion) {
		return reparaciones.remove(reparacion);
	}
}
