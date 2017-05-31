package models;

import java.util.Calendar;

import exceptions.ContraseniaNoEncontrada;

public class Usuario {
	
	// VARIABLES
	private String usuario, nombre, apellidos, contrasenia;
	private float sueldo;
	private int diasVacaciones;
	private Calendar fechaContratacion;
	
	
	// CONSTRUCTORES
	
	/**
	 * Crea un objeto de tipo Usuario con los atributos referentes al inicio de sesion.
	 * @param usuario el nombre de login del usuario.
	 * @param contrasenia la contraseña que tendrá el usuario.
	 */
	public Usuario(String usuario, String contrasenia) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	/**
	 * Crea un objeto de tipo Usuario con todos los atributos de usuario.
	 * @param usuario el nombre de login del usuario.
	 * @param nombre el nombre del usuario.
	 * @param apellidos el apellido del usuario.
	 * @param contrasenia la contraseña que tendrá el usuario.
	 * @param sueldo el sueldo que tendrá dicho usuario.
	 * @param diasVacaciones los días de vacaciones que dispondrá dicho usuario.
	 * @param fechaContratacion un objeto ya instanciado de tipo Calendar con la fecha de contratación establecida anteriormente.
	 */
	public Usuario(String usuario, String nombre, String apellidos, String contrasenia, float sueldo, int diasVacaciones,
			Calendar fechaContratacion) {
		this(usuario, contrasenia);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.diasVacaciones = diasVacaciones;
		this.fechaContratacion = fechaContratacion;
	}

	//GETTERS
	public String getUsuario() {
		return usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public float getSueldo() {
		return sueldo;
	}

	public int getDiasVacaciones() {
		return diasVacaciones;
	}

	public Calendar getFechaContratacion() {
		return fechaContratacion;
	}

	//SETTERS
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public void setDiasVacaciones(int diasVacaciones) {
		this.diasVacaciones = diasVacaciones;
	}

	public void setFechaContratacion(Calendar fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	
	//METODOS
	
	/**
	 * Cambia la contraseña del usuario.
	 * @param antiguaContrasenia La contraseña actual, la que queremos cambiar.
	 * @param nuevaContrasenia La que queremos que sea la nueva contraseña.
	 * @return True si todo ha salido bien, si no lanzará excepcion ContraseniaNoEncontrada.
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
	 * @return True si es correcta si no lanzará excepcion ContraseniaNoEncontrada.
	 */
	public boolean comprobarContrasenia(String contrasenia){
		if(this.contrasenia.equals(contrasenia))
			return true;
		else
			throw new ContraseniaNoEncontrada();
	}

	/**
	 * Imprime el usuario y la contrasenia del usuario
	 */
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	
}
