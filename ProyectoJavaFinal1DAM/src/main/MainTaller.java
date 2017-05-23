package main;

import GUI.Login;
import controller.Controlador;

public class MainTaller {

	public static void main(String[] args) {
		try {
			// Creando usuarios y contrasenias
			Controlador controlador = new Controlador();

			Login window = new Login(controlador);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
