package exceptions;

@SuppressWarnings("serial")
public class ContraseniaNoCoincide extends RuntimeException {
	public ContraseniaNoCoincide() {
		super("La contrase�a no coincide.");
	}
}
