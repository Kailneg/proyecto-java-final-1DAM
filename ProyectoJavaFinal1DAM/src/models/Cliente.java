package models;

public class Cliente {

	// VARIABLES
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private long telefono;
	private String email;

	// CONSTRUCTOR
	/**
	 * Crea un nuevo objeto de tipo Cliente con los atributos especificados.
	 * @param dni dni identificador del cliente.
	 * @param nombre nombre del cliente.
	 * @param apellidos apellido del cliente
	 * @param direccion direccion del cliente.
	 * @param telefono n�mero de tel�fono del cliente.
	 * @param email email del cliente.
	 */
	public Cliente(String dni, String nombre, String apellidos, String direccion, long telefono, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	// GETTERS
	/**
	 * Devuelve el atributo DNI.
	 * @return atributo dni de la instancia.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Devuelve el atributo Nombre.
	 * @return atributo nombre de la instancia.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el atributo Apellidos.
	 * @return atributo apellidos de la instancia.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Devuelve el atributo Direcci�n.
	 * @return atributo direccion de la instancia.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Devuelve el atributo Tel�fono.
	 * @return atributo telefono de la instancia.
	 */
	public long getTelefono() {
		return telefono;
	}

	/**
	 * Devuelve el atributo Email.
	 * @return atributo email de la instancia.
	 */
	public String getEmail() {
		return email;
	}

	// SETTERS
	/**
	 * Fija el atributo nombre de la instancia al valor pasado por par�metros.
	 * @param nombre el nuevo valor que tendr� el atributo nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Fija el atributo apellidos de la instancia al valor pasado por par�metros.
	 * @param apellidos el nuevo valor que tendr� el atributo apellidos.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Fija el atributo direccion de la instancia al valor pasado por par�metros.
	 * @param direccion el nuevo valor que tendr� el atributo direccion.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Fija el atributo telefono de la instancia al valor pasado por par�metros.
	 * @param telefono el nuevo valor que tendr� el atributo telefono.
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	/**
	 * Fija el atributo email de la instancia al valor pasado por par�metros.
	 * @param email el nuevo valor que tendr� el atributo email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", email=" + email + "]";
	}
}
