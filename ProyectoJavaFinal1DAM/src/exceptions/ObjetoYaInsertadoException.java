package exceptions;

public class ObjetoYaInsertadoException extends RuntimeException {
	public ObjetoYaInsertadoException() {
		super("Imposible guardar. Ya se ha a�adido con anterioridad a la base de datos.");
	}
}
