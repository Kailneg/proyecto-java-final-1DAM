package controller;

import contenedores.UserContainer;
import models.User;

public class MainController {

	private UserContainer usuarios;

	public MainController() {
		this.usuarios = new UserContainer();
		// Usuarios por defecto
		usuarios.aniadirUsuario(new User("Paco", "123"));
		usuarios.aniadirUsuario(new User("admin", "aaa"));
	}

	public UserContainer getUsuarios() {
		return usuarios;
	}
	
}
