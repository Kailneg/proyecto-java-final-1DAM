package models;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import interfaces.Guardable;

public class Cliente implements Guardable{

	// VARIABLES
	private String NIF;
	private String nombre;
	private String apellidos;
	private String direccion;
	private long telefono;
	private String email;

	// CONSTRUCTOR
	/**
	 * Crea un nuevo objeto de tipo Cliente con los atributos especificados.
	 * @param NIF NIF identificador del cliente.
	 * @param nombre nombre del cliente.
	 * @param apellidos apellido del cliente
	 * @param direccion direccion del cliente.
	 * @param telefono n�mero de tel�fono del cliente.
	 * @param email email del cliente.
	 */
	public Cliente(String NIF, String nombre, String apellidos, String direccion, long telefono, String email) {
		this.NIF = NIF;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Cliente(DBObject dbObject) { 
		this.NIF = (String) dbObject.get("NIF");
		this.nombre = (String) dbObject.get("nombre");
		this.apellidos = (String) dbObject.get("apellidos");
		this.direccion = (String) dbObject.get("direccion");
		this.email = (String) dbObject.get("email");
		this.telefono = (long) dbObject.get("telefono");
	}

	// GETTERS
	/**
	 * Devuelve el atributo NIF.
	 * @return atributo NIF de la instancia.
	 */
	public String getNIF() {
		return NIF;
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
		return "Cliente [NIF=" + NIF + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", email=" + email + "]";
	}

	@Override
	public BasicDBObject guardar() {
		BasicDBObject registro = new BasicDBObject("NIF", this.getNIF());
		registro.append("nombre", this.getNombre());
		registro.append("apellidos", this.getApellidos());
		registro.append("direccion", this.getDireccion());
		registro.append("telefono", this.getTelefono());
		registro.append("email", this.getEmail());
		return registro;
	}
}
