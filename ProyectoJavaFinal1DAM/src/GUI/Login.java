package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frmLogin;
	private JTextField txt_usuario;
	private JLabel lb_contrasenia;
	private JPasswordField txt_contrasenia;


	/**
	 * Create the application.
	 */
	public Login() {
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
		
		JLabel lb_usuario = new JLabel("Usuario:");
		lb_usuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_usuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_usuario.setBounds(140, 37, 94, 22);
		frmLogin.getContentPane().add(lb_usuario);
		
		txt_usuario = new JTextField();
		txt_usuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_usuario.setBounds(244, 37, 130, 22);
		frmLogin.getContentPane().add(txt_usuario);
		txt_usuario.setColumns(10);
		
		lb_contrasenia = new JLabel("Contrase\u00F1a:");
		lb_contrasenia.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_contrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_contrasenia.setBounds(140, 92, 94, 22);
		frmLogin.getContentPane().add(lb_contrasenia);
		
		txt_contrasenia = new JPasswordField();
		txt_contrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_contrasenia.setColumns(10);
		txt_contrasenia.setBounds(244, 92, 130, 22);
		frmLogin.getContentPane().add(txt_contrasenia);
		
		JButton btn_entrar = new JButton("ENTRAR");
		btn_entrar.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_entrar.setBounds(10, 155, 265, 67);
		frmLogin.getContentPane().add(btn_entrar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));
		btnSalir.setBounds(285, 155, 89, 67);
		frmLogin.getContentPane().add(btnSalir);
		frmLogin.setVisible(true);
	}
}
