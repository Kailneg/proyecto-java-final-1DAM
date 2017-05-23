package contenedores;

import java.util.ArrayList;

import exceptions.UsernameNotFound;
import models.Usuario;

public class UserContainer {

	private ArrayList<Usuario> usuarios;

	public UserContainer() {
		usuarios = new ArrayList<>();
	}

	public Usuario obtenUsuario(String nombre) {
		for (Usuario u : usuarios) {
			if (u.getNombre().equals(nombre))
				return u;
		}
		throw new UsernameNotFound();
	}

	public boolean aniadirUsuario(Usuario usuario) {
		return usuarios.add(usuario);
	}

	public boolean comprobarLogin(Usuario usuario, String contrasenia) {
		return usuarios.contains(usuario) && usuario.comprobarContrasenia(contrasenia);
	}

	public boolean eliminarUsuario(Usuario usuario) {
		return usuarios.remove(usuario);
	}
}
