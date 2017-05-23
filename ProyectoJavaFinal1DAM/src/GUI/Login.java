package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControladorLogin;
import globals.Constantes;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {
	protected static JTextField txt_usuario;
	protected static JPasswordField txt_contrasenia;

	protected JFrame frmLogin;
	protected JLabel lb_contrasenia, lb_usuario, lb_logo;
	protected JPanel lb_panel;
	protected JButton btn_entrar, btn_salir;

	/**
	 * Create the application.
	 */
	public Login() {
		loginComponents();
	}

	/**
	 * Inicializa el contenido del frame.
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

	/**
	 * Añade al frame todos los componentes que hemos creado.
	 */
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

	/**
	 * Contiene las propiedades de todos los componentes del frame
	 */
	private void componentsProperties() {
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 405, 278);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lb_panel.setBackground(new Color(255, 204, 0));
		lb_panel.setBounds(0, 0, 389, 239);
		lb_panel.setLayout(null);

		lb_usuario.setBounds(157, 25, 94, 22);
		lb_usuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_usuario.setFont(new Font(Constantes.FONT, Font.PLAIN, 18));

		txt_usuario.setBounds(262, 27, 117, 22);
		txt_usuario.setFont(new Font(Constantes.FONT, Font.PLAIN, 18));
		txt_usuario.setColumns(10);

		lb_contrasenia.setBounds(163, 82, 94, 22);
		lb_contrasenia.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_contrasenia.setFont(new Font(Constantes.FONT, Font.PLAIN, 18));

		txt_contrasenia.setBounds(262, 84, 117, 22);
		txt_contrasenia.setFont(new Font(Constantes.FONT, Font.PLAIN, 18));
		txt_contrasenia.setColumns(10);

		btn_entrar.setBounds(10, 161, 265, 67);
		btn_entrar.setFont(new Font(Constantes.FONT, Font.BOLD, 22));

		btn_salir.setBounds(290, 161, 89, 67);
		btn_salir.setIcon(
				new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));

		lb_logo.setBounds(10, 11, 128, 128);
		lb_logo.setIcon(new ImageIcon(Login.class.getResource(Constantes.LOGO_PATH)));

	}

	/**
	 * Contiene los eventos asociados al frame
	 */
	private void componentsListeners() {
		btn_entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ControladorLogin.validarLogin();
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

	/**
	 * Llama a los métodos encargados de inicializar, añadir y definir los componentes del frame
	 */
	private void loginComponents() {
		componentsInitializers();
		componentsAdders();
		componentsProperties();
		componentsListeners();
	}
}
