package controller;

public class ControladorPrincipal {
	
	private ControladorLogin controladorLogin;
	private ControladorMenu controladorMenu;
	private ControladorVehiculos controladorVehiculo;
	private ControladorCliente controladorCliente;
	private ControladorReparaciones controladorReparaciones;
	private ControladorElegirVehiculo controladorElegirVehiculo;

	public ControladorPrincipal() {
		controladorLogin = new ControladorLogin(this);
		controladorLogin.mostrarLogin();
	}
	
	public ControladorMenu getControladorMenu() {
		if (controladorMenu == null)
			controladorMenu = new ControladorMenu(this);
		return controladorMenu;
	}
	
	public ControladorVehiculos getControladorVehiculo(){
		if (controladorVehiculo == null)
			controladorVehiculo = new ControladorVehiculos(this);
		return controladorVehiculo;
	}
	
	public ControladorCliente getControladorCliente(){
		if (controladorCliente == null)
			controladorCliente = new ControladorCliente(this);
		return controladorCliente;
	}
	
	public ControladorReparaciones getControladorReparaciones(){
		if (controladorReparaciones == null)
			controladorReparaciones = new ControladorReparaciones(this);
		return controladorReparaciones;
	}
	
	public ControladorElegirVehiculo getControladorElegirVehiculo(){
		if (controladorElegirVehiculo == null)
			controladorElegirVehiculo = new ControladorElegirVehiculo(this);
		return controladorElegirVehiculo;
	}
}
