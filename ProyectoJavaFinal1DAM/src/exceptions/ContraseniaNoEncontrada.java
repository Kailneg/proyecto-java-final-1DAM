package exceptions;

@SuppressWarnings("serial")
public class ContraseniaNoEncontrada extends RuntimeException {
	public ContraseniaNoEncontrada() {
		super("La contraseña no coincide.");
	}
}
