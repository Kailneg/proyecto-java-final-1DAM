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
	 * Cambia la contraseña del usuario.
	 * @param antiguaContrasenia La contraseña actual, la que queremos cambiar.
	 * @param nuevaContrasenia La que queremos que sea la nueva contraseña.
	 * @return True si todo ha salido bien y si no lanzará una excepcion
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
	 * Comprueba que la contraseña es correcta
	 * @param contrasenia La contraseña que queremos validar
	 * @return True si es correcta si no lanzará una excepcion
	 */
	public boolean comprobarContrasenia(String contrasenia){
		if(this.contrasenia.equals(contrasenia))
			return true;
		else
			throw new ContraseniaNoEncontrada();
	}
}
