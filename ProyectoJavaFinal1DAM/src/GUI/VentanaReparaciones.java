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
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import enums.Meses;
import java.awt.Font;

public class VentanaReparaciones {

	private final Integer dias[] = {1, 2, 3, 4 , 5, 6 ,7 ,8 ,9 ,10,
			11, 12, 13, 14, 15 , 16, 17 ,18 ,19, 20, 21, 22, 23, 24,
			25, 26, 27, 28, 29, 30, 31};
	private final Integer anios[] = {2017, 2016, 2015, 2014, 2013, 2012, 2011
			, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000
			, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990};
	
	private JFrame frame;
	private JTextField txt_ID;
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
	private JButton btn_crear;
	private JComboBox cb_anio_inicio;
	private JComboBox cb_dia_inicio;
	private JComboBox cb_mes_inicio;
	private JComboBox cb_dia_fin;
	private JComboBox cb_mes_fin;
	private JComboBox cb_anio_fin;
	


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
	
	//Getters
	//Ocultar y mostrar
	public void mostrarVentana(){
		frame.setVisible(true);
	}
	
	public void ocultarVentana(){
		frame.setVisible(false);
	}
	
	//Getters
	public int getIdReparacion(){
		return Integer.parseInt(txt_ID.getText());
	}
	
	public Calendar getFechaInicio(){
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(cb_anio_inicio.getSelectedItem().toString()), 
				cb_mes_inicio.getSelectedIndex(), 
				Integer.parseInt(cb_dia_inicio.getSelectedItem().toString()));
		return c;
	}
	
	public Calendar getFechaFin(){
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(cb_anio_fin.getSelectedItem().toString()), 
				cb_mes_fin.getSelectedIndex(), 
				Integer.parseInt(cb_dia_fin.getSelectedItem().toString()));
		return c;
	}

	public float getPresupuesto(){
		return Float.parseFloat(txt_presupuesto.getText());
	}
	
	public String getEstado(){
		return cBox_estado.getToolTipText();
	}
	
	public String getComentarios(){
		return txt_comentario.getText();
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
		txt_Propietario = new JTextField();
		txt_mecanico = new JTextField();
		txt_presupuesto = new JTextField();
		textField_euro = new JTextField();
		cBox_ordenar = new JComboBox();
		cBox_estado = new JComboBox();
		txt_comentario = new JTextArea();
		btn_crear = new JButton("Crear");
		btn_crear.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_atras = new JButton("Atras");
		btn_atras.setFont(new Font("Segoe UI", Font.BOLD, 18));
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
		frame.getContentPane().add(txt_Propietario);
		frame.getContentPane().add(txt_mecanico);
		frame.getContentPane().add(txt_presupuesto);
		frame.getContentPane().add(textField_euro);
		frame.getContentPane().add(cBox_ordenar);
		frame.getContentPane().add(cBox_estado);
		frame.getContentPane().add(txt_comentario);
		frame.getContentPane().add(btn_crear);
		frame.getContentPane().add(btn_atras);
		
		cb_dia_inicio = new JComboBox();
		cb_dia_inicio.setModel(new DefaultComboBoxModel(dias));
		cb_dia_inicio.setBounds(113, 71, 37, 20);
		frame.getContentPane().add(cb_dia_inicio);
		
		cb_mes_inicio = new JComboBox();
		cb_mes_inicio.setModel(new DefaultComboBoxModel(Meses.values()));
		cb_mes_inicio.setBounds(151, 71, 60, 20);
		frame.getContentPane().add(cb_mes_inicio);
		
		cb_anio_inicio = new JComboBox();
		cb_anio_inicio.setModel(new DefaultComboBoxModel(anios));
		cb_anio_inicio.setBounds(213, 71, 49, 20);
		frame.getContentPane().add(cb_anio_inicio);
		
		cb_dia_fin = new JComboBox();
		cb_dia_fin.setModel(new DefaultComboBoxModel(dias));
		cb_dia_fin.setBounds(113, 111, 37, 20);
		frame.getContentPane().add(cb_dia_fin);
		
		cb_mes_fin = new JComboBox();
		cb_mes_fin.setModel(new DefaultComboBoxModel(Meses.values()));
		cb_mes_fin.setBounds(151, 111, 60, 20);
		frame.getContentPane().add(cb_mes_fin);
		
		cb_anio_fin = new JComboBox();
		cb_anio_fin.setModel(new DefaultComboBoxModel(anios));
		cb_anio_fin.setBounds(213, 111, 49, 20);
		frame.getContentPane().add(cb_anio_fin);
	}
	
	/**
	 * Define las propiedades de los componentes del frame
	 */
	private void componentsProperties(){
		frame.setTitle("Parte de reparaci\u00F3n");
		frame.setBounds(100, 100, 500, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		lblIDReparacion.setBounds(27, 24, 97, 24);
		
		lblFechaInicio.setBounds(27, 74, 76, 14);
		
		lblFechaFin.setBounds(27, 114, 76, 14);
		
		lblCliente.setBounds(27, 155, 76, 14);
		
		lblMecnico.setBounds(27, 197, 60, 14);
		
		lblPresupuesto.setBounds(27, 236, 76, 14);
		
		lblOrdenarPor.setBounds(286, 29, 76, 14);
		
		lblEstado.setBounds(286, 96, 76, 14);
		
		lblComentarios.setBounds(286, 155, 76, 14);
		txt_ID.setBounds(113, 24, 149, 24);
		
		txt_ID.setColumns(10);
		
		txt_Propietario.setColumns(10);
		txt_Propietario.setBounds(113, 152, 149, 24);
		
		txt_mecanico.setColumns(10);
		txt_mecanico.setBounds(113, 194, 149, 24);
		
		txt_presupuesto.setColumns(10);
		txt_presupuesto.setBounds(113, 233, 117, 24);
		
		textField_euro.setHorizontalAlignment(SwingConstants.CENTER);
		textField_euro.setForeground(Color.BLACK);
		textField_euro.setEditable(false);
		textField_euro.setText("\u20AC");
		textField_euro.setBounds(231, 233, 31, 24);
		
		textField_euro.setColumns(10);
		
		cBox_ordenar.setModel(new DefaultComboBoxModel(new String[] {"Fecha", "Nombre", "Presupuesto"}));
		cBox_ordenar.setBounds(372, 26, 97, 20);
		
		cBox_estado.setModel(new DefaultComboBoxModel(new String[] {"Reparado", "Pendiente", "No reparado"}));
		cBox_estado.setBounds(372, 93, 97, 20);
		
		txt_comentario.setLineWrap(true);
		txt_comentario.setBounds(286, 180, 183, 159);
		
		btn_crear.setBounds(27, 277, 129, 62);
		
		btn_atras.setBounds(166, 277, 96, 62);
	}
	
	/**
	 * Contiene los listeners
	 */
	private void adaptadores() {
		//Boton guardar
		btn_crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorReparaciones.pulsarCrear();
			}
		});
		
		//Boton atras
		btn_atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorReparaciones.pulsarAtras();
			}
		});
	}
	
}
