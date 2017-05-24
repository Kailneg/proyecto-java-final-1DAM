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
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.Font;

public class Reparaciones {

	private JFrame frmParteDeReparacin;
	private JTextField txt_ID;
	private JTextField txt_fechaInicio;
	private JTextField txt_fechaFin;
	private JTextField txt_Propietario;
	private JTextField txt_mecanico;
	private JTextField txt_presupuesto;
	private JTextField textField_euro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reparaciones window = new Reparaciones();
					window.frmParteDeReparacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reparaciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmParteDeReparacin = new JFrame();
		frmParteDeReparacin.setTitle("Parte de reparaci\u00F3n");
		frmParteDeReparacin.setBounds(100, 100, 547, 428);
		frmParteDeReparacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmParteDeReparacin.getContentPane().setLayout(null);
		
		JLabel lblIDReparacion = new JLabel("ID. Reparaci\u00F3n:");
		lblIDReparacion.setBounds(56, 28, 97, 24);
		frmParteDeReparacin.getContentPane().add(lblIDReparacion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(56, 78, 76, 14);
		frmParteDeReparacin.getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(56, 118, 76, 14);
		frmParteDeReparacin.getContentPane().add(lblFechaFin);
		
		JLabel lblCliente = new JLabel("Propietario:");
		lblCliente.setBounds(56, 159, 76, 14);
		frmParteDeReparacin.getContentPane().add(lblCliente);
		
		JLabel lblMecnico = new JLabel("Mec\u00E1nico:");
		lblMecnico.setBounds(56, 201, 60, 14);
		frmParteDeReparacin.getContentPane().add(lblMecnico);
		
		JLabel lblPresupuesto = new JLabel("Presupuesto:");
		lblPresupuesto.setBounds(56, 240, 76, 14);
		frmParteDeReparacin.getContentPane().add(lblPresupuesto);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setBounds(295, 33, 76, 14);
		frmParteDeReparacin.getContentPane().add(lblOrdenarPor);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(295, 100, 76, 14);
		frmParteDeReparacin.getContentPane().add(lblEstado);
		
		JLabel lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setBounds(295, 159, 76, 14);
		frmParteDeReparacin.getContentPane().add(lblComentarios);
		
		txt_ID = new JTextField();
		txt_ID.setEditable(false);
		txt_ID.setBounds(143, 28, 116, 24);
		frmParteDeReparacin.getContentPane().add(txt_ID);
		txt_ID.setColumns(10);
		
		txt_fechaInicio = new JTextField();
		txt_fechaInicio.setColumns(10);
		txt_fechaInicio.setBounds(142, 73, 117, 24);
		frmParteDeReparacin.getContentPane().add(txt_fechaInicio);
		
		txt_fechaFin = new JTextField();
		txt_fechaFin.setColumns(10);
		txt_fechaFin.setBounds(142, 115, 117, 24);
		frmParteDeReparacin.getContentPane().add(txt_fechaFin);
		
		txt_Propietario = new JTextField();
		txt_Propietario.setColumns(10);
		txt_Propietario.setBounds(142, 156, 117, 24);
		frmParteDeReparacin.getContentPane().add(txt_Propietario);
		
		txt_mecanico = new JTextField();
		txt_mecanico.setColumns(10);
		txt_mecanico.setBounds(142, 198, 117, 24);
		frmParteDeReparacin.getContentPane().add(txt_mecanico);
		
		txt_presupuesto = new JTextField();
		txt_presupuesto.setColumns(10);
		txt_presupuesto.setBounds(142, 237, 86, 24);
		frmParteDeReparacin.getContentPane().add(txt_presupuesto);
		
		textField_euro = new JTextField();
		textField_euro.setHorizontalAlignment(SwingConstants.CENTER);
		textField_euro.setForeground(Color.BLACK);
		textField_euro.setEditable(false);
		textField_euro.setText("\u20AC");
		textField_euro.setBounds(228, 237, 31, 24);
		frmParteDeReparacin.getContentPane().add(textField_euro);
		textField_euro.setColumns(10);
		
		JComboBox cBox_ordenar = new JComboBox();
		cBox_ordenar.setModel(new DefaultComboBoxModel(new String[] {"Fecha", "Nombre", "Presupuesto"}));
		cBox_ordenar.setBounds(381, 30, 97, 20);
		frmParteDeReparacin.getContentPane().add(cBox_ordenar);
		
		JComboBox cBox_estado = new JComboBox();
		cBox_estado.setModel(new DefaultComboBoxModel(new String[] {"Reparado", "Pendiente", "No reparado"}));
		cBox_estado.setBounds(381, 97, 97, 20);
		frmParteDeReparacin.getContentPane().add(cBox_estado);
		
		JTextArea txt_comentario = new JTextArea();
		txt_comentario.setLineWrap(true);
		txt_comentario.setBounds(295, 184, 183, 159);
		frmParteDeReparacin.getContentPane().add(txt_comentario);
		
		JButton btn_guardar = new JButton("GUARDAR");
		btn_guardar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_guardar.setBounds(56, 281, 97, 62);
		frmParteDeReparacin.getContentPane().add(btn_guardar);
		
		JButton btn_atras = new JButton("ATRAS");
		btn_atras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_atras.setBounds(163, 281, 96, 62);
		frmParteDeReparacin.getContentPane().add(btn_atras);
	}
}
