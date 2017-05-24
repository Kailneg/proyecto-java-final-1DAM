package exceptions;

public class ClienteNoEncontrado extends RuntimeException {
	public ClienteNoEncontrado() {
		super("Cliente no encontrado.");
	} 
}
