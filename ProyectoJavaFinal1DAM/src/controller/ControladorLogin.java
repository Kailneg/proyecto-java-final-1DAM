package controller;

import javax.swing.JOptionPane;

import GUI.VentanaLogin;
import contenedores.ContenedorPrincipal;
import contenedores.ContenedorUsuarios;
import exceptions.ContraseniaNoEncontrada;
import exceptions.UsuarioNoEncontrado;

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
		DAO.LoginDAO.Login(login.getUsuario(), login.getContrasenia());
		
		
		
		/*try {
			if (usuarios.comprobarLogin(usuarios.obtenUsuario(login.getUsuario()),
					login.getContrasenia())) {
				JOptionPane.showMessageDialog(null, "Login correcto");
				ocultarLogin();
				controladorPrincipal.getControladorMenu().mostrarMenu();
			}
		} catch (UsuarioNoEncontrado ex1) {
			JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ContraseniaNoEncontrada ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}*/
	}
}
