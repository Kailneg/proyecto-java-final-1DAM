package contenedores;

import java.util.ArrayList;

import exceptions.UsuarioNoEncontrado;
import models.Usuario;

public class ContenedorUsuarios {

	private ArrayList<Usuario> usuarios;

	public ContenedorUsuarios() {
		usuarios = new ArrayList<>();
	}

	public Usuario obtenUsuario(String nombre) {
		for (Usuario u : usuarios) {
			if (u.getNombre().equals(nombre))
				return u;
		}
		throw new UsuarioNoEncontrado();
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
