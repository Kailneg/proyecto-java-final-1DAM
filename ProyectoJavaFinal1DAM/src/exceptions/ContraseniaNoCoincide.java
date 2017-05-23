package exceptions;

@SuppressWarnings("serial")
public class ContraseniaNoCoincide extends RuntimeException {
	public ContraseniaNoCoincide() {
		super("La contraseņa no coincide.");
	}
}
