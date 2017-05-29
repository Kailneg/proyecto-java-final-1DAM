package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.ControladorVehiculos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaVehiculos {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFrame frmVehiculos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblModelo;
	private JLabel lblPuertas;
	private JRadioButton rb_3puertas;
	private JRadioButton rb_5puertas;
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
	private JTextField txt_cv;
	private JTextField txt_marca;
	private JTextField txt_matricula;
	private JTextField txt_modelo;
	private JTextField txt_color;
	private JTextField txt_combustible;
	private JTextField txt_potencia;
	private JComboBox cbox_dia;
	private JComboBox cbox_mes;
	private JComboBox cbox_ano;
	private JMenuBar menuBar;
	private JMenu mnModo;
	private JMenuItem mntmLeer;
	private JMenuItem mntmCrear;
	private ControladorVehiculos controladorVehiculos;
	

	/**
	 * Create the application.
	 */
	public VentanaVehiculos(ControladorVehiculos controladorVehiculos) {
		this.controladorVehiculos = controladorVehiculos;
		vehiculoComponents();
	}
	
	//Ocultar y mostrar
	public void mostrarVentana(){
		frmVehiculos.setVisible(true);
	}
	
	public void ocultarVentana(){
		frmVehiculos.setVisible(false);
	}

	/**
	 * Llama a los métodos encargados de inicializar, añadir y definir los componentes del frame
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
		frmVehiculos = new JFrame();
		frmVehiculos.setTitle("Vehiculos");
		lblNewLabel = new JLabel("Matricula:");
		lblNewLabel_1 = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblPuertas = new JLabel("Puertas:");
		rb_3puertas = new JRadioButton("3");
		rb_5puertas = new JRadioButton("5");
		lblColor = new JLabel("Color:");
		lblAoMatriculacin = new JLabel("Matriculaci\u00F3n:");
		lblCaballos = new JLabel("Potencia:");
		lblTipoCombustible = new JLabel("Combustible:");
		btnClientes = new JButton("Clientes");
		btnRepararVehvulo = new JButton("Reparar Veh\u00EDvulo");
		btnAtrs = new JButton("Atras");
		label = new JLabel("0/0");
		button = new JButton("<");
		button_1 = new JButton(">");
		btnEditar = new JButton("Editar");
		txt_cv = new JTextField();
		txt_marca = new JTextField();
		txt_matricula = new JTextField();
		txt_modelo = new JTextField();
		txt_color = new JTextField();
		txt_combustible = new JTextField();
		txt_potencia = new JTextField();
		cbox_dia = new JComboBox();
		cbox_mes = new JComboBox();
		cbox_ano = new JComboBox();
		
		menuBar = new JMenuBar();
		frmVehiculos.setJMenuBar(menuBar);
		
		mnModo = new JMenu("Modo");
		menuBar.add(mnModo);
		
		mntmLeer = new JMenuItem("Leer");
		mnModo.add(mntmLeer);
		
		mntmCrear = new JMenuItem("Crear");
		mnModo.add(mntmCrear);
		
	}

	/**
	 * Añade al frame todos los componentes que hemos creado.
	 */
	private void componentsAdders(){
		frmVehiculos.getContentPane().add(lblNewLabel);
		frmVehiculos.getContentPane().add(lblNewLabel_1);
		frmVehiculos.getContentPane().add(lblModelo);
		frmVehiculos.getContentPane().add(lblPuertas);
		frmVehiculos.getContentPane().add(rb_3puertas);
		frmVehiculos.getContentPane().add(rb_5puertas);
		frmVehiculos.getContentPane().add(lblColor);
		frmVehiculos.getContentPane().add(lblAoMatriculacin);
		frmVehiculos.getContentPane().add(lblCaballos);
		frmVehiculos.getContentPane().add(lblTipoCombustible);
		frmVehiculos.getContentPane().add(btnClientes);
		frmVehiculos.getContentPane().add(btnRepararVehvulo);
		frmVehiculos.getContentPane().add(btnAtrs);
		frmVehiculos.getContentPane().setLayout(null);
		frmVehiculos.getContentPane().add(label);
		frmVehiculos.getContentPane().add(button);
		frmVehiculos.getContentPane().add(button_1);
		frmVehiculos.getContentPane().add(btnEditar);
		
		buttonGroup.add(rb_3puertas);
		buttonGroup.add(rb_5puertas);
				
		txt_cv.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_cv.setEditable(false);
		txt_cv.setText("CV");
		txt_cv.setBounds(207, 243, 30, 24);
		frmVehiculos.getContentPane().add(txt_cv);
		txt_cv.setColumns(10);	
		
		txt_marca.setColumns(10);
		txt_marca.setBounds(119, 59, 118, 24);
		frmVehiculos.getContentPane().add(txt_marca);
		
		txt_matricula.setColumns(10);
		txt_matricula.setBounds(119, 28, 118, 24);
		frmVehiculos.getContentPane().add(txt_matricula);	
		
		txt_modelo.setColumns(10);
		txt_modelo.setBounds(119, 91, 118, 24);
		frmVehiculos.getContentPane().add(txt_modelo);	
		
		txt_color.setColumns(10);
		txt_color.setBounds(119, 163, 118, 24);
		frmVehiculos.getContentPane().add(txt_color);
		
		
		txt_combustible.setColumns(10);
		txt_combustible.setBounds(119, 281, 118, 24);
		frmVehiculos.getContentPane().add(txt_combustible);
		
		
		txt_potencia.setColumns(10);
		txt_potencia.setBounds(119, 243, 89, 24);
		frmVehiculos.getContentPane().add(txt_potencia);
		
		
		cbox_dia.setModel(new DefaultComboBoxModel(new String[] {"D"}));
		cbox_dia.setBounds(121, 202, 38, 20);
		frmVehiculos.getContentPane().add(cbox_dia);
		

		cbox_mes.setModel(new DefaultComboBoxModel(new String[] {"M"}));
		cbox_mes.setBounds(158, 202, 38, 20);
		frmVehiculos.getContentPane().add(cbox_mes);
		

		cbox_ano.setModel(new DefaultComboBoxModel(new String[] {"A"}));
		cbox_ano.setBounds(197, 202, 40, 20);
		frmVehiculos.getContentPane().add(cbox_ano);
	}

	/**
	 * Contiene las propiedades de todos los componentes del frame
	 */
	private void componentsProperties(){
		frmVehiculos.setBounds(100, 100, 450, 478);
		frmVehiculos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(36, 29, 64, 19);
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(36, 62, 53, 19);
		
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblModelo.setBounds(36, 92, 64, 19);
		
		lblPuertas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPuertas.setBounds(36, 137, 64, 14);
		
		rb_3puertas.setBounds(132, 133, 38, 23);	
		rb_5puertas.setBounds(199, 133, 38, 23);
		
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblColor.setBounds(36, 167, 46, 14);
		
		lblAoMatriculacin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAoMatriculacin.setBounds(36, 205, 98, 14);
		
		lblCaballos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCaballos.setBounds(36, 246, 64, 14);
		
		lblTipoCombustible.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoCombustible.setBounds(36, 284, 73, 14);
		
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClientes.setBounds(261, 29, 147, 108);
		
		btnRepararVehvulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRepararVehvulo.setBounds(261, 167, 147, 108);
		
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtrs.setBounds(261, 335, 147, 76);
		
		
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
		
		//MENU SUPERIOR
		//Boton leer
		mntmLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//Boton crear
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
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
