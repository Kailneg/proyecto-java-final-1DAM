package controller;

import javax.swing.JOptionPane;

import GUI.Login;
import contenedores.UserContainer;
import exceptions.PasswordNotFound;
import exceptions.UsernameNotFound;

public class LoginController extends Login {
	
	private UserContainer usuarios;

	public LoginController() {
		super();
	}

	public void validarLogin() {
		try {
			if (usuarios.comprobarLogin(usuarios.obtenUsuario(txt_usuario.getText()),
					String.valueOf(txt_contrasenia.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Login correcto");
			}
		} catch (UsernameNotFound ex1) {
			JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (PasswordNotFound ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
