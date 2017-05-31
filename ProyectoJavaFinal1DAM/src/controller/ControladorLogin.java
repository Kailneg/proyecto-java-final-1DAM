package controller;

import javax.swing.JOptionPane;

import GUI.VentanaLogin;
import contenedores.ContenedorPrincipal;
import contenedores.ContenedorUsuarios;

public class ControladorLogin {

	private ContenedorUsuarios usuarios;
	private ControladorPrincipal controladorPrincipal;
	private VentanaLogin login;

	public ControladorLogin(ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.usuarios = ContenedorPrincipal.getContenedorPrincipal().getContenedorUsuarios();
		this.login = new VentanaLogin(this);
	}
	
	public void mostrarLogin(){
		login.mostrarVentana();
	}
	
	public void ocultarLogin(){
		login.ocultarVentana();
	}


	/**
	 * Valida el usuario y la contraseña cuando intentamos logearnos
	 */
	public void validarLogin() {
		if(DAO.LoginDAO.Login(login.getUsuario(), login.getContrasenia())){	
			JOptionPane.showMessageDialog(null, "Login correcto");
			ocultarLogin();
			controladorPrincipal.getControladorMenu().mostrarMenu();
		}
		
	}
}
