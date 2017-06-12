package contenedores;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

public class ConectorMongoDB {

	private String nombreColeccion;
	private MongoURI connectionString;
	private Mongo mongodb;
	private DB mydb;
	private DBCollection collection;

	public ConectorMongoDB(String nombreColeccion) {
		this.nombreColeccion = nombreColeccion;
	}
	
//	private void actualizarLista() {
//		list.setModel(new AbstractListModel() {
//			String[] values = recibirDB();
//			
//			public int getSize() {
//				return values.length;
//			}
//
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//			
//			
//		});
//		JScrollBar vertical = scrollPane.getVerticalScrollBar();
//		vertical.setValue(vertical.getMaximum());
//	}
	
	public void borrarDB() {
		abrirConexion();
		collection.drop();
		mongodb.close();
	}
	
	public void borrarUno(String key, String value) {
		abrirConexion();
		BasicDBObject bdbo = new BasicDBObject(key, value);
		collection.remove(bdbo);
		mongodb.close();
	}

	public boolean insertarEnDB(BasicDBObject registro) {
		abrirConexion();
		boolean yaInsertado = isYaInsertado(registro);
		if (!yaInsertado){
			collection.insert(registro);
			System.out.println("Insertado correctamente");
			mongodb.close();
			return yaInsertado;
		}
		System.out.println("No insertado");
		mongodb.close();
		return yaInsertado;
	}
	
	public List<DBObject> recibirDBColeccion() {
		abrirConexion();
		DBCursor registros = collection.find();
		mongodb.close();
		return registros.copy().toArray();
	}
	
	private boolean isYaInsertado(DBObject registro){
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject d = cursor.next();
			System.out.println(d.get("dni").toString());
			if (cursor.next().get("dni").toString().equalsIgnoreCase(registro.get("dni").toString())){
				return true;
			}
		}
		return false;
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
		mydb = mongodb.getDB("Taller");
		collection = mydb.getCollection(nombreColeccion);
	}
}
