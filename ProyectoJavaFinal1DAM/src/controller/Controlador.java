package controller;

import contenedores.ContenedorUsuarios;

public class Controlador {

	private ContenedorUsuarios usuarios;
	
	public Controlador(ContenedorUsuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	public ContenedorUsuarios getUsuarios(){
		return usuarios;
	}
}
