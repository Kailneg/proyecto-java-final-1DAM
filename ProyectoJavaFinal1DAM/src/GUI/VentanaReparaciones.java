package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.management.RuntimeErrorException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.joda.time.DateTime;

import controller.ControladorReparaciones;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import enums.EstadoReparacion;
import enums.Meses;
import globals.Constantes;
import models.Reparacion;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JSeparator;

public class VentanaReparaciones {

	// Constantes
	private final Integer dias[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24, 25, 26, 27, 28, 29, 30, 31 };
	private final Integer anios[] = { 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012,
			2013, 2014, 2015, 2016, 2017, 2018 };

	// Variables
	private ControladorReparaciones controladorReparaciones;
	private JFrame frame;
	private JTextField txt_ID;
	private JTextField txt_propietario;
	private JTextField txt_mecanico;
	private JTextField txt_presupuesto;
	private JTextField txt_euro;
	private JLabel lblIDReparacion;
	private JLabel lblCliente;
	private JLabel lb_mecanico;
	private JLabel lb_presupuesto;
	private JLabel lblOrdenarPor;
	private JLabel lb_estado;
	private JLabel lb_comentarios;
	private JComboBox<?> cb_ordenar;
	private JComboBox cb_estado;
	private JTextArea txt_comentario;
	private JButton btn_crear;
	private JButton btn_atras;
	private JButton btnLeftArrow;
	private JButton btnRightArrow;
	private JPanel panel;
	private JLabel lblPrecioTotal;
	private JTextField txt_precioFinal;
	private JTextField txt_IvaInc;
	private JLabel lblCostePiezas;
	private JTextField txt_piezas;
	private JTextField txt_euro2;
	private JLabel lblTiempoInvertido;
	private JTextField textField;
	private JButton btnInicio;
	private JTextField txt_fechafin;
	private JTextField txt_fechainicio;
	private JButton btnFin;
	private JSeparator separator;
	private JSeparator separator_1;

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

	// Ocultar y mostrar
	public void mostrarVentana() {
		hideComponents(Constantes.MODO_CREAR);
		frame.setVisible(true);
	}

	public void ocultarVentana() {
		frame.setVisible(false);
	}

	public void cargarReparacion(Reparacion reparacion) throws RuntimeException {
		if (!Constantes.MODO_CREAR) {
			txt_ID.setText(String.valueOf(reparacion.getIdReparacion()));
			txt_propietario.setText(reparacion.getPropietario());
			txt_mecanico.setText("TODO: WHO'S LOGGED"); // TODO:Quien se ha
														// logeado
			txt_presupuesto.setText(String.valueOf(reparacion.getPresupuesto()));
			txt_comentario.setText(reparacion.getComentarios());

			cb_estado.setSelectedItem(reparacion.getEstado());
		} else {
			throw new RuntimeException("No se puede cargar la reparacion en modo crear");
		}
	}

	public int getIdReparacion() {
		return Integer.parseInt(txt_ID.getText());
	}

	public String getPropietario() {
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
		panel = new JPanel();
		btn_crear = new JButton("Crear");
		btn_atras = new JButton("Atras");
		btnLeftArrow = new JButton("<");
		btnRightArrow = new JButton(">");
		lblPrecioTotal = new JLabel("TOTAL");
		txt_precioFinal = new JTextField();
		txt_precioFinal.setEditable(false);
		txt_IvaInc = new JTextField();
		lblCostePiezas = new JLabel("Coste Piezas:");
		separator = new JSeparator();
		separator_1 = new JSeparator();
		btnFin = new JButton("Fin");
		txt_fechainicio = new JTextField();
		txt_fechainicio.setEditable(false);
		txt_fechafin = new JTextField();
		txt_fechafin.setEditable(false);
		btnInicio = new JButton("Inicio");
		textField = new JTextField();
		textField.setEditable(false);
		lblTiempoInvertido = new JLabel("Tiempo invertido:");
		txt_euro2 = new JTextField();
		txt_piezas = new JTextField();
	}

	/**
	 * Añade al frame todos sus componentes
	 */
	private void componentsAdders() {
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIDReparacion);
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

		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(27, 371, 235, 88);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		panel.add(btn_crear);
		panel.add(btn_atras);
		panel.add(btnLeftArrow);
		panel.add(btnRightArrow);

		lblPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioTotal.setBounds(286, 402, 60, 31);
		frame.getContentPane().add(lblPrecioTotal);

		txt_precioFinal.setBounds(345, 406, 97, 27);
		frame.getContentPane().add(txt_precioFinal);
		txt_precioFinal.setColumns(10);

