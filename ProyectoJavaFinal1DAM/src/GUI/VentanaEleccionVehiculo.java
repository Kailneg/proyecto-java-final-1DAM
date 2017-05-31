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
import java.awt.Font;

public class VentanaEleccionVehiculo extends JFrame {

	private ControladorElegirVehiculo controladorElegirVehiculo;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btn_coche;
	private JButton btn_moto;
	private JButton btn_camion;
	private JButton btn_bici;
	private JButton btn_atras;

	/**
	 * Crea una nueva Ventana para elegir vehículos.
	 * 
	 * @param controladorElegirVehiculo
	 *            controlador necesario para el funcionamiento. Se obtiene de
	 *            ControladorPrincipal.
	 */
	public VentanaEleccionVehiculo(ControladorElegirVehiculo controladorElegirVehiculo) {
		this.controladorElegirVehiculo = controladorElegirVehiculo;
		componentsInitializers();
		componentsProperties();
		componentsAdders();
		componentsAdapters();
	}

	// Ocultar y mostrar
	/**
	 * Muestra la ventana
	 */
	public void mostrarVentana() {
		setVisible(true);
	}

	/**
	 * Oculta la ventana
	 */
	public void ocultarVentana() {
		setVisible(false);
	}

	/**
	 * Inicializa los componentes
	 */
	private void componentsInitializers() {
		panel = new JPanel();
		panel.setBounds(5, 5, 484, 330);
		btn_coche = new JButton("");
		btn_moto = new JButton("");
		btn_camion = new JButton("");
		btn_bici = new JButton("");
	}

	/**
	 * Setea las propiedades de los componentes
	 */
	private void componentsProperties() {
		setResizable(false);
		setTitle("Eleccion Veh\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		btn_coche.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/coche.png")));
		btn_moto.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/moto.png")));
		btn_camion.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/camion.png")));
		btn_bici.setIcon(new ImageIcon(VentanaEleccionVehiculo.class.getResource("/res/icons/bici.png")));
		btn_atras = new JButton("Atr\u00E1s");
		btn_atras.setFont(new Font("Segoe UI", Font.BOLD, 32));
		btn_atras.setBounds(5, 335, 484, 75);
	}

	/**
	 * Aniade los componentes a sus respectivos paneles
	 */
	private void componentsAdders() {
		contentPane.setLayout(null);
		contentPane.add(panel);
		panel.add(btn_coche);
		panel.add(btn_moto);
		panel.add(btn_camion);
		panel.add(btn_bici);
		contentPane.add(btn_atras);
	}

	/**
	 * Aniade los adaptadores de la ventana
	 */
	private void componentsAdapters() {

		// Coche
		btn_coche.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorElegirVehiculo.pulsarCoche();
			}
		});

		// Motocicleta
		btn_moto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorElegirVehiculo.pulsarMoto();
			}
		});

		// Camion
		btn_camion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorElegirVehiculo.pulsarCamion();
			}
		});

		// Bicicleta
		btn_bici.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorElegirVehiculo.pulsarBici();
			}
		});

		// Atras
		btn_atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorElegirVehiculo.pulsarAtras();
			}
		});
	}
}
