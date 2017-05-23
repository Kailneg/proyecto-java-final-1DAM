package controller;

import javax.swing.JOptionPane;

import GUI.Login;
import contenedores.ContenedorUsuarios;
import exceptions.ContraseniaNoEncontrada;
import exceptions.UsuarioNoEncontrado;

public class ControladorLogin {

	private ContenedorUsuarios usuarios;
	private Login login;

	public ControladorLogin() {
		usuarios = new ContenedorUsuarios();
		login = new Login(this);
	}

	/**
	 * Valida el usuario y la contraseña cuando intentamos logearnos
	 */
	public void validarLogin() {
		try {
			if (usuarios.comprobarLogin(usuarios.obtenUsuario(login.getUsuario()),
					login.getContrasenia())) {
				JOptionPane.showMessageDialog(null, "Login correcto");
			}
		} catch (UsuarioNoEncontrado ex1) {
			JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ContraseniaNoEncontrada ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
