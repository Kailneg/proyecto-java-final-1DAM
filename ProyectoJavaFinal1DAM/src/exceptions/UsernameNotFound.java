package exceptions;

public class UsernameNotFound extends RuntimeException {
	public UsernameNotFound() {
		super("Usuario no encontrado.");
	}

}