		txt_IvaInc.setText("\u20AC   IVA inc.");
		txt_IvaInc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_IvaInc.setForeground(Color.BLACK);
		txt_IvaInc.setEditable(false);
		txt_IvaInc.setColumns(10);
		txt_IvaInc.setBounds(438, 406, 60, 27);
		frame.getContentPane().add(txt_IvaInc);

		lblCostePiezas.setBounds(27, 198, 76, 14);
		frame.getContentPane().add(lblCostePiezas);

		txt_piezas.setColumns(10);
		txt_piezas.setBounds(113, 193, 117, 24);
		frame.getContentPane().add(txt_piezas);

		txt_euro2.setText("\u20AC");
		txt_euro2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_euro2.setForeground(Color.BLACK);
		txt_euro2.setEditable(false);
		txt_euro2.setColumns(10);
		txt_euro2.setBounds(231, 193, 31, 24);
		frame.getContentPane().add(txt_euro2);

		lblTiempoInvertido.setBounds(27, 330, 97, 14);
		frame.getContentPane().add(lblTiempoInvertido);

		textField.setBounds(125, 327, 137, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		btnInicio.setBounds(27, 249, 97, 24);
		frame.getContentPane().add(btnInicio);

		txt_fechafin.setBounds(148, 284, 114, 24);
		frame.getContentPane().add(txt_fechafin);
		txt_fechafin.setColumns(10);

		txt_fechainicio.setColumns(10);
		txt_fechainicio.setBounds(27, 284, 97, 24);
		frame.getContentPane().add(txt_fechainicio);

		btnFin.setBounds(148, 249, 114, 24);
		frame.getContentPane().add(btnFin);

		separator.setBounds(27, 236, 235, 2);
		frame.getContentPane().add(separator);

		separator_1.setBounds(27, 358, 471, 2);
		frame.getContentPane().add(separator_1);

	}

	private void hideComponents(boolean b) {
		txt_ID.setEnabled(b);
		txt_propietario.setEnabled(b);
		txt_mecanico.setEnabled(b);
		txt_presupuesto.setEnabled(b);
		txt_piezas.setEnabled(b);
		cb_ordenar.setEnabled(b);
		cb_estado.setEnabled(b);
		txt_comentario.setEnabled(b);
		btn_crear.setEnabled(b);
		btnLeftArrow.setEnabled(!b);
		btnRightArrow.setEnabled(!b);
	}

	/**
	 * Define las propiedades de los componentes del frame
	 */
	private void componentsProperties() {
		// Frame
		frame.setTitle("Parte de reparaci\u00F3n");
		frame.setBounds(100, 100, 527, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		lblIDReparacion.setBounds(27, 24, 97, 24);
		txt_ID.setBounds(113, 24, 149, 24);
		txt_ID.setColumns(10);

		lblCliente.setBounds(27, 71, 76, 14);

		txt_propietario.setColumns(10);
		txt_propietario.setBounds(113, 66, 149, 24);

		lb_mecanico.setBounds(27, 112, 60, 14);
		txt_mecanico.setColumns(10);
		txt_mecanico.setBounds(113, 107, 149, 24);

		lb_presupuesto.setBounds(27, 155, 76, 14);
		txt_presupuesto.setColumns(10);
		txt_presupuesto.setBounds(113, 150, 117, 24);

		txt_euro.setHorizontalAlignment(SwingConstants.CENTER);
		txt_euro.setForeground(Color.BLACK);
		txt_euro.setEditable(false);
		txt_euro.setText("\u20AC");
		txt_euro.setBounds(231, 150, 31, 24);
		txt_euro.setColumns(10);

		lblOrdenarPor.setBounds(303, 29, 76, 14);
		cb_ordenar.setModel(new DefaultComboBoxModel(new String[] { "Fecha", "Nombre", "Presupuesto" }));
		cb_ordenar.setBounds(401, 26, 97, 20);

		lb_estado.setBounds(303, 96, 76, 14);
		cb_estado.setModel(new DefaultComboBoxModel(EstadoReparacion.values()));
		cb_estado.setBounds(401, 93, 97, 20);

		lb_comentarios.setBounds(303, 155, 76, 14);
		txt_comentario.setLineWrap(true);
		txt_comentario.setBounds(303, 180, 195, 136);
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
				if (Constantes.MODO_CREAR) {
					controladorReparaciones.pulsarCrear();
				}
			}
		});

		// Boton atras
		btn_atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controladorReparaciones.pulsarAtras();
			}
		});
		
		//Boton Inicio
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
	}
}
