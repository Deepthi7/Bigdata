package mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class language {
	
	public static void main(String[] args) 
	{
		try
    {
    

     MongoClient mongo = new MongoClient("localhost", 27017);
   	 DB db = mongo.getDB("BigDataProject");
   	 DBCollection collection = db.getCollection("PB"); 	  
   	   
   	  // Now the $group operation
   	  DBObject groupFields = new BasicDBObject( "_id", "$user.lang");
   	  groupFields.put("count", new BasicDBObject( "$sum", 1));
   	  DBObject group = new BasicDBObject("$group", groupFields);

   	  // Finally the $sort operation
   	  DBObject sort = new BasicDBObject("$sort", new BasicDBObject("count", -1));
   	  DBObject limit= new BasicDBObject("$limit",10);

   	  // run aggregation
   	  //List<DBObject> list = Arrays.asList( group, sort,limit);
   	  AggregationOutput output = collection.aggregate(group,sort,limit);
   	  int i=0;
   	  List<String> list = new ArrayList<String>();
   	  for (DBObject result : output.results()) {
   	    System.out.println(result.toString());
   	    
   	
	         	 }
   	
   	 
      }
   	  
   	  catch(Exception e)
      {
          System.out.println(e);
      } 
}
}
