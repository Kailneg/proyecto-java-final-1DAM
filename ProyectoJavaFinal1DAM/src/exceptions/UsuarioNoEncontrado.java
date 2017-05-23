package exceptions;

public class UsuarioNoEncontrado extends RuntimeException {
	public UsuarioNoEncontrado() {
		super("Usuario no encontrado.");
	}

}
