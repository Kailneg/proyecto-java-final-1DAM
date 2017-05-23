package controller;

import contenedores.ContenedorUsuarios;
import models.Usuario;

public class Controlador {

	private ContenedorUsuarios usuarios;

	public Controlador() {
		this.usuarios = new ContenedorUsuarios();
		// Usuarios por defecto
		usuarios.aniadirUsuario(new Usuario("Paco", "123"));
		usuarios.aniadirUsuario(new Usuario("admin", "aaa"));
	}

	public ContenedorUsuarios getUsuarios() {
		return usuarios;
	}
	
}
