package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.ControladorVehiculos;
import enums.Meses;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaVehiculos {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Integer dias[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24, 25, 26, 27, 28, 29, 30, 31 };
	private final Integer anios[] = { 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005,
			2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990 };
	private final String tiposCombustible[] = {"Diesel", "Electrico", "Gasolina", "GLP", "Hibrido"};

	private JFrame frmVehiculos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblModelo;
	private JLabel lblPuertas;
	private JRadioButton rb_3puertas;
	private JRadioButton rb_5puertas;
	private JLabel lblAoMatriculacin;
	private JLabel lblCaballos;
	private JLabel lblTipoCombustible;
	private JButton btnClientes;
	private JButton btnRepararVehvulo;
	private JButton btnAtrs;
	private JLabel labelContadorVehiculos;
	private JButton button;
	private JButton button_1;
	private JButton btnGuardar;
	private JTextField txt_cv;
	private JTextField txt_marca;
	private JTextField txt_matricula;
	private JTextField txt_modelo;
	private JTextField txt_potencia;
	private JComboBox cbox_dia, cbox_mes, cbox_ano, cbTipoCombustible;
	private ControladorVehiculos controladorVehiculos;

	/**
	 * Create the application.
	 */
	public VentanaVehiculos(ControladorVehiculos controladorVehiculos) {
		this.controladorVehiculos = controladorVehiculos;
		vehiculoComponents();
	}

	public int getTipoCombustible() {
		return cbTipoCombustible.getSelectedIndex();
	}

	public String getPuertas() {
		return (rb_3puertas.isSelected() ? "3" : "5");
	}
	
	public String getLblModelo() {
		return lblModelo.getText();
	}

	public String getTxt_marca() {
		return txt_marca.getText();
	}

	public String getTxt_matricula() {
		return txt_matricula.getText();
	}

	public String getTxt_potencia() {
		return txt_potencia.getText();
	}

	// Ocultar y mostrar
	public void mostrarVentana(boolean modoLectura) {
		hideComponents(!modoLectura);
		frmVehiculos.setVisible(true);
	}

	public void ocultarVentana() {
		frmVehiculos.setVisible(false);
	}

	/**
	 * Llama a los métodos encargados de inicializar, añadir y definir los
	 * componentes del frame
	 */
	private void vehiculoComponents() {
		componentsInitializers();
		componentsAdders();
		componentsProperties();
		componentsListeners();
	}
	
	/**
	 * Inicializa el contenido del frame.
	 */
	private void componentsInitializers() {
		frmVehiculos = new JFrame();
		frmVehiculos.setTitle("Vehiculos");
		lblNewLabel = new JLabel("Matricula:");
		lblNewLabel_1 = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblPuertas = new JLabel("Puertas:");
		rb_3puertas = new JRadioButton("3");
		rb_3puertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rb_5puertas = new JRadioButton("5");
		rb_5puertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAoMatriculacin = new JLabel("Matriculaci\u00F3n:");
		lblCaballos = new JLabel("Potencia:");
		lblTipoCombustible = new JLabel("Combustible:");
		btnClientes = new JButton("Clientes");
		btnRepararVehvulo = new JButton("Reparar Veh\u00EDvulo");
		btnAtrs = new JButton("Atras");
		labelContadorVehiculos = new JLabel("0/0");
		button = new JButton("<");
		button_1 = new JButton(">");
		btnGuardar = new JButton("Guardar");
		txt_cv = new JTextField();
		txt_marca = new JTextField();
		txt_matricula = new JTextField();
		txt_modelo = new JTextField();
		txt_potencia = new JTextField();
		cbox_dia = new JComboBox();
		cbox_mes = new JComboBox();
		cbox_ano = new JComboBox();
		cbTipoCombustible = new JComboBox();

	}

	/**
	 * Añade al frame todos los componentes que hemos creado.
	 */
	private void componentsAdders() {
		frmVehiculos.setResizable(false);
		frmVehiculos.getContentPane().add(lblNewLabel);
		frmVehiculos.getContentPane().add(lblNewLabel_1);
		frmVehiculos.getContentPane().add(lblModelo);
		frmVehiculos.getContentPane().add(lblPuertas);
		frmVehiculos.getContentPane().add(rb_3puertas);
		frmVehiculos.getContentPane().add(rb_5puertas);
		frmVehiculos.getContentPane().add(lblAoMatriculacin);
		frmVehiculos.getContentPane().add(lblCaballos);
		frmVehiculos.getContentPane().add(lblTipoCombustible);
		frmVehiculos.getContentPane().add(btnClientes);
		frmVehiculos.getContentPane().add(btnRepararVehvulo);
		frmVehiculos.getContentPane().add(btnAtrs);
		frmVehiculos.getContentPane().setLayout(null);
		frmVehiculos.getContentPane().add(labelContadorVehiculos);
		frmVehiculos.getContentPane().add(button);
		frmVehiculos.getContentPane().add(button_1);
		frmVehiculos.getContentPane().add(btnGuardar);

		buttonGroup.add(rb_3puertas);
		buttonGroup.add(rb_5puertas);

		txt_cv.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_cv.setEditable(false);
		txt_cv.setText("CV");
		txt_cv.setBounds(208, 280, 30, 24);
		frmVehiculos.getContentPane().add(txt_cv);
		txt_cv.setColumns(10);

		txt_marca.setColumns(10);
		txt_marca.setBounds(120, 42, 118, 24);
		frmVehiculos.getContentPane().add(txt_marca);

		txt_matricula.setColumns(10);
		txt_matricula.setBounds(120, 11, 118, 24);
		frmVehiculos.getContentPane().add(txt_matricula);

		txt_modelo.setColumns(10);
		txt_modelo.setBounds(120, 74, 118, 24);
		frmVehiculos.getContentPane().add(txt_modelo);

		txt_potencia.setColumns(10);
		txt_potencia.setBounds(120, 280, 89, 24);
		frmVehiculos.getContentPane().add(txt_potencia);

		cbox_dia.setModel(new DefaultComboBoxModel(dias));
		cbox_dia.setBounds(120, 185, 118, 20);
		frmVehiculos.getContentPane().add(cbox_dia);

		cbox_mes.setModel(new DefaultComboBoxModel(Meses.values()));
		cbox_mes.setBounds(120, 215, 118, 20);
		frmVehiculos.getContentPane().add(cbox_mes);

		cbox_ano.setModel(new DefaultComboBoxModel<Integer>(anios));
		cbox_ano.setBounds(120, 247, 118, 20);
		frmVehiculos.getContentPane().add(cbox_ano);
		
		cbTipoCombustible.setModel(new DefaultComboBoxModel<String>(tiposCombustible));
		cbTipoCombustible.setBounds(120, 316, 118, 20);
		frmVehiculos.getContentPane().add(cbTipoCombustible);
	}

	/**
	 * Contiene las propiedades de todos los componentes del frame
	 */
	private void componentsProperties() {
		frmVehiculos.setBounds(100, 100, 450, 499);
		frmVehiculos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(37, 12, 64, 19);

		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(37, 45, 53, 19);

		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblModelo.setBounds(37, 75, 64, 19);

		lblPuertas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPuertas.setBounds(37, 138, 64, 14);

		rb_3puertas.setBounds(120, 132, 38, 23);
		rb_5puertas.setBounds(160, 132, 38, 23);

		lblAoMatriculacin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAoMatriculacin.setBounds(37, 188, 98, 14);

		lblCaballos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCaballos.setBounds(37, 283, 64, 14);

		lblTipoCombustible.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoCombustible.setBounds(37, 321, 73, 14);

		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClientes.setBounds(262, 12, 147, 108);

		btnRepararVehvulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRepararVehvulo.setBounds(262, 180, 147, 108);

		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtrs.setBounds(262, 386, 147, 76);

		labelContadorVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContadorVehiculos.setBounds(120, 375, 38, 23);

		button.setBounds(37, 369, 53, 93);

		button_1.setBounds(185, 369, 53, 93);

		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardar.setBounds(100, 409, 75, 53);

	}

	private void hideComponents(boolean b) {
		txt_marca.setEnabled(b);
		txt_matricula.setEnabled(b);
		txt_modelo.setEnabled(b);
		rb_3puertas.setEnabled(b);
		rb_5puertas.setEnabled(b);
		cbox_ano.setEnabled(b);
		txt_potencia.setEnabled(b);
		cbox_dia.setEnabled(b);
		cbox_mes.setEnabled(b);
		cbox_ano.setEnabled(b);
		cbTipoCombustible.setEnabled(b);
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
		
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorVehiculos.guardarVehiculo(
						txt_matricula.getText(), 
						txt_marca.getText(),
						txt_modelo.getText(), 
						(rb_3puertas.isSelected() ? "3" : "5"),
						cbox_ano.getSelectedItem().toString(),
						txt_potencia.getText()
						
					);
			}
		});
	}
}
