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
	/**
	 * Devuelve el atributo Usuario.
	 * @return atributo usuario de Usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Devuelve el atributo Nombre.
	 * @return atributo nombre de Usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el atributo sueldo.
	 * @return atributo Sueldo de Usuario
	 */
	public float getSueldo() {
		return sueldo;
	}

	/**
	 * Devuelve el atributo Dias de Vacaciones.
	 * @return atributo diasVacaciones de Usuario
	 */
	public int getDiasVacaciones() {
		return diasVacaciones;
	}

	/**
	 * Devuelve el atributo fechaContratacion.
	 * @return atributo fechaContratacion.
	 */
	public Calendar getFechaContratacion() {
		return fechaContratacion;
	}

	//SETTERS
	/**
	 * Fija al atributo usuario de la instancia el valor pasado por parámetros.
	 * @param usuario el nuevo valor que tendrá el atributo usuario.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Fija al atributo nombre de la instancia el valor pasado por parámetros
	 * @param nombre el nuevo valor que tendrá el atributo nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Fija al atributo sueldo de la instancia el valor pasado por parámetros
	 * @param sueldo el nuevo valor que tendrá el atributo sueldo.
	 */
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * Fija al atributo DiasVacaciones de la instancia el valor pasado por parámetros
	 * @param diasVacaciones el nuevo valor que tendrá el atributo diasVacaciones.
	 */
	public void setDiasVacaciones(int diasVacaciones) {
		this.diasVacaciones = diasVacaciones;
	}

	/**
	 * Fija al atributo fechaContratacion de la instancia el valor pasado por parámetros
	 * @param fechaContratacion el nuevo valor que tendrá el atributo fechaContratacion.
	 */ 
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
