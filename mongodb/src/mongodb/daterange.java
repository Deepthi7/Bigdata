package mongodb;

import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class daterange {

	public static void main(String[] args) 
	{
		try
    {
    //MongoClient mc= new MongoClient();

    	 MongoClient mongo = new MongoClient("localhost", 27017);
   	  	 DB db = mongo.getDB("BigDataProject");
   	  	 DBCollection collection = db.getCollection("PB"); 	  
   	   
   	  	Scanner in = new Scanner(System.in);
      
   	  	System.out.println("Enter the start date");
   	  	String start = in.nextLine();
       
   	  	Scanner en = new Scanner(System.in);
       
   	  	System.out.println("Enter the end date");
        String end = en.nextLine();
        
      	BasicDBObject Query = new BasicDBObject("created_at", new BasicDBObject("$gt", start).append("$lt",end ));
      	BasicDBObject projection = new BasicDBObject();
        projection.append("text", 1);
      	DBCursor cursor = collection.find(Query,projection);
       	System.out.println(cursor.next());
       	cursor.close();
      }
   	  
   	  catch(Exception e)
      {
          System.out.println(e);
      } 
}
}
