package interfaces;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import models.Cliente;

public interface Guardable {
	DBObject guardar();
}
