package mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class usercount {

	public static void main(String[] args) 
	{
		try
    {
    //MongoClient mc= new MongoClient();

    	 MongoClient mongo = new MongoClient("localhost", 27017);
   	  	 DB db = mongo.getDB("BigDataProject");
   	  	 DBCollection collection = db.getCollection("PB"); 	
   	  	 String a [] = new String [1];
   	   for(int i=1;i<=1;i++)
   	   {
   	  Scanner in = new Scanner(System.in);
   	  
      System.out.println("Enter the screen name of the person "+i);
       String name = in.nextLine();
       a[i-1]=name;
   	   }
   	   for(int i=0;i<1;i++)
   	   {
      	BasicDBObject Query = new BasicDBObject("user.screen_name", a[i]); 
      	BasicDBObject projection = new BasicDBObject();
        projection.append("user.friends_count", 1);
        projection.append("user.statuses_count", 1);
        projection.append("user.favourites_count", 1);
        projection.append("user.followers_count", 1);
        projection.append("_id", 0);
      	DBCursor cursor = collection.find(Query,projection);
       	System.out.println(cursor.next());
       	cursor.close();
       	
   	   }
      }
   	  
   	  catch(Exception e)
      {
          System.out.println(e);
      } 
}
}
