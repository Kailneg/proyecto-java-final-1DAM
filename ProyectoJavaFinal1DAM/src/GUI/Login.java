package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controlador;
import exceptions.ContraseniaNoCoincide;
import exceptions.UsuarioNoEncontrado;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField txt_usuario;
	private JLabel lb_contrasenia;
	private JPasswordField txt_contrasenia;
	private Controlador controlador;

	/**
	 * Create the application.
	 */
	public Login(Controlador controlador) {
		this.controlador = controlador;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 405, 278);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 0));
		panel.setBounds(0, 0, 389, 239);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lb_usuario = new JLabel("Usuario:");
		lb_usuario.setBounds(157, 25, 94, 22);
		panel.add(lb_usuario);
		lb_usuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_usuario.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_usuario = new JTextField();
		txt_usuario.setBounds(262, 27, 117, 22);
		panel.add(txt_usuario);
		txt_usuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_usuario.setColumns(10);

		lb_contrasenia = new JLabel("Contrase\u00F1a:");
		lb_contrasenia.setBounds(163, 82, 94, 22);
		panel.add(lb_contrasenia);
		lb_contrasenia.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_contrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_contrasenia = new JPasswordField();
		txt_contrasenia.setBounds(262, 84, 117, 22);
		panel.add(txt_contrasenia);
		txt_contrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_contrasenia.setColumns(10);

		JButton btn_entrar = new JButton("ENTRAR");
		btn_entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Hay que refactorizar
				try {
					if (controlador.getUsuarios().comprobarLogin(
							controlador.getUsuarios().obtenUsuario(txt_usuario.getText()),
							String.valueOf(txt_contrasenia.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Login correcto");
					}
				} catch (UsuarioNoEncontrado ex1) {
					JOptionPane.showMessageDialog(null, "El usuario no se encuentra.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ContraseniaNoCoincide ex1) {
					JOptionPane.showMessageDialog(null, "La contraseña no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btn_entrar.setBounds(10, 161, 265, 67);
		panel.add(btn_entrar);
		btn_entrar.setFont(new Font("Tahoma", Font.BOLD, 22));

		JButton btn_salir = new JButton("");
		btn_salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por confiar en DAST.", "Saliendo...", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		btn_salir.setBounds(290, 161, 89, 67);
		panel.add(btn_salir);
		btn_salir.setIcon(
				new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));

		JLabel lb_logo = new JLabel("");
		lb_logo.setBounds(10, 11, 128, 128);
		panel.add(lb_logo);
		lb_logo.setIcon(new ImageIcon(Login.class.getResource("/res/dast.png")));
		frmLogin.setVisible(true);
	}
}
