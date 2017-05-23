package contenedores;

import java.util.ArrayList;

import exceptions.UsernameNotFound;
import models.User;

public class UserContainer {

	private ArrayList<User> usuarios;

	public UserContainer() {
		usuarios = new ArrayList<>();
		usuarios.add(new User("admin", "123"));
	}

	public User obtenUsuario(String nombre) {
		for (User u : usuarios) {
			if (u.getNombre().equals(nombre))
				return u;
		}
		throw new UsernameNotFound();
	}

	public boolean aniadirUsuario(User usuario) {
		return usuarios.add(usuario);
	}

	public boolean comprobarLogin(User usuario, String contrasenia) {
		return usuarios.contains(usuario) && usuario.comprobarContrasenia(contrasenia);
	}

	public boolean eliminarUsuario(User usuario) {
		return usuarios.remove(usuario);
	}
}
