package mongodb;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Set;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.awt.*;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Scanner;
public class query1 extends Applet {
	 int cur1,cur,cur2;
    public static void main(String[] args) {
    
    	try
        {
        //MongoClient mc= new MongoClient();

        	 MongoClient mongo = new MongoClient("localhost", 27017);
       	  	 DB db = mongo.getDB("BigDataProject");
       	  	 DBCollection collection = db.getCollection("PB"); 
             String country;
             
             Scanner in = new Scanner(System.in);
        
             System.out.println("Enter the name of the country");
             country = in.nextLine();
             String device;
             
             Scanner dev = new Scanner(System.in);
        
             System.out.println("Enter a word");
             device = dev.nextLine();
       	  
       	  BasicDBObject query = new BasicDBObject();
       	Pattern regex = Pattern.compile(device); // should be m in your case
       	query.put("text", regex);
       	query.append("user.location", country);
        BasicDBObject projection = new BasicDBObject("text",1);
       	DBCursor cursor = collection.find(query,projection);
       	try {
       	   while(cursor.hasNext()) {
       	       System.out.println(cursor.next());
       	   }
       	} finally {
       	   cursor.close();
       	}
           	
          }
       	  
       	  catch(Exception e)
          {
              System.out.println(e);
          } 
  }
   
    }
