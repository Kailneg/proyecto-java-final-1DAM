package controller;

public class ControladorPrincipal {
	
	private ControladorLogin controladorLogin;
	private ControladorMenu controladorMenu;
	private ControladorVehiculos controladorVehiculo;

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
}
