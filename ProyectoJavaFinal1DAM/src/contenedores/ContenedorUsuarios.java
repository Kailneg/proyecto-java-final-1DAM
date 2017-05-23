package contenedores;

import java.util.ArrayList;

import exceptions.ContraseniaNoEncontrada;
import exceptions.UsuarioNoEncontrado;
import models.Usuario;

public class ContenedorUsuarios {

	private ArrayList<Usuario> usuarios;

	public ContenedorUsuarios() {
		usuarios = new ArrayList<>();
		usuarios.add(new Usuario("admin", "123"));
	}

	public Usuario obtenUsuario(String nombre) throws UsuarioNoEncontrado {
		for (Usuario u : usuarios) {
			if (u.getNombre().equals(nombre))
				return u;
		}
		throw new UsuarioNoEncontrado();
	}

	public boolean aniadirUsuario(Usuario usuario) {
		return usuarios.add(usuario);
	}

	public boolean comprobarLogin(Usuario usuario, String contrasenia) throws UsuarioNoEncontrado, ContraseniaNoEncontrada {
		if (!usuarios.contains(usuario)) {
			throw new UsuarioNoEncontrado();
		}
		if (!usuario.comprobarContrasenia(contrasenia)) {
			throw new ContraseniaNoEncontrada();
		}
		return true;
	}

	public boolean eliminarUsuario(Usuario usuario) {
		return usuarios.remove(usuario);
	}
}
