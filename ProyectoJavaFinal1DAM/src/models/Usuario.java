package models;

import exceptions.ContraseniaNoEncontrada;

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

	/**
	 * Cambia la contrase�a del usuario.
	 * @param antiguaContrasenia La contrase�a actual, la que queremos cambiar.
	 * @param nuevaContrasenia La que queremos que sea la nueva contrase�a.
	 * @return True si todo ha salido bien y si no lanzar� una excepcion
	 */
	public boolean nuevaContrasenia(String antiguaContrasenia, String nuevaContrasenia) {
		if (this.contrasenia.equals(antiguaContrasenia)){
			contrasenia = nuevaContrasenia;
			return true;
		}
		else
			throw new ContraseniaNoEncontrada();
	}
	
	/**
	 * Comprueba que la contrase�a es correcta
	 * @param contrasenia La contrase�a que queremos validar
	 * @return True si es correcta si no lanzar� una excepcion
	 */
	public boolean comprobarContrasenia(String contrasenia){
		if(this.contrasenia.equals(contrasenia))
			return true;
		else
			throw new ContraseniaNoEncontrada();
	}
}
