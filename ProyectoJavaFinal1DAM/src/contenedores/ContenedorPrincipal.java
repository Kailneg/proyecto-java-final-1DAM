package contenedores;

public class ContenedorPrincipal {

	private static ContenedorPrincipal contenedorPrincipal;
	
	private ContenedorUsuarios contenedorUsuarios;
	private ContenedorClientes contenedorClientes;

	public static ContenedorPrincipal getContenedorPrincipal() {
		if (contenedorPrincipal == null) {
			contenedorPrincipal = new ContenedorPrincipal();
		}
		return contenedorPrincipal;
	}

	private ContenedorPrincipal() {
		contenedorUsuarios = null;
	}

}
