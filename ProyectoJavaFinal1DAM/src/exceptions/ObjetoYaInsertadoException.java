package exceptions;

public class ObjetoYaInsertadoException extends RuntimeException {
	public ObjetoYaInsertadoException() {
		super("Imposible guardar. Ya se ha añadido con anterioridad a la base de datos.");
	}
}
