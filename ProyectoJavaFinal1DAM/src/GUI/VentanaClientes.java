package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorCliente;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nif;
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_direccion;
	private JTextField txt_telefono;
	private JTextField txt_email;
	private JMenuBar menuBar;
	private JMenu mn_modo;
	private JMenuItem mntm_lectura;
	private JMenuItem mntm_escritura;
	private JPanel panel;
	private JLabel lb_clientes;
	private JLabel lb_nif;
	private JLabel lb_nombre;
	private JLabel lb_apellidos;
	private JSeparator separator;
	private JLabel lb_direccion;
	private JLabel lb_telefono;
	private JLabel lb_email;
	private JPanel panel_botones;
	private JButton btn_crear;
	private JButton btnAtrs;
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
		setVisible(true);
	}
	
	public void ocultarVentana(){
		setVisible(false);
	}

	private void setUpFrame() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
	}

	private void setUpComponents() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mn_modo = new JMenu("Modo");
		mntm_lectura = new JMenuItem("Lectura");
		mntm_escritura = new JMenuItem("Escritura");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel = new JPanel();
		panel.setLayout(null);
		lb_clientes = new JLabel("Clientes");
		lb_clientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_clientes.setBounds(10, 11, 72, 22);
		lb_nif = new JLabel("NIF:");
		lb_nif.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_nif.setBounds(10, 54, 56, 14);
		txt_nif = new JTextField();
		txt_nif.setBounds(76, 51, 111, 20);
		txt_nif.setColumns(10);
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(76, 79, 111, 20);
		lb_nombre = new JLabel("Nombre:");
		lb_nombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_nombre.setBounds(10, 79, 56, 14);
		txt_apellidos = new JTextField();
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(76, 110, 111, 20);
		lb_apellidos = new JLabel("Apellidos:");
		lb_apellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_apellidos.setBounds(10, 113, 56, 14);
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(200, 54, 2, 76);
		txt_direccion = new JTextField();
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(281, 51, 133, 20);
		lb_direccion = new JLabel("Direccion:");
		lb_direccion.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_direccion.setBounds(207, 54, 64, 14);
		lb_telefono = new JLabel("Telefono:");
		lb_telefono.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_telefono.setBounds(207, 82, 64, 14);
		txt_telefono = new JTextField();
		txt_telefono.setColumns(10);
		txt_telefono.setBounds(281, 79, 133, 20);
		lb_email = new JLabel("Email:");
		lb_email.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_email.setBounds(207, 113, 64, 14);
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(281, 110, 133, 20);
		panel_botones = new JPanel();
		panel_botones.setBackground(Color.LIGHT_GRAY);
		panel_botones.setBounds(10, 143, 404, 76);
		panel_botones.setLayout(new GridLayout(0, 2, 0, 0));
		btn_crear = new JButton("Crear");
		btn_crear.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 22));
	}

	private void addComponents() {
		menuBar.add(mn_modo);
		mn_modo.add(mntm_lectura);
		mn_modo.add(mntm_escritura);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.add(lb_clientes);
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
		panel_botones.add(btn_crear);
		panel_botones.add(btnAtrs);
	}

	private void addAdapters() {
		//Boton Crear
		btn_crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		
		//Boton Atras
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorCliente.pulsarAtras();
			}
		});
		
		//Boton Menu modo:lectura
		mntm_lectura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//Boton Menu modo:escritura
		mntm_escritura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
