package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MainController;
import exceptions.PasswordNotFound;
import exceptions.UsernameNotFound;
import globals.Globals;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField txt_usuario;
	private JLabel lb_contrasenia, lb_usuario, lb_logo;
	private JPasswordField txt_contrasenia;
	private MainController controlador;
	private JPanel lb_panel;
	private JButton btn_entrar, btn_salir;

	/**
	 * Create the application.
	 */
	public Login(MainController controlador) {
		this.controlador = controlador;
		loginComponents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void componentsInitializers() {
		frmLogin = new JFrame();
		lb_panel = new JPanel();
		lb_usuario = new JLabel("Usuario:");
		txt_usuario = new JTextField();
		lb_contrasenia = new JLabel("Contrase\u00F1a:");
		txt_contrasenia = new JPasswordField();
		btn_entrar = new JButton("ENTRAR");
		btn_salir = new JButton();
		lb_logo = new JLabel();
	}

	private void componentsAdders() {
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(lb_panel);
		frmLogin.setVisible(true);
		
		lb_panel.add(lb_usuario);
		lb_panel.add(txt_usuario);
		lb_panel.add(lb_contrasenia);
		lb_panel.add(txt_contrasenia);
		lb_panel.add(btn_entrar);
		lb_panel.add(btn_salir);
		lb_panel.add(lb_logo);
	}

	private void componentsProperties() {
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 405, 278);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lb_panel.setBackground(new Color(255, 204, 0));
		lb_panel.setBounds(0, 0, 389, 239);
		lb_panel.setLayout(null);

		lb_usuario.setBounds(157, 25, 94, 22);
		lb_usuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_usuario.setFont(new Font(Globals.FONT, Font.PLAIN, 18));

		txt_usuario.setBounds(262, 27, 117, 22);
		txt_usuario.setFont(new Font(Globals.FONT, Font.PLAIN, 18));
		txt_usuario.setColumns(10);

		lb_contrasenia.setBounds(163, 82, 94, 22);
		lb_contrasenia.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_contrasenia.setFont(new Font(Globals.FONT, Font.PLAIN, 18));

		txt_contrasenia.setBounds(262, 84, 117, 22);
		txt_contrasenia.setFont(new Font(Globals.FONT, Font.PLAIN, 18));
		txt_contrasenia.setColumns(10);

		btn_entrar.setBounds(10, 161, 265, 67);
		btn_entrar.setFont(new Font(Globals.FONT, Font.BOLD, 22));

		btn_salir.setBounds(290, 161, 89, 67);
		btn_salir.setIcon(
				new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));

		lb_logo.setBounds(10, 11, 128, 128);
		lb_logo.setIcon(new ImageIcon(Login.class.getResource(Globals.LOGO_PATH)));

	}

	private void componentsListeners() {
		btn_entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					if (controlador.getUsuarios().comprobarLogin(
							controlador.getUsuarios().obtenUsuario(txt_usuario.getText()),
							String.valueOf(txt_contrasenia.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Login correcto");
					}
				} catch (UsernameNotFound ex1) {
					JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (PasswordNotFound ex2) {
					JOptionPane.showMessageDialog(null, ex2.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btn_salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por confiar en DAST.", "Saliendo...",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
	}

	private void loginComponents() {
		componentsInitializers();
		componentsAdders();
		componentsProperties();
		componentsListeners();
	}
}
