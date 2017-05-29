package exceptions;

@SuppressWarnings("serial")
public class ReparacionNoEncontrada extends RuntimeException {
	public ReparacionNoEncontrada() {
		super("Reparacion no encontrada.");
	} 
}
