package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorElegirVehiculo;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaEleccionVehiculo extends JFrame {
	
	private VentanaEleccionVehiculo frame;
	private ControladorElegirVehiculo controladorElegirVehiculo;
	private JPanel contentPane;
	private JPanel 	panel;
	private JButton btn_coche;
	private JButton btn_moto;
	private JButton btn_camion;
	private JButton btn_bici;


	/**
	 * Create the frame.
	 */
	public VentanaEleccionVehiculo(ControladorElegirVehiculo controladorElegirVehiculo) {
		this.controladorElegirVehiculo = controladorElegirVehiculo;
		componentsInitializers();
		componentsProperties();
		componentsAdders();
		componentsAdapters();
	}
	
	//Ocultar y mostrar
	public void mostrarVentana(){
		frame.setVisible(true);
	}
	
	public void ocultarVentana(){
		frame.setVisible(false);
	}

	private void componentsInitializers() {
		panel = new JPanel();
		btn_coche = new JButton("");
		btn_moto = new JButton("");
		btn_camion = new JButton("");
		btn_bici = new JButton("");
	}

	private void componentsProperties() {
		setResizable(false);
		setTitle("Eleccion Veh\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		btn_coche.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/coche.png")));
		btn_moto.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/moto.png")));
		btn_camion.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/camion.png")));
		btn_bici.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/bici.png")));
	}

	private void componentsAdders() {
		contentPane.add(panel, BorderLayout.CENTER);
		panel.add(btn_coche);
		panel.add(btn_moto);
		panel.add(btn_camion);
		panel.add(btn_bici);
	}

	private void componentsAdapters() {
		btn_coche.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btn_moto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btn_camion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btn_bici.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
	}
}
