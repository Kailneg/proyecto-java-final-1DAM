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

import enums.EstadoReparacion;
import enums.Meses;
import models.Reparacion;

import java.awt.Font;

public class VentanaReparaciones {

	// Constantes
	private final Integer dias[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24, 25, 26, 27, 28, 29, 30, 31 };
	private final Integer anios[] = { 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005,
			2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990 };

	// Variables
	private ControladorReparaciones controladorReparaciones;
	private boolean isModoEscritura;
	private JFrame frame;
	private JTextField txt_ID;
	private JTextField txt_propietario;
	private JTextField txt_mecanico;
	private JTextField txt_presupuesto;
	private JTextField txt_euro;
	private JLabel lblIDReparacion;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFin;
	private JLabel lblCliente;
	private JLabel lb_mecanico;
	private JLabel lb_presupuesto;
	private JLabel lblOrdenarPor;
	private JLabel lb_estado;
	private JLabel lb_comentarios;
	private JComboBox cb_ordenar;
	private JComboBox cb_estado;
	private JTextArea txt_comentario;
	private JComboBox cb_anio_inicio;
	private JComboBox cb_dia_inicio;
	private JComboBox cb_mes_inicio;
	private JComboBox cb_dia_fin;
	private JComboBox cb_mes_fin;
	private JComboBox cb_anio_fin;
	private JButton btn_crear;
	private JButton btn_atras;

	/**
	 * Create the application.
	 */
	public VentanaReparaciones(ControladorReparaciones controladorReparaciones) {
		this.controladorReparaciones = controladorReparaciones;
		this.isModoEscritura = true;
		componentsInitializers();
		componentsProperties();
		componentsAdders();
		adaptadores();

	}

	// Ocultar y mostrar
	public void mostrarVentana() {
		frame.setVisible(true);
	}

	public void ocultarVentana() {
		frame.setVisible(false);
	}
	
	/**
	 * Cambia entre modo escritura y modo lectura a la ventana
	 * @param escritura true si es modo escritura, false para modo lectura
	 */
	public void setModoEscritura(boolean escritura){
		isModoEscritura = escritura;
		txt_ID.setEditable(escritura);
		txt_propietario.setEditable(escritura);
		txt_mecanico.setEditable(escritura);
		txt_presupuesto.setEditable(escritura);
		txt_comentario.setEditable(escritura);
		cb_dia_inicio.setEnabled(escritura);
		cb_mes_inicio.setEnabled(escritura);
		cb_anio_inicio.setEnabled(escritura);
		cb_dia_fin.setEnabled(escritura);
		cb_mes_fin.setEnabled(escritura);
		cb_anio_fin.setEditable(escritura);
		cb_ordenar.setEditable(escritura);
		cb_estado.setEnabled(escritura);
		
		if(escritura)
			btn_crear.setText("Crear");
		else
			btn_crear.setText("Editar");
	}
	
	
	public void cargarReparacion(Reparacion reparacion){
		if (!isModoEscritura) {
			txt_ID.setText(String.valueOf(reparacion.getIdReparacion()));
			txt_propietario.setText(reparacion.getPropietario());
			txt_mecanico.setText("TODO: WHO'S LOGGED"); //TODO:Quien se ha logeado
			txt_presupuesto.setText(String.valueOf(reparacion.getPresupuesto()));
			txt_comentario.setText(reparacion.getComentarios());
			cb_dia_inicio.setSelectedIndex(reparacion.getFechaInicio().get(Calendar.DAY_OF_MONTH));
			cb_mes_inicio.setSelectedIndex(reparacion.getFechaInicio().get(Calendar.MONTH));
			cb_anio_inicio.setSelectedIndex(reparacion.getFechaInicio().get(Calendar.YEAR));
			cb_dia_fin.setSelectedIndex(reparacion.getFechaFin().get(Calendar.DAY_OF_MONTH));
			cb_mes_fin.setSelectedIndex(reparacion.getFechaFin().get(Calendar.MONTH));
			cb_anio_fin.setSelectedIndex(reparacion.getFechaFin().get(Calendar.YEAR));
			cb_estado.setSelectedItem(reparacion.getEstado());
		} else {
			throw new RuntimeException("No se puede cargar una reparación en modo Escritura");
		}
	}

	// Getters
	public boolean getIsModoEscritura(){
		return isModoEscritura;
	}
	
	public int getIdReparacion() {
		return Integer.parseInt(txt_ID.getText());
	}

