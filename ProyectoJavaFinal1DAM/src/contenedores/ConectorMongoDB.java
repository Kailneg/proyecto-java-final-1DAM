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
	private String key;
	private MongoURI connectionString;
	private Mongo mongodb;
	private DB mydb;
	private DBCollection collection;

	public ConectorMongoDB(String nombreColeccion, String key) {
		this.nombreColeccion = nombreColeccion;
		this.key = key;
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
	
	public boolean borrarUno(String keyValue) {
		abrirConexion();
		BasicDBObject registro = new BasicDBObject(key, keyValue);
		boolean yaInsertado = isYaInsertado(registro);
		collection.remove(registro);
		mongodb.close();
		return yaInsertado;
	}
	
	public boolean isEmpty(){
		abrirConexion();
		boolean retorno = collection.count() == 0;
		mongodb.close();
		return retorno;
	}

	public boolean insertarEnDB(DBObject registro) {
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
		List<DBObject> retorno = registros.copy().toArray();
		mongodb.close();
		return retorno;
	}
	
	public long size(){
		abrirConexion();
		long retorno = collection.count();
		mongodb.close();
		return retorno;
	}
	
	private boolean isYaInsertado(DBObject registro){
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			if (cursor.next().get(key).toString().equalsIgnoreCase(registro.get(key).toString())){
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
