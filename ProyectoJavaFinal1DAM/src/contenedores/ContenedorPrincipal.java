package contenedores;

public class ContenedorPrincipal {

	private static ContenedorPrincipal contenedorPrincipal;
	
	private ContenedorUsuarios contenedorUsuarios;
	private ContenedorClientes contenedorClientes;
	private ContenedorVehiculos contenedorVehiculos;
	private ContenedorReparaciones contenedorReparaciones;

	private ContenedorPrincipal() {
	}
	
	public static ContenedorPrincipal getContenedorPrincipal() {
		if (contenedorPrincipal == null) {
			contenedorPrincipal = new ContenedorPrincipal();
		}
		return contenedorPrincipal;
	}

	public ContenedorUsuarios getContenedorUsuarios(){
		if (contenedorUsuarios == null) {
			contenedorUsuarios = new ContenedorUsuarios();
		}
		return contenedorUsuarios;
	}

	public ContenedorClientes getContenedorClientes(){
		if (contenedorClientes == null) {
			contenedorClientes = new ContenedorClientes();
		}
		return contenedorClientes;
	}
	
	public ContenedorVehiculos getContenedorVehiculos(){
		if (contenedorVehiculos == null) {
			contenedorVehiculos = new ContenedorVehiculos();
		}
		return contenedorVehiculos;
	}
	public ContenedorReparaciones getcontenedorReparaciones(){
		if (contenedorReparaciones == null) {
			contenedorReparaciones = new ContenedorReparaciones();
		}
		return contenedorReparaciones;
	}
}
