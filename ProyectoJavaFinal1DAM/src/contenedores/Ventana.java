package contenedores;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.UnknownHostException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana implements Runnable {

	private JFrame frmMongodbTest;
	private JTextField txt_insertar;
	private JPanel panel;
	private JList list;
	private JScrollPane scrollPane;
	private JLabel lb_insertar;
	private JButton btnEnviar;
	private JButton btnRefrescar;
	private JButton btnBorrarTodo;
	private Thread t;
	private String nombre;
	private MongoURI connectionString;
	private Mongo mongodb;
	private DB mydb;
	private DBCollection collection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmMongodbTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
		properties();
		adds();
		addapters();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMongodbTest = new JFrame();
		panel = new JPanel();
		list = new JList();
		scrollPane = new JScrollPane();
		lb_insertar = new JLabel("Insertar:");
		txt_insertar = new JTextField();
		btnEnviar = new JButton("Enviar");
		btnRefrescar = new JButton("Refrescar");
		btnBorrarTodo = new JButton("Borrar todo");
		nombre = JOptionPane.showInputDialog("Introduce tu nombre de usuario");
		if (nombre.trim().isEmpty() || nombre == null)
			nombre = "fulanito";
		t = new Thread(this);
		t.start();
	}

	@SuppressWarnings("unchecked")
	private void properties() {
		frmMongodbTest.setTitle("MongoDB chat");
		frmMongodbTest.setBounds(100, 100, 358, 260);
		frmMongodbTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMongodbTest.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		scrollPane.setBounds(20, 36, 304, 109);
		scrollPane.setViewportView(list);

		lb_insertar.setBounds(20, 11, 57, 14);

		txt_insertar.setBounds(77, 8, 157, 20);
		txt_insertar.setColumns(10);

		btnEnviar.setBounds(244, 7, 80, 23);
		btnRefrescar.setBounds(20, 156, 304, 23);
		btnBorrarTodo.setBounds(20, 190, 304, 23);
	}

	private void adds() {
		panel.add(scrollPane);
		panel.add(lb_insertar);
		panel.add(txt_insertar);
		panel.add(btnEnviar);
		panel.add(btnRefrescar);
		panel.add(btnBorrarTodo);
	}

	private void addapters() {
		// Enviar
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				enviarDB(txt_insertar.getText());
				actualizarLista();
			}
		});

		// Refrescar
		btnRefrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				actualizarLista();
			}
		});

		// Borrar
		btnBorrarTodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				borrarDB();
				actualizarLista();
			}
		});

		// Enter
		txt_insertar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					enviarDB(txt_insertar.getText());
					actualizarLista();
					txt_insertar.setText("");
				}
			}
		});
	}

	private void actualizarLista() {
		list.setModel(new AbstractListModel() {
			String[] values = recibirDB();
			
			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
			
			
		});
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}

	private void enviarDB(String texto) {
		abrirConexion();
		if (!texto.trim().isEmpty()) {
			
			BasicDBObject registro = new BasicDBObject("nombre", nombre).append("texto", texto);
			collection.insert(registro);
		}
		mongodb.close();
	}

	private String[] recibirDB() {
		abrirConexion();
		DBCursor documentos = collection.find();
		String[] retorno = new String[(int) collection.count()];
		int i = 0;
		for (BSONObject registro : documentos) {
			retorno[i] = registro.get("nombre") + ": " + registro.get("texto");
			i++;
		}
		mongodb.close();
		return retorno;
	}

	private void borrarDB() {
		abrirConexion();
		BasicDBObject document = new BasicDBObject();
		collection.drop();
		mongodb.close();
	}
	
	private void abrirConexion() {
		connectionString = new MongoURI("mongodb://192.168.0.8");
		try {
			mongodb = new Mongo(connectionString);
		} catch (MongoException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		mydb = mongodb.getDB("prueba");
		collection = mydb.getCollection("coleccionPrueba");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			actualizarLista();
		}
	}
}
