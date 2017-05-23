package controller;

import contenedores.UserContainer;
import models.Usuario;

public class MainController {

	private UserContainer usuarios;

	public MainController() {
		this.usuarios = new UserContainer();
		// Usuarios por defecto
		usuarios.aniadirUsuario(new Usuario("Paco", "123"));
		usuarios.aniadirUsuario(new Usuario("admin", "aaa"));
	}

	public UserContainer getUsuarios() {
		return usuarios;
	}
	
}
