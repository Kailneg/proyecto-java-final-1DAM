package exceptions;

@SuppressWarnings("serial")
public class ContraseniaNoCoincide extends RuntimeException {
	public ContraseniaNoCoincide() {
		super("La contraseña no coincide.");
	}
}
