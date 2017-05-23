package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vehiculo {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblModelo;
	private JLabel lblPuertas;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JLabel lblColor;
	private JLabel lblAoMatriculacin;
	private JLabel lblCaballos;
	private JLabel lblTipoCombustible;
	private JButton btnClientes;
	private JButton btnRepararVehvulo;
	private JButton btnAtrs;
	private JLabel label;
	private JButton button;
	private JButton button_1;
	private JButton btnEditar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehiculo window = new Vehiculo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vehiculo() {
		
		vehiculoComponents();
	}

	private void vehiculoComponents(){
		componentsInitializers();
		componentsAdders();
		componentsProperties();
		componentsListeners();
	}
	
	private void componentsInitializers(){
		frame = new JFrame();
		JLabel lblNewLabel = new JLabel("Matr\u00EDcula:");
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		JLabel lblModelo = new JLabel("Modelo:");
		JLabel lblPuertas = new JLabel("Puertas:");
		JRadioButton radioButton = new JRadioButton("3");
		JRadioButton radioButton_1 = new JRadioButton("5");
		JLabel lblColor = new JLabel("Color:");
		JLabel lblAoMatriculacin = new JLabel("A\u00F1o Matriculaci\u00F3n:");
		JLabel lblCaballos = new JLabel("Caballos:");
		JLabel lblTipoCombustible = new JLabel("Tipo combustible:");
		JButton btnClientes = new JButton("Clientes");
		JButton btnRepararVehvulo = new JButton("Reparar Veh\u00EDvulo");
		JButton btnAtrs = new JButton("Atr\u00E1s");
		textField = new JTextField();
		textField_1 = new JTextField();
		textField_2 = new JTextField();
		textField_3 = new JTextField();
		textField_4 = new JTextField();
		textField_5 = new JTextField();
		textField_6 = new JTextField();
		JLabel label = new JLabel("0/0");
		JButton button = new JButton("<");
		JButton button_1 = new JButton(">");
		JButton btnEditar = new JButton("Editar");
	}

	private void componentsAdders(){
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblModelo);
		frame.getContentPane().add(lblPuertas);
		frame.getContentPane().add(radioButton);
		frame.getContentPane().add(radioButton_1);
		frame.getContentPane().add(lblColor);
		frame.getContentPane().add(lblAoMatriculacin);
		frame.getContentPane().add(lblCaballos);
		frame.getContentPane().add(lblTipoCombustible);
		frame.getContentPane().add(btnClientes);
		frame.getContentPane().add(btnRepararVehvulo);
		frame.getContentPane().add(btnAtrs);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(textField_2);
		frame.getContentPane().add(textField_3);
		frame.getContentPane().add(textField_4);
		frame.getContentPane().add(textField_5);
		frame.getContentPane().add(textField_6);
		frame.getContentPane().add(label);
		frame.getContentPane().add(button);
		frame.getContentPane().add(button_1);
		frame.getContentPane().add(btnEditar);
		
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_1);
		
	}

	private void componentsProperties(){
		frame.setBounds(100, 100, 450, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(36, 29, 64, 19);
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 62, 53, 19);
		
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(36, 92, 64, 19);
		
		lblPuertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuertas.setBounds(36, 137, 64, 14);
		
		radioButton.setBounds(96, 135, 38, 23);
		
		radioButton_1.setBounds(132, 135, 38, 23);
		
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblColor.setBounds(36, 167, 46, 14);
		
		lblAoMatriculacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAoMatriculacin.setBounds(36, 205, 121, 14);
		
		lblCaballos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaballos.setBounds(36, 246, 64, 14);
		
		lblTipoCombustible.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoCombustible.setBounds(36, 284, 113, 14);
		
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClientes.setBounds(261, 29, 147, 108);
		
		btnRepararVehvulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRepararVehvulo.setBounds(261, 167, 147, 108);
		
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtrs.setBounds(261, 310, 147, 76);
		
		textField.setBounds(96, 30, 86, 20);
		textField.setColumns(10);
		
		textField_1.setBounds(82, 59, 100, 20);
		textField_1.setColumns(10);
		
		textField_2.setBounds(84, 92, 98, 20);
		textField_2.setColumns(10);
		
		textField_3.setBounds(84, 166, 86, 20);
		textField_3.setColumns(10);
		
		textField_4.setBounds(151, 204, 86, 20);
		textField_4.setColumns(10);
		
		textField_5.setBounds(96, 245, 86, 20);
		textField_5.setColumns(10);
		
		
		textField_6.setBounds(151, 283, 86, 20);
		textField_6.setColumns(10);
		
		
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(119, 324, 38, 23);
		
		button.setBounds(36, 318, 53, 93);
		
		button_1.setBounds(184, 318, 53, 93);
		
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(93, 358, 89, 53);
	}

	private void componentsListeners(){
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
	
	
	
}
