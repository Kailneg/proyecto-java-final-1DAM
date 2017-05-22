package exceptions;

public class ContraseniaNoCoincide extends RuntimeException {
	public ContraseniaNoCoincide(String mensaje) {
		super(mensaje);
	}
}
