package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.ControladorVehiculos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vehiculos {

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
	private ControladorVehiculos controladorVehiculos;
	

	/**
	 * Create the application.
	 */
	public Vehiculos(ControladorVehiculos controladorVehiculos) {
		this.controladorVehiculos = controladorVehiculos;
		vehiculoComponents();
	}
	
	//Ocultar y mostrar
	public void mostrarVentana(){
		frame.setVisible(true);
	}
	
	public void ocultarVentana(){
		frame.setVisible(false);
	}

	/**
	 * Llama a los m�todos encargados de inicializar, a�adir y definir los componentes del frame
	 */
	private void vehiculoComponents(){
		componentsInitializers();
		componentsAdders();
		componentsProperties();
		componentsListeners();
	}
	
	/**
	 * Inicializa el contenido del frame.
	 */
	private void componentsInitializers(){
		frame = new JFrame();
		lblNewLabel = new JLabel("Matricula:");
		lblNewLabel_1 = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblPuertas = new JLabel("Puertas:");
		radioButton = new JRadioButton("3");
		radioButton_1 = new JRadioButton("5");
		lblColor = new JLabel("Color:");
		lblAoMatriculacin = new JLabel("A\u00F1o Matriculaci\u00F3n:");
		lblCaballos = new JLabel("Caballos:");
		lblTipoCombustible = new JLabel("Tipo combustible:");
		btnClientes = new JButton("Clientes");
		btnRepararVehvulo = new JButton("Reparar Veh\u00EDvulo");
		btnAtrs = new JButton("Atras");
		textField = new JTextField();
		textField.setBounds(96, 30, 86, 20);
		textField_1 = new JTextField();
		textField_1.setBounds(82, 59, 100, 20);
		textField_2 = new JTextField();
		textField_2.setBounds(84, 92, 98, 20);
		textField_3 = new JTextField();
		textField_3.setBounds(84, 166, 86, 20);
		textField_4 = new JTextField();
		textField_4.setBounds(151, 204, 86, 20);
		textField_5 = new JTextField();
		textField_5.setBounds(96, 245, 86, 20);
		textField_6 = new JTextField();
		textField_6.setBounds(151, 283, 86, 20);
		label = new JLabel("0/0");
		button = new JButton("<");
		button_1 = new JButton(">");
		btnEditar = new JButton("Editar");
	}

	/**
	 * A�ade al frame todos los componentes que hemos creado.
	 */
	private void componentsAdders(){
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
		frame.getContentPane().setLayout(null);
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

	/**
	 * Contiene las propiedades de todos los componentes del frame
	 */
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
		textField.setColumns(10);
		textField_1.setColumns(10);
		textField_2.setColumns(10);
		textField_3.setColumns(10);
		textField_4.setColumns(10);
		textField_5.setColumns(10);
		textField_6.setColumns(10);
		
		
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(119, 324, 38, 23);
		
		button.setBounds(36, 318, 53, 93);
		
		button_1.setBounds(184, 318, 53, 93);
		
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(93, 358, 89, 53);
	}

	/**
	 * Contiene los eventos asociados al frame
	 */
	private void componentsListeners(){
		
		//Clientes
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorVehiculos.pulsarClientes();
			}
		});
		
		//Reparaciones
		btnRepararVehvulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorVehiculos.pulsarReparaciones();
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//Atras
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorVehiculos.pulsarAtras();
			}
		});
	}
	
	
	
}