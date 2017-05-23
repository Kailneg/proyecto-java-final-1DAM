package main;

import javax.swing.UIManager;

import GUI.Login;
import controller.MainController;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MainController();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
