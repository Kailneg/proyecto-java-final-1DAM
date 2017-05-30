package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class VentanaEleccionVehiculo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEleccionVehiculo frame = new VentanaEleccionVehiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEleccionVehiculo() {
		setTitle("Eleccion Veh\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btn_coche = new JButton("Coche");
		panel.add(btn_coche);
		
		JButton btn_moto = new JButton("Motocicleta");
		panel.add(btn_moto);
		
		JButton btn_camion = new JButton("Camion");
		panel.add(btn_camion);
		
		JButton btnNewButton_3 = new JButton("Bicicleta");
		panel.add(btnNewButton_3);
	}

}
