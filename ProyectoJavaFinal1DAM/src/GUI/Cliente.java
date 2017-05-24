package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nif;
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_direccion;
	private JTextField txt_telefono;
	private JTextField txt_email;
	private JPanel panel;
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

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setUpFrame();
		setUpComponents();
		addComponents();
		addAdapters();

	}

	private void setUpFrame() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 252);
		setVisible(true);
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
		lb_nif.setBounds(13, 14, 56, 14);
		txt_nif = new JTextField();
		txt_nif.setBounds(79, 11, 111, 20);
		txt_nif.setColumns(10);
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(79, 39, 111, 20);
		lb_nombre = new JLabel("Nombre:");
		lb_nombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_nombre.setBounds(13, 42, 56, 14);
		txt_apellidos = new JTextField();
		txt_apellidos.setColumns(10);
		txt_apellidos.setBounds(79, 70, 111, 20);
		lb_apellidos = new JLabel("Apellidos:");
		lb_apellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_apellidos.setBounds(13, 73, 56, 14);
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(222, 14, 2, 76);
		txt_direccion = new JTextField();
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(303, 11, 133, 20);
		lb_direccion = new JLabel("Direccion:");
		lb_direccion.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_direccion.setBounds(229, 14, 64, 14);
		lb_telefono = new JLabel("Telefono:");
		lb_telefono.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_telefono.setBounds(212, 42, 81, 14);
		txt_telefono = new JTextField();
		txt_telefono.setColumns(10);
		txt_telefono.setBounds(303, 39, 133, 20);
		lb_email = new JLabel("Email:");
		lb_email.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_email.setBounds(229, 73, 64, 14);
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(303, 70, 133, 20);
		panel_botones = new JPanel();
		panel_botones.setBackground(Color.LIGHT_GRAY);
		panel_botones.setBounds(13, 114, 423, 76);
		panel_botones.setLayout(new GridLayout(0, 2, 0, 0));
		btn_crear = new JButton("Crear");
		panel_botones.add(btn_crear);
		btn_crear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtrs = new JButton("Atr\u00E1s");
		panel_botones.add(btnAtrs);
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
			}
		});
	}
}
