package main;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import GUI.Login;
import contenedores.ContenedorUsuarios;
import controller.Controlador;
import models.Usuario;

public class MainTaller {

	public static void main(String[] args) {
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//Creando usuarios y contrasenias
			ContenedorUsuarios cu = new ContenedorUsuarios();
			cu.aniadirUsuario(new Usuario("Paco", "123"));
			cu.aniadirUsuario(new Usuario("admin", "aaa"));
			Controlador controlador = new Controlador(cu);
			
			
			Login window = new Login(controlador);
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
