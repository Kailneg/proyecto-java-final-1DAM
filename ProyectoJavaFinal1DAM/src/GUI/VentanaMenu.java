package GUI;

import javax.swing.JFrame;

import controller.ControladorMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenu {

	private JFrame frame;
	private JPanel panel;
	private JButton btn_nuevoVehiculo, btn_buscarVehiculo;
	private ControladorMenu controladorMenu;

	/**
	 * Crea una nueva VentanaMenu.
	 * 
	 * @param controladorElegirVehiculo
	 *            controlador necesario para el funcionamiento. Se obtiene de
	 *            ControladorPrincipal.
	 */
	public VentanaMenu(ControladorMenu controladorMenu) {
		this.controladorMenu = controladorMenu;
		componentsInitializers();
		componentsProperties();
		componentsAdders();
		componentsAddapters();
	}

	// Ocultar y mostrar
	/**
	 * Muestra la ventana
	 */
	public void mostrarVentana() {
		frame.setVisible(true);
	}

	/**
	 * Oculta la ventana
	 */
	public void ocultarVentana() {
		frame.setVisible(false);
	}

	/**
	 * Inicializa los componentes
	 */
	private void componentsInitializers() {
		frame = new JFrame();
		panel = new JPanel();
		btn_nuevoVehiculo = new JButton("Crear");
		btn_buscarVehiculo = new JButton("Buscar");

	}

	/**
	 * Setea las propiedades de los componentes
	 */
	private void componentsProperties() {
		frame.setTitle("Principal");
		frame.setBounds(100, 100, 450, 193);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		btn_nuevoVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_buscarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
	}

	/**
	 * Aniade los componentes a sus respectivos paneles
	 */
	private void componentsAdders() {
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.add(btn_nuevoVehiculo);
		panel.add(btn_buscarVehiculo);
	}

	/**
	 * Aniade los adaptadores de la ventana
	 */
	private void componentsAddapters() {
		btn_nuevoVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorMenu.pulsarNuevo();
			}
		});

		btn_buscarVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorMenu.pulsarBuscar();
			}
		});
	}
}
