package exceptions;

/**
 * Se lanza esta excepción cuando la contraseña no ha sido encontrada.
 */
@SuppressWarnings("serial")
public class ContraseniaNoEncontrada extends RuntimeException {
	public ContraseniaNoEncontrada() {
		super("La contraseña no coincide.");
	}
}
