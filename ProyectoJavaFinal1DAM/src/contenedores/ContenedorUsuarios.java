package contenedores;

import java.util.ArrayList;

import models.Usuario;

public class ContenedorUsuarios {

	private ArrayList<Usuario> usuarios;
	
	public ContenedorUsuarios(){
		usuarios = new ArrayList<>();
	}
	
	public boolean aniadirUsuario(Usuario usuario){
		return usuarios.add(usuario);
	}
	
	public boolean comprobarLogin(Usuario usuario, String contrasenia){
		return usuarios.contains(usuario) && usuario.comprobarContrasenia(contrasenia);
	}
	
	public boolean eliminarUsuario(Usuario usuario){
		return usuarios.remove(usuario);
	}
}
