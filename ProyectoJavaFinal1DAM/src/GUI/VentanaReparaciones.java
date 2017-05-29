package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.SwingConstants;

import controller.ControladorReparaciones;

import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaReparaciones {

	private JFrame frame;
	private JTextField txt_ID;
	private JTextField txt_fechaInicio;
	private JTextField txt_fechaFin;
	private JTextField txt_Propietario;
	private JTextField txt_mecanico;
	private JTextField txt_presupuesto;
	private JTextField textField_euro;
	private JButton btn_atras;
	private ControladorReparaciones controladorReparaciones;
	private JLabel lblIDReparacion;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFin;
	private JLabel lblCliente;
	private JLabel lblMecnico;
	private JLabel lblPresupuesto;
	private JLabel lblOrdenarPor;
	private JLabel lblEstado;
	private JLabel lblComentarios;
	private JComboBox cBox_ordenar;
	private JComboBox cBox_estado;
	private JTextArea txt_comentario;
	private JButton btn_guardar;
	


	/**
	 * Create the application.
	 */
	public VentanaReparaciones(ControladorReparaciones controladorReparaciones) {
		this.controladorReparaciones = controladorReparaciones;
		componentsInitializers();
		componentsProperties();
		componentsAdders();
		adaptadores();
		
		
	}

	/**
	 * Inicializa tods los componentes del frame y el mismo frame
	 */
	private void componentsInitializers(){
		frame = new JFrame();
		lblIDReparacion = new JLabel("ID. Reparaci\u00F3n:");
		lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaFin = new JLabel("Fecha Fin:");
		lblCliente = new JLabel("Propietario:");
		lblMecnico = new JLabel("Mec\u00E1nico:");
		lblPresupuesto = new JLabel("Presupuesto:");
		lblOrdenarPor = new JLabel("Ordenar por:");
		lblEstado = new JLabel("Estado:");
		lblComentarios = new JLabel("Comentarios:");
		txt_ID = new JTextField();
		txt_fechaInicio = new JTextField();
		txt_fechaFin = new JTextField();
		txt_Propietario = new JTextField();
		txt_mecanico = new JTextField();
		txt_presupuesto = new JTextField();
		textField_euro = new JTextField();
		cBox_ordenar = new JComboBox();
		cBox_estado = new JComboBox();
		txt_comentario = new JTextArea();
		btn_guardar = new JButton("GUARDAR");
		btn_atras = new JButton("ATRAS");
	}

	/**
	 * Añade al frame todos sus componentes
	 */
	private void componentsAdders(){
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIDReparacion);
		frame.getContentPane().add(lblFechaInicio);
		frame.getContentPane().add(lblFechaFin);
		frame.getContentPane().add(lblCliente);
		frame.getContentPane().add(lblMecnico);
		frame.getContentPane().add(lblPresupuesto);
		frame.getContentPane().add(lblOrdenarPor);
		frame.getContentPane().add(lblEstado);
		frame.getContentPane().add(lblComentarios);
		frame.getContentPane().add(txt_ID);
		frame.getContentPane().add(txt_fechaInicio);
		frame.getContentPane().add(txt_Propietario);
		frame.getContentPane().add(txt_fechaFin);
		frame.getContentPane().add(txt_mecanico);
		frame.getContentPane().add(txt_presupuesto);
		frame.getContentPane().add(textField_euro);
		frame.getContentPane().add(cBox_ordenar);
		frame.getContentPane().add(cBox_estado);
		frame.getContentPane().add(txt_comentario);
		frame.getContentPane().add(btn_guardar);
		frame.getContentPane().add(btn_atras);
	}
	
	/**
	 * Define las propiedades de los componentes del frame
	 */
	private void componentsProperties(){
		frame.setTitle("Parte de reparaci\u00F3n");
		frame.setBounds(100, 100, 485, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		lblIDReparacion.setBounds(27, 24, 97, 24);
		
		lblFechaInicio.setBounds(27, 74, 76, 14);
		
		lblFechaFin.setBounds(27, 114, 76, 14);
		
		lblCliente.setBounds(27, 155, 76, 14);
		
		lblMecnico.setBounds(27, 197, 60, 14);
		
		lblPresupuesto.setBounds(27, 236, 76, 14);
		
		lblOrdenarPor.setBounds(266, 29, 76, 14);
		
		lblEstado.setBounds(266, 96, 76, 14);
		
		lblComentarios.setBounds(266, 155, 76, 14);
		
		txt_ID.setEditable(false);
		txt_ID.setBounds(114, 24, 116, 24);
		
		txt_ID.setColumns(10);
		
		txt_fechaInicio.setColumns(10);
		txt_fechaInicio.setBounds(113, 69, 117, 24);
		
		txt_fechaFin.setColumns(10);
		txt_fechaFin.setBounds(113, 111, 117, 24);
		
		txt_Propietario.setColumns(10);
		txt_Propietario.setBounds(113, 152, 117, 24);
		
		txt_mecanico.setColumns(10);
		txt_mecanico.setBounds(113, 194, 117, 24);
		
		txt_presupuesto.setColumns(10);
		txt_presupuesto.setBounds(113, 233, 86, 24);
		
		textField_euro.setHorizontalAlignment(SwingConstants.CENTER);
		textField_euro.setForeground(Color.BLACK);
		textField_euro.setEditable(false);
		textField_euro.setText("\u20AC");
		textField_euro.setBounds(199, 233, 31, 24);
		
		textField_euro.setColumns(10);
		
		cBox_ordenar.setModel(new DefaultComboBoxModel(new String[] {"Fecha", "Nombre", "Presupuesto"}));
		cBox_ordenar.setBounds(352, 26, 97, 20);
		
		cBox_estado.setModel(new DefaultComboBoxModel(new String[] {"Reparado", "Pendiente", "No reparado"}));
		cBox_estado.setBounds(352, 93, 97, 20);
		
		txt_comentario.setLineWrap(true);
		txt_comentario.setBounds(266, 180, 183, 159);
		
		btn_guardar.setBounds(27, 277, 97, 62);
		
		btn_atras.setBounds(134, 277, 96, 62);
	}
	
	//Ocultar y mostrar
	public void mostrarVentana(){
		frame.setVisible(true);
	}
	
	public void ocultarVentana(){
		frame.setVisible(false);
	}

	
	
	/**
	 * Contiene los listeners
	 */
	private void adaptadores() {
		
		btn_atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorReparaciones.pulsarAtras();
			}
		});
	}
}
