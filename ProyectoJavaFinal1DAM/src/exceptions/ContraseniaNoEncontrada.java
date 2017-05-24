package exceptions;

/**
 * Se lanza esta excepci�n cuando la contrase�a no ha sido encontrada.
 */
@SuppressWarnings("serial")
public class ContraseniaNoEncontrada extends RuntimeException {
	public ContraseniaNoEncontrada() {
		super("La contrase�a no coincide.");
	}
}
