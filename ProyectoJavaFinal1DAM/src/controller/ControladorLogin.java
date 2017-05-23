package controller;

import javax.swing.JOptionPane;

import GUI.Login;
import contenedores.ContenedorUsuarios;
import exceptions.ContraseniaNoEncontrada;
import exceptions.UsuarioNoEncontrado;

public class ControladorLogin extends Login {

	private static ContenedorUsuarios usuarios;

	public ControladorLogin() {
		super();
		usuarios = new ContenedorUsuarios();
	}

	public static void validarLogin() {
		try {
			if (usuarios.comprobarLogin(usuarios.obtenUsuario(txt_usuario.getText()),
					String.valueOf(txt_contrasenia.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Login correcto");
			}
		} catch (UsuarioNoEncontrado ex1) {
			JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ContraseniaNoEncontrada ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
