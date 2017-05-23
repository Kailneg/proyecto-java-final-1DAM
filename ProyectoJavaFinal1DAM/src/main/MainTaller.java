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
			Controlador controlador = new Controlador();
			
			
			Login window = new Login(controlador);
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