	public Calendar getFechaInicio() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(cb_anio_inicio.getSelectedItem().toString()), cb_mes_inicio.getSelectedIndex(),
				Integer.parseInt(cb_dia_inicio.getSelectedItem().toString()));
		return c;
	}

	public Calendar getFechaFin() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(cb_anio_fin.getSelectedItem().toString()), cb_mes_fin.getSelectedIndex(),
				Integer.parseInt(cb_dia_fin.getSelectedItem().toString()));
		return c;
	}
	
	public String getPropietario(){
		return txt_propietario.getText();
	}

	public float getPresupuesto() {
		return Float.parseFloat(txt_presupuesto.getText());
	}

	public EstadoReparacion getEstado() {
		return EstadoReparacion.valueOf(cb_estado.getSelectedItem().toString());
	}

	public String getComentarios() {
		return txt_comentario.getText();
	}

	/**
	 * Inicializa tods los componentes del frame y el mismo frame
	 */
	private void componentsInitializers() {
		frame = new JFrame();
		lblIDReparacion = new JLabel("ID. Reparaci\u00F3n:");
		lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaFin = new JLabel("Fecha Fin:");
		lblCliente = new JLabel("Propietario:");
		lb_mecanico = new JLabel("Mec\u00E1nico:");
		lb_presupuesto = new JLabel("Presupuesto:");
		lblOrdenarPor = new JLabel("Ordenar por:");
		lb_estado = new JLabel("Estado:");
		lb_comentarios = new JLabel("Comentarios:");
		txt_ID = new JTextField();
		txt_propietario = new JTextField();
		txt_mecanico = new JTextField();
		txt_presupuesto = new JTextField();
		txt_euro = new JTextField();
		cb_ordenar = new JComboBox();
		cb_estado = new JComboBox();
		txt_comentario = new JTextArea();
		cb_dia_inicio = new JComboBox();
		cb_mes_inicio = new JComboBox();
		cb_anio_inicio = new JComboBox();
		cb_dia_fin = new JComboBox();
		cb_mes_fin = new JComboBox();
		cb_anio_fin = new JComboBox();
		btn_crear = new JButton("Crear");
		btn_atras = new JButton("Atras");
	}

	/**
	 * Añade al frame todos sus componentes
	 */
	private void componentsAdders() {
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIDReparacion);
		frame.getContentPane().add(lblFechaInicio);
		frame.getContentPane().add(lblFechaFin);
		frame.getContentPane().add(lblCliente);
		frame.getContentPane().add(lb_mecanico);
		frame.getContentPane().add(lb_presupuesto);
		frame.getContentPane().add(lblOrdenarPor);
		frame.getContentPane().add(lb_estado);
		frame.getContentPane().add(lb_comentarios);
		frame.getContentPane().add(txt_ID);
		frame.getContentPane().add(txt_propietario);
		frame.getContentPane().add(txt_mecanico);
		frame.getContentPane().add(txt_presupuesto);
		frame.getContentPane().add(txt_euro);
		frame.getContentPane().add(cb_ordenar);
		frame.getContentPane().add(cb_estado);
		frame.getContentPane().add(txt_comentario);
		frame.getContentPane().add(btn_crear);
		frame.getContentPane().add(btn_atras);
		frame.getContentPane().add(cb_dia_inicio);
		frame.getContentPane().add(cb_mes_inicio);
		frame.getContentPane().add(cb_anio_inicio);
		frame.getContentPane().add(cb_dia_fin);
		frame.getContentPane().add(cb_mes_fin);
		frame.getContentPane().add(cb_anio_fin);

	}

	/**
	 * Define las propiedades de los componentes del frame
	 */
	private void componentsProperties() {
		// Frame
		frame.setTitle("Parte de reparaci\u00F3n");
		frame.setBounds(100, 100, 500, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		lblIDReparacion.setBounds(27, 24, 97, 24);
		txt_ID.setBounds(113, 24, 149, 24);
		txt_ID.setColumns(10);

		lblFechaInicio.setBounds(27, 74, 76, 14);
		cb_dia_inicio.setModel(new DefaultComboBoxModel(dias));
		cb_dia_inicio.setBounds(113, 71, 37, 20);
		cb_mes_inicio.setModel(new DefaultComboBoxModel(Meses.values()));
		cb_mes_inicio.setBounds(151, 71, 60, 20);
		cb_anio_inicio.setModel(new DefaultComboBoxModel(anios));
		cb_anio_inicio.setBounds(213, 71, 49, 20);

		lblFechaFin.setBounds(27, 114, 76, 14);
		cb_dia_fin.setModel(new DefaultComboBoxModel(dias));
		cb_dia_fin.setBounds(113, 111, 37, 20);
		cb_mes_fin.setModel(new DefaultComboBoxModel(Meses.values()));
		cb_mes_fin.setBounds(151, 111, 60, 20);
		cb_anio_fin.setModel(new DefaultComboBoxModel(anios));
		cb_anio_fin.setBounds(213, 111, 49, 20);

		lblCliente.setBounds(27, 155, 76, 14);

		txt_propietario.setColumns(10);
		txt_propietario.setBounds(113, 152, 149, 24);

		lb_mecanico.setBounds(27, 197, 60, 14);
		txt_mecanico.setColumns(10);
		txt_mecanico.setBounds(113, 194, 149, 24);

		lb_presupuesto.setBounds(27, 236, 76, 14);
		txt_presupuesto.setColumns(10);
		txt_presupuesto.setBounds(113, 233, 117, 24);

		txt_euro.setHorizontalAlignment(SwingConstants.CENTER);
		txt_euro.setForeground(Color.BLACK);
		txt_euro.setEditable(false);
		txt_euro.setText("\u20AC");
		txt_euro.setBounds(231, 233, 31, 24);
		txt_euro.setColumns(10);

		lblOrdenarPor.setBounds(286, 29, 76, 14);
		cb_ordenar.setModel(new DefaultComboBoxModel(new String[] { "Fecha", "Nombre", "Presupuesto" }));
		cb_ordenar.setBounds(372, 26, 97, 20);

		lb_estado.setBounds(286, 96, 76, 14);
		cb_estado.setModel(new DefaultComboBoxModel(new String[] { "Reparado", "Pendiente", "No reparado" }));
		cb_estado.setBounds(372, 93, 97, 20);

		lb_comentarios.setBounds(286, 155, 76, 14);
		txt_comentario.setLineWrap(true);
		txt_comentario.setBounds(286, 180, 183, 159);

		btn_crear.setBounds(27, 277, 129, 62);
		btn_atras.setBounds(166, 277, 96, 62);
		btn_crear.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_atras.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
	}

	/**
	 * Contiene los listeners
	 */
	private void adaptadores() {
		// Boton guardar
		btn_crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorReparaciones.pulsarCrear();
			}
		});

		// Boton atras
		btn_atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorReparaciones.pulsarAtras();
			}
		});
		
		//USO PARA FINES DE TESTEO
		txt_euro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorReparaciones.pulsarTest();
			}
		});
	}
}
