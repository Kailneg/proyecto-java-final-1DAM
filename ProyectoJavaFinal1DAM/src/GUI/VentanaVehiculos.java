package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import contenedores.ContenedorPrincipal;
import controller.ControladorVehiculos;
import enums.EstadoReparacion;
import enums.Meses;
import globals.Constantes;
import models.Vehiculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import enums.TipoCombustible;
import enums.TipoVehiculo;
import javax.swing.ImageIcon;

public class VentanaVehiculos {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Integer dias[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24, 25, 26, 27, 28, 29, 30, 31 };
	private final Integer anios[] = { 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005,
			2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990 };

	private JFrame frmVehiculos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblModelo;
	private JLabel lblPuertas;
	private JRadioButton rb_3puertas, rb_5puertas, rb_2puertas;
	private JLabel lblAnioMatriculacion;
	private JLabel lblCaballos;
	private JLabel lblTipoCombustible;
	private JButton btnClientes;
	private JButton btnRepararVehvulo;
	private JButton btnAtrs;
	private JLabel labelContadorVehiculos, lblTipoVehiculo;
	private JButton buttonLeftArrow;
	private JButton buttonRightArrow;
	private JButton btnGuardar;
	private JTextField lbl_cv;
	private JTextField txt_marca;
	private JTextField txt_matricula;
	private JTextField txt_modelo;
	private JTextField txt_potencia;
	private JComboBox<Integer> cbox_dia, cbox_mes, cbox_ano, cbTipoCombustible, cb_TipoVehiculo;
	private JButton btnBorrarVehiculo;
	private ControladorVehiculos controladorVehiculos;
	private JLabel lblCamposObligatorios;
	private JLabel lblNifCliente;
	private JComboBox cb_nifCliente;
	private JButton btnRefrescarnifs;

	/**
	 * Create the application.
	 */
	public VentanaVehiculos(ControladorVehiculos controladorVehiculos) {
		this.controladorVehiculos = controladorVehiculos;
		vehiculoComponents();
	}

	// GETTERS

	/**
	 * Devuelve el contenido del atributo TipoCombustible.
	 * 
	 * @return atributo TipoCombustible de ventanaVehiculos
	 */
	public TipoCombustible getTipoCombustible() {
		return TipoCombustible.valueOf(cbTipoCombustible.getSelectedItem().toString());
	}

