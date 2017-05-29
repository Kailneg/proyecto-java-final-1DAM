package exceptions;

@SuppressWarnings("serial")
public class VehiculoNoEncontrado extends RuntimeException {
	public VehiculoNoEncontrado() {
		super("Vehiculo no encontrado.");
	} 
}
