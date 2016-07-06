package testgit;

import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class HelloWorldExample {

	public static void main(String[] args) {
        try {
             
        	String dbURI = "mongodb://quynh:quynh@ds021884.mlab.com:21884/quynhdb";
        	MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
        	
        	DB db = mongoClient.getDB("quynhdb");
        	Set<String> collections = db.getCollectionNames();
            for (String colName : collections) {
                System.out.println("\t + Collection: " + colName);
            }
            
            DBCollection table = db.getCollection("user1");
            BasicDBObject query = new BasicDBObject();
            query.put("user1", "quynh");
            //Result set or cursor object
            DBCursor rs = table.find(query);
            while (rs.hasNext()) {
            	System.out.println(rs.next());
            }
            
            mongoClient.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
    }

}
