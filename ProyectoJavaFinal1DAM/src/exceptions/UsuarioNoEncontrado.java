package exceptions;

/**
 * Se lanza esta excepci�n cuando el usuario no ha sido encontrado.
 */
public class UsuarioNoEncontrado extends RuntimeException {
	public UsuarioNoEncontrado() {
		super("Usuario no encontrado.");
	}

}
