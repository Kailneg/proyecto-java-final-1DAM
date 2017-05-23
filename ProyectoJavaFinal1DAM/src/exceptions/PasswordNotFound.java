package exceptions;

@SuppressWarnings("serial")
public class PasswordNotFound extends RuntimeException {
	public PasswordNotFound() {
		super("La contraseña no coincide.");
	}
}
