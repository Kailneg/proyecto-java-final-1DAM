package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.ControladorPrincipal;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaPrincipal {

	private JFrame Principal;
	private ControladorPrincipal controlador;

	/**
	 * Create the application.
	 */
	public VentanaPrincipal(ControladorPrincipal controlador) {
		this.controlador = controlador;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Principal = new JFrame();
		Principal.setTitle("Principal");
		Principal.setBounds(100, 100, 450, 193);
		Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		Principal.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btn_nuevoVehiculo = new JButton("Nuevo veh\u00EDculo");
		btn_nuevoVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btn_nuevoVehiculo);
		
		JButton btn_buscarVehiculo = new JButton("Buscar veh\u00EDculo\r\n");
		btn_buscarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btn_buscarVehiculo);
		Principal.setVisible(true);
	}

}
