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
	 * Create the application.
	 */
	public VentanaMenu(ControladorMenu controladorMenu) {
		this.controladorMenu = controladorMenu;
		initialize();
		adaptadores();
	}
	
	public void mostrarVentana(){
		frame.setVisible(true);
	}
	
	public void ocultarVentana(){
		frame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Principal");
		frame.setBounds(100, 100, 450, 193);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		btn_nuevoVehiculo = new JButton("Nuevo veh\u00EDculo");

		btn_nuevoVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btn_nuevoVehiculo);
		
		btn_buscarVehiculo = new JButton("Buscar veh\u00EDculo\r\n");

		btn_buscarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btn_buscarVehiculo);
		
	}

	private void adaptadores(){
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
