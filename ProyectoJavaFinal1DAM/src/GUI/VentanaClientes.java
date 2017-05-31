package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorCliente;
import globals.Constantes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaClientes extends JFrame {

	private JPanel contentPane;

	private JTextField txt_nif, txt_nombre, txt_apellidos, txt_direccion, txt_telefono, txt_email;
	private JPanel panel, panel_botones;
	private JLabel lb_nif, lb_nombre, lb_apellidos, lb_direccion, lb_telefono;
	private JButton btnLeftArrow, btnRightArrow;
	private JSeparator separator;
	private JLabel lb_email;
	private JButton btn_crear, btnAtrs;
	private ControladorCliente controladorCliente;
	private JButton btnBorrarCliente;

	/**
	 * Create the frame.
	 */
	public VentanaClientes(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
		setUpFrame();
		setUpComponents();
		addComponents();
		addAdapters();
	}

	/**
	 * Muestra la ventana 
	 */
	public void mostrarVentana() {
		hideComponents(Constantes.MODO_CREAR);
		setVisible(true);
	}

	/**
	 * Oculta la ventana
	 */
	public void ocultarVentana() {
		setVisible(false);
	}

	// GETTERS
	/**
	 * Devuelve el contenido del atributo NIF.
	 * @return atributo nif de VentanaCliente
	 */
	public String getNIF() {
		return txt_nif.getText();
	}
	/**
	 * Devuelve el contenido del atributo nombre.
	 * @return atributo nombre de VentanaCliente
	 */
	public String getNombre() {
		return txt_nombre.getText();
	}
	/**
	 * Devuelve el contenido del atributo Apellidos.
	 * @return atributo apellidos de VentanaCliente
	 */
	public String getApellidos() {
		return txt_apellidos.getText();
	}
	/**
	 * Devuelve el contenido del atributo direccion.
	 * @return artibuto direccion de VentanaCliente
	 */
	public String getDireccion() {
		return txt_direccion.getText();
	}
	/**
	 * Devuelve el contenido del atributo telefono.
	 * @return atributo telefono de ventanaCliente
	 */
	public long getTelefono() {
		return Long.parseLong(txt_telefono.getText());
	}
	/**
	 * Devuelve el contenido del atributo email.
	 * @return atributo email de VentanaCliente
	 */
	public String getEmail() {
		return txt_email.getText();
	}
	
	//SETTERS
	/**
	 * Asigna al atributo apellidos el parámetro
	 * @param s el apellido que se quiere asignar
	 */
	public void setApellidos(String s) {
		txt_apellidos.setText(s);
	}
	/**
	 * Asigna al atributo nombre el parámetro
	 * @param s el nombre que se quiere asignar
	 */
	public void setNombre(String s){
		txt_nombre.setText(s);
	}
	/**
	 * Asigna al atributo direccion el parámetro
	 * @param s la direccion que se quiere asignar
	 */
	public void setDireccion(String s) {
		txt_direccion.setText(s);
	}
	/**
	 * Asigna al atributo nif el parámetro
	 * @param s el nif que se quiere asignar
	 */
	public void setNIF(String s) {
		txt_nif.setText(s);
	}
	/**
	 * Asigna al atributo email el parámetro
	 * @param s el email que se quiere asignar
	 */
	public void setEmail(String s) {
		txt_email.setText(s);
	}
	/**
	 * Asigna al atributo telefono el parámetro
	 * @param s el telefono que se quiere asignar
	 */
	public void setTelefono(String s) {
		txt_telefono.setText(s);
	}
	
	//METODOS
	/**
	 * Propiedades de la ventana Frame
	 */
	private void setUpFrame() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 277);
		setVisible(true);
		setResizable(false);
	}
	/**
	 * Instanciacion de todos los componentes de la ventana
	 */
	private void setUpComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel = new JPanel();
		panel.setLayout(null);
		lb_nif = new JLabel("NIF:");
		lb_nif.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_nif.setBounds(10, 31, 56, 14);
		txt_nif = new JTextField();
		txt_nif.setBounds(76, 28, 111, 20);
		txt_nif.setColumns(10);
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(76, 59, 111, 20);
		lb_nombre = new JLabel("Nombre:");
		lb_nombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_nombre.setBounds(10, 62, 56, 14);
		txt_apellidos = new JTextField();
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(76, 87, 111, 20);
		lb_apellidos = new JLabel("Apellidos:");
		lb_apellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_apellidos.setBounds(10, 90, 56, 14);
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(202, 31, 2, 76);
		txt_direccion = new JTextField();
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(291, 28, 126, 20);
		lb_direccion = new JLabel("Direccion:");
		lb_direccion.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_direccion.setBounds(217, 31, 64, 14);
		lb_telefono = new JLabel("Telefono:");
		lb_telefono.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_telefono.setBounds(217, 62, 64, 14);
		txt_telefono = new JTextField();
		txt_telefono.setColumns(10);
		txt_telefono.setBounds(291, 59, 126, 20);
		lb_email = new JLabel("Email:");
		lb_email.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_email.setBounds(217, 90, 64, 14);
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(291, 87, 126, 20);
		panel_botones = new JPanel();
		panel_botones.setBackground(Color.LIGHT_GRAY);
		panel_botones.setBounds(20, 141, 294, 76);
		panel_botones.setLayout(new GridLayout(0, 2, 0, 0));
		btn_crear = new JButton("Crear");
		panel_botones.add(btn_crear);
		btn_crear.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAtrs = new JButton("Atr\u00E1s");
		panel_botones.add(btnAtrs);
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnLeftArrow = new JButton("<");
		panel_botones.add(btnLeftArrow);
		btnRightArrow = new JButton(">");
		panel_botones.add(btnRightArrow);
		btnBorrarCliente = new JButton("Borrar");
		btnBorrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBorrarCliente.setBounds(324, 141, 93, 76);
	}
	/**
	 * Añade todos los componentes a la ventana
	 */
	private void addComponents() {
		contentPane.add(panel, BorderLayout.CENTER);
		panel.add(lb_nif);
		panel.add(txt_nif);
		panel.add(txt_nombre);
		panel.add(lb_nombre);
		panel.add(txt_apellidos);
		panel.add(lb_apellidos);
		panel.add(separator);
		panel.add(txt_direccion);
		panel.add(lb_direccion);
		panel.add(lb_telefono);
		panel.add(txt_telefono);
		panel.add(lb_email);
		panel.add(txt_email);
		panel.add(panel_botones);
		panel.add(btnBorrarCliente);
	}
	/**
	 * Oculta los componentes de la ventana
	 * @param b booleano que indica si se ocultan o no
	 */
	private void hideComponents(boolean b) {
		txt_nif.setEnabled(b);
		txt_nombre.setEnabled(b);
		txt_apellidos.setEnabled(b);
		txt_direccion.setEnabled(b);
		txt_telefono.setEnabled(b);
		txt_email.setEnabled(b);
		panel_botones.setEnabled(b);
		btn_crear.setEnabled(b);
		btnLeftArrow.setEnabled(!b);
		btnRightArrow.setEnabled(!b);

		if (!b) {
			btnBorrarCliente.setVisible(false);
			panel_botones.setBounds(20, 141, 397, 76);
		} else {
			btnBorrarCliente.setVisible(true);
			panel_botones.setBounds(20, 141, 294, 76);
		}
	}
	/**
	 * Funcionalidad de los diferentes botones de la ventana
	 */
	private void addAdapters() {
		// Boton Crear
		btn_crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Constantes.MODO_CREAR) {
					if (controladorCliente.guardarCliente() == null) {
						JOptionPane.showMessageDialog(null, "Error al crear al nuevo cliente", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Añadido cliente numero " + controladorCliente.getNumeroClientes(), "Hecho!",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// Boton Atras
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorCliente.pulsarAtras();
			}
		});

		btnLeftArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!Constantes.MODO_CREAR) {
					controladorCliente.pulsarLeftArrow();
				}
			}
		});

		btnRightArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!Constantes.MODO_CREAR) {
					controladorCliente.pulsarRightArrow();
				}
			}
		});

		btnBorrarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Constantes.MODO_CREAR) {
					controladorCliente.pulsarBorrarCliente();
				}
			}
		});
	}
}
