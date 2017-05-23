package exceptions;

@SuppressWarnings("serial")
public class ContraseniaNoEncontrada extends RuntimeException {
	public ContraseniaNoEncontrada() {
		super("La contraseņa no coincide.");
	}
}
