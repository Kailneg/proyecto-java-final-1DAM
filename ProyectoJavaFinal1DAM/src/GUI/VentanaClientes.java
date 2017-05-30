package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorCliente;
import globals.Constantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
	private JMenuBar menuBar;
	private JMenu mn_modo;
	private JMenuItem mntm_lectura, mntm_escritura;
	private JPanel panel, panel_botones;
	private JLabel lb_clientes, lb_nif, lb_nombre, lb_apellidos, lb_direccion, lb_telefono;
	private JButton btnLeftArrow, btnRightArrow;

	private JSeparator separator;
	private JLabel lb_email;
	private JButton btn_crear, btnAtrs;
	private ControladorCliente controladorCliente;

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
	
	//Ocultar y mostrar
	public void mostrarVentana(){
		hideComponents(Constantes.MODO_CREAR);
		setVisible(true);
	}
	
	public void ocultarVentana(){
		setVisible(false);
	}
	
	//Getters
//nombre, apellidos, direccion, telefono, email
	public String getNIF(){
		return txt_nif.getText();
	}
	
	public String getNombre(){
		return txt_nombre.getText();
	}
	
	public String getApellidos(){
		return txt_apellidos.getText();
	}
	
	public String getDireccion(){
		return txt_direccion.getText();
	}
	
	public long getTelefono(){
		return Long.parseLong(txt_telefono.getText());
	}
	
	public String getEmail(){
		return txt_email.getText();
	}

	private void setUpFrame() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 277);
		setVisible(true);
		setResizable(false);
	}

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
		panel_botones.setBounds(20, 141, 397, 76);
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
	}

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
	}
	
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
	}

	private void addAdapters() {
		//Boton Crear
		btn_crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Constantes.MODO_CREAR) {
					controladorCliente.pulsarCrear();	
				}
			}
		});
		
		//Boton Atras
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorCliente.pulsarAtras();
			}
		});
		
		// Moverte en la lista de clientes a la izq
		btnLeftArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		
		// Moverte en la lista de clientes a la derecha
		btnRightArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
	}
}