	/**
	 * Devuelve el contenido del atributo TipoVehiculo.
	 * 
	 * @return atributo TipoVehiculo de ventanaVehiculos
	 */
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.valueOf(cb_TipoVehiculo.getSelectedItem().toString());
	}

	/**
	 * Devuelve el contenido del atributo puertas.
	 * 
	 * @return atributo puertas de ventanaVehiculos
	 */
	public String getPuertas() {
		return (rb_3puertas.isSelected() ? "3" : "5");
	}

	/**
	 * Devuelve el contenido del atributo marca.
	 * 
	 * @return atributo marca de ventanaVehiculos
	 */
	public String getTxt_marca() {
		return txt_marca.getText();
	}

	/**
	 * Devuelve el contenido del atributo modelo.
	 * 
	 * @return atributo modelo de ventanaVehiculos
	 */
	public String getTxt_modelo() {
		return txt_modelo.getText();
	}

	/**
	 * Devuelve el contenido del atributo FechaMatriculacion.
	 * 
	 * @return atributo FechaMatriculacion de ventanaVehiculos
	 */
	public Calendar getFechaMatriculacion() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(cbox_ano.getSelectedItem().toString()), cbox_mes.getSelectedIndex(),
				Integer.parseInt(cbox_dia.getSelectedItem().toString()));
		return c;
	}

	/**
	 * Devuelve el NIF seleccionado.
	 * 
	 * @return atributo matricula de ventanaVehiculos
	 */
	public String getTxt_N() {
		return cb_nifCliente.getSelectedItem().toString();
	}

	/**
	 * Devuelve el contenido del atributo matricula.
	 * 
	 * @return atributo matricula de ventanaVehiculos
	 */
	public String getTxt_matricula() {
		return txt_matricula.getText();
	}

	/**
	 * Devuelve el contenido del atributo potencia.
	 * 
	 * @return atributo potencia de ventanaVehiculos
	 */
	public String getTxt_potencia() {
		return txt_potencia.getText();
	}

	// SETTERS
	/**
	 * Asigna al atributo matricula el parámetro
	 * 
	 * @param s
	 *            la matricula que se quiere asignar
	 */
	public void setMatricula(String s) {
		txt_matricula.setText(s);
	}

	/**
	 * Asigna al atributo potencia el parámetro
	 * 
	 * @param s
	 *            la potencia que se quiere asignar
	 */
	public void setPotencia(String s) {
		txt_potencia.setText(s);
	}

	/**
	 * Asigna al atributo marca el parámetro
	 * 
	 * @param s
	 *            la marca que se quiere asignar
	 */
	public void setMarca(String s) {
		txt_marca.setText(s);
	}

	/**
	 * Asigna al atributo modelo el parámetro
	 * 
	 * @param s
	 *            el modelo que se quiere asignar
	 */
	public void setModelo(String s) {
		txt_modelo.setText(s);
	}

	/**
	 * Asigna al atributo puertas el parámetro
	 * 
	 * @param s
	 *            las puertas que se quieren asignar dependiendo de la seleccion
	 */
	public void setPuertas(String s) {
		if (s.equals("0")) {
			rb_3puertas.setSelected(true);
		}
		if (s.equals("2")) {
			rb_2puertas.setSelected(true);
		}
		if (s.equals("3")) {
			rb_3puertas.setSelected(true);
		}
		if (s.equals("5")) {
			rb_5puertas.setSelected(true);
		}
	}

	/**
	 * Asigna al atributo ContadorVehiculos el parámetro
	 * 
	 * @param s
	 *            el ContadorVehiculos que se quiere asignar
	 */
	public void setCantidadVehiculos(String e) {
		labelContadorVehiculos.setText(e);
	}

	/**
	 * Asigna al atributo TipoVehiculo el parámetro
	 * 
	 * @param s
	 *            el TipoVehiculo que se quiere asignar
	 */
	public void setTipoVehiculo(TipoVehiculo t) {
		cb_TipoVehiculo.setSelectedItem(t);
	}

	/**
	 * Asigna al atributo TipoCombustible el parámetro
	 * 
	 * @param s
	 *            el TipoCombustible que se quiere asignar
	 */
	public void setTipoCombustible(TipoCombustible t) {
		cbTipoCombustible.setSelectedItem(t);
	}

	// Ocultar y mostrar
	public void mostrarVentana() {
		hideComponents(Constantes.MODO_CREAR);
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
		lblNewLabel = new JLabel("* Matricula:");
		lblNewLabel_1 = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblPuertas = new JLabel("* Puertas:");
		rb_2puertas = new JRadioButton("2");
		buttonGroup.add(rb_2puertas);
		rb_3puertas = new JRadioButton("3");
		buttonGroup.add(rb_3puertas);
		rb_3puertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rb_5puertas = new JRadioButton("5");
		buttonGroup.add(rb_5puertas);
		rb_5puertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnioMatriculacion = new JLabel("Matriculaci\u00F3n:");
		lblCaballos = new JLabel("* Potencia:");
		lblTipoCombustible = new JLabel("Combustible:");
		btnClientes = new JButton("Clientes");
		btnRepararVehvulo = new JButton("Reparar Veh\u00EDvulo");
		btnAtrs = new JButton("Atras");
		labelContadorVehiculos = new JLabel("0/0");
		buttonLeftArrow = new JButton("<");
		buttonRightArrow = new JButton(">");
		btnGuardar = new JButton("A\u00F1adir");
		lbl_cv = new JTextField();
		lbl_cv.setEditable(false);
		txt_marca = new JTextField();
		txt_matricula = new JTextField();
		txt_modelo = new JTextField();
		txt_potencia = new JTextField();
		cbox_dia = new JComboBox<Integer>();
		cbox_mes = new JComboBox<Integer>();
		cbox_ano = new JComboBox<Integer>();
		btnBorrarVehiculo = new JButton("Borrar Vehiculo");
		cbTipoCombustible = new JComboBox<Integer>();
		lblTipoVehiculo = new JLabel("Tipo Vehiculo");
		cb_TipoVehiculo = new JComboBox<Integer>();
		cb_TipoVehiculo.setEnabled(false);
		lblCamposObligatorios = new JLabel("* Campos obligatorios");
		lblNifCliente = new JLabel("* NIF cliente:");
		cb_nifCliente = new JComboBox();
		btnRefrescarnifs = new JButton("");
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
		frmVehiculos.getContentPane().add(lblAnioMatriculacion);
		frmVehiculos.getContentPane().add(lblCaballos);
		frmVehiculos.getContentPane().add(lblTipoCombustible);
		frmVehiculos.getContentPane().add(btnClientes);
		frmVehiculos.getContentPane().add(btnRepararVehvulo);
		frmVehiculos.getContentPane().add(btnAtrs);
		frmVehiculos.getContentPane().setLayout(null);
		frmVehiculos.getContentPane().add(labelContadorVehiculos);
		frmVehiculos.getContentPane().add(buttonLeftArrow);
		frmVehiculos.getContentPane().add(buttonRightArrow);
		frmVehiculos.getContentPane().add(btnGuardar);
		frmVehiculos.getContentPane().add(lbl_cv);
		frmVehiculos.getContentPane().add(txt_marca);
		frmVehiculos.getContentPane().add(txt_matricula);
		frmVehiculos.getContentPane().add(txt_modelo);
		frmVehiculos.getContentPane().add(txt_potencia);
		frmVehiculos.getContentPane().add(cbox_dia);
		frmVehiculos.getContentPane().add(cbox_mes);
		frmVehiculos.getContentPane().add(cbox_ano);
		frmVehiculos.getContentPane().add(cbTipoCombustible);
		frmVehiculos.getContentPane().add(lblTipoVehiculo);
		frmVehiculos.getContentPane().add(cb_TipoVehiculo);
		frmVehiculos.getContentPane().add(btnBorrarVehiculo);
		frmVehiculos.getContentPane().add(rb_2puertas);
		frmVehiculos.getContentPane().add(lblCamposObligatorios);
		frmVehiculos.getContentPane().add(lblNifCliente);
		frmVehiculos.getContentPane().add(cb_nifCliente);
		frmVehiculos.getContentPane().add(btnRefrescarnifs);
	}

	/**
	 * Contiene las propiedades de todos los componentes del frame
	 */
	private void componentsProperties() {
		frmVehiculos.setBounds(100, 100, 450, 550);
		frmVehiculos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(37, 53, 64, 19);

		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(37, 86, 53, 19);

		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblModelo.setBounds(37, 116, 64, 19);

		lblPuertas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPuertas.setBounds(37, 151, 64, 14);
		rb_3puertas.setBounds(160, 145, 38, 23);
		rb_5puertas.setBounds(200, 145, 38, 23);

		lblAnioMatriculacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAnioMatriculacion.setBounds(37, 215, 98, 14);

		lblCaballos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCaballos.setBounds(37, 310, 64, 14);

		lblTipoCombustible.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoCombustible.setBounds(37, 348, 73, 14);

		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClientes.setBounds(262, 12, 147, 108);

		btnRepararVehvulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRepararVehvulo.setBounds(262, 139, 147, 108);

		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtrs.setBounds(262, 416, 147, 94);

		labelContadorVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContadorVehiculos.setBounds(120, 423, 38, 23);

		buttonLeftArrow.setBounds(37, 417, 53, 93);

		buttonRightArrow.setBounds(185, 417, 53, 93);

		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGuardar.setBounds(88, 448, 98, 62);

		lbl_cv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_cv.setText("CV");
		lbl_cv.setBounds(208, 307, 30, 24);
		lbl_cv.setColumns(10);

		txt_marca.setColumns(10);
		txt_marca.setBounds(120, 83, 118, 24);

		txt_matricula.setColumns(10);
		txt_matricula.setBounds(120, 52, 118, 24);

		txt_modelo.setColumns(10);
		txt_modelo.setBounds(120, 115, 118, 24);

		txt_potencia.setColumns(10);
		txt_potencia.setBounds(120, 307, 89, 24);

		cbox_dia.setModel(new DefaultComboBoxModel<Integer>(dias));
		cbox_dia.setBounds(120, 212, 118, 20);

		cbox_mes.setModel(new DefaultComboBoxModel(Meses.values()));
		cbox_mes.setBounds(120, 242, 118, 20);

		cbox_ano.setModel(new DefaultComboBoxModel<Integer>(anios));
		cbox_ano.setBounds(120, 274, 118, 20);

		cbTipoCombustible.setModel(new DefaultComboBoxModel(TipoCombustible.values()));
		cbTipoCombustible.setBounds(120, 343, 118, 20);

		lblTipoVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoVehiculo.setBounds(37, 179, 69, 20);

		cb_TipoVehiculo.setModel(new DefaultComboBoxModel(TipoVehiculo.values()));
		cb_TipoVehiculo.setBounds(120, 179, 118, 20);

		btnBorrarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBorrarVehiculo.setBounds(262, 279, 147, 108);

		rb_2puertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rb_2puertas.setBounds(122, 145, 36, 23);

		lblCamposObligatorios.setBounds(37, 373, 105, 14);

		lblNifCliente.setBounds(37, 28, 73, 14);

		cb_nifCliente.setBounds(120, 26, 95, 21);
		cb_nifCliente.setModel(new DefaultComboBoxModel(ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().getNifs()));


		btnRefrescarnifs.setIcon(
				new ImageIcon(VentanaVehiculos.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnRefrescarnifs.setBounds(214, 25, 25, 23);
	}

	private void hideComponents(boolean b) {
		txt_marca.setEnabled(b);
		txt_matricula.setEnabled(b);
		txt_modelo.setEnabled(b);
		rb_2puertas.setEnabled(b);
		rb_3puertas.setEnabled(b);
		rb_5puertas.setEnabled(b);
		cbox_ano.setEnabled(b);
		txt_potencia.setEnabled(b);
		cbox_dia.setEnabled(b);
		cbox_mes.setEnabled(b);
		cbox_ano.setEnabled(b);
		cbTipoCombustible.setEnabled(b);
		btnGuardar.setVisible(b);
		btnBorrarVehiculo.setVisible(b);
		buttonLeftArrow.setEnabled(!b);
		buttonRightArrow.setEnabled(!b);
	}

	/**
	 * Contiene los eventos asociados al frame
	 */
	private void componentsListeners() {
		// NIFs
		btnRefrescarnifs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cb_nifCliente.setModel(new DefaultComboBoxModel(ContenedorPrincipal.getContenedorPrincipal().getContenedorClientes().getNifs()));
			}
		});

		// Clientes
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorVehiculos.pulsarClientes();
			}
		});

		// Reparaciones
		btnRepararVehvulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorVehiculos.pulsarReparaciones();
			}
		});
		// Anterior vehiculo
		buttonLeftArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Constantes.MODO_CREAR) {
					controladorVehiculos.pulsarLeftArrow();
				}
			}
		});
		// Siguiente vehiculo
		buttonRightArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Constantes.MODO_CREAR) {
					controladorVehiculos.pulsarRightArrow();
				}
			}
		});

		// Atras
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorVehiculos.pulsarAtras();
			}
		});
		// Guarda el vehiculo
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Constantes.MODO_CREAR) {
					try {
						controladorVehiculos.guardarVehiculo();
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Algo ha ido mal", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		// Borra el vehículo
		btnBorrarVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Constantes.MODO_CREAR) {
					controladorVehiculos.pulsarBorrarVehiculo();
				}
			}
		});
	}
}
