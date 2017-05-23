package main;

import javax.swing.UIManager;
import controller.ControladorPrincipal;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ControladorPrincipal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
