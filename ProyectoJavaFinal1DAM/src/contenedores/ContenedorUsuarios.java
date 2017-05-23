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

	/**
	 * Busca el usuario correspondiente al nombre que le pasemos por parámetro
	 * @param nombre Nombre del usuario que queremos buscar.
	 * @return si lo encuentra devuelve los datos del mismo sino lanza una excepción.
	 * @throws UsuarioNoEncontrado
	 */
	public Usuario obtenUsuario(String usuario) throws UsuarioNoEncontrado {
		for (Usuario u : usuarios) {
			if (u.getUsuario().equals(usuario))
				return u;
		}
		throw new UsuarioNoEncontrado();
	}

	/**
	 * Añade un nuevo usuario
	 * @param usuario El usuario que queremos añadir.
	 * @return True si se ha realizado o una excepcion si no ha sido posible
	 */
	public boolean aniadirUsuario(Usuario usuario) {
		return usuarios.add(usuario);
	}

	/**
	 * Comprueba que el usuario y la contraseña existan.
	 * @param usuario El usuario para logearse
	 * @param contrasenia la contraseña asociada a ese usuario
	 * @return devuelve true si existen o una excepcion si no existe el usuario o la contraseña
	 * @throws UsuarioNoEncontrado
	 * @throws ContraseniaNoEncontrada
	 */
	public boolean comprobarLogin(Usuario usuario, String contrasenia) throws UsuarioNoEncontrado, ContraseniaNoEncontrada {
		if (!usuarios.contains(usuario)) {
			throw new UsuarioNoEncontrado();
		}
		if (!usuario.comprobarContrasenia(contrasenia)) {
			throw new ContraseniaNoEncontrada();
		}
		return true;
	}

	/**
	 * Elimina un usuaario
	 * @param usuario el usuaario que queremos eliminar
	 * @return true si lo ha podido borrar o false si no ha podido.
	 */
	public boolean eliminarUsuario(Usuario usuario) {
		return usuarios.remove(usuario);
	}
}
