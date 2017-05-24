package controller;

import GUI.Menu;

public class ControladorMenu {
	
	private ControladorPrincipal controladorPrincipal;
	private Menu menu;
	
	public ControladorMenu(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		menu = new Menu(this);
	}
	
	public void mostrarMenu(){
		menu.mostrarVentana();
	}
	
	public void ocultarMenu(){
		menu.ocultarVentana();
	}
	
	public void pulsarBuscar(){
		menu.ocultarVentana();
	}
	
	public void pulsarNuevo(){
		menu.ocultarVentana();
	}
}
