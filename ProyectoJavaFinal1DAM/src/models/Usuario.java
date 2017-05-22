package models;

import contenedores.ContenedorUsuarios;
import exceptions.ContraseniaNoCoincide;

public class Usuario {
	
	String nombre, contrasenia;

	public Usuario(String nombre, String contrasenia) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean nuevaContrasenia(String antiguaContrasenia, String nuevaContrasenia) {
		if (this.contrasenia.equals(antiguaContrasenia)){
			contrasenia = nuevaContrasenia;
			return true;
		}
		else
			throw new ContraseniaNoCoincide("Las contrase�as no coinciden.");
	}
	
	public boolean comprobarContrasenia(String contrasenia){
		if(this.contrasenia.equals(contrasenia))
			return true;
		else
			throw new ContraseniaNoCoincide("Las contrase�as no coinciden.");
	}
}
