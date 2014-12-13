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

public class mongo {
	

	    public static void main(String[] args) {
	        try
	        {
	       
	        MongoClient mc=new MongoClient(Arrays.asList(new ServerAddress("localhost",27017)));
	        DB db=mc.getDB("BigDataProject");
	        Set<String> sc=db.getCollectionNames();
	        DBCollection c=db.getCollection("PB");
	        System.out.println(sc);
	        mc.setWriteConcern(WriteConcern.JOURNAL_SAFE);
	        File f=new File("C:\\Users\\Deepu\\Downloads\\Big data project\\project\\twittertweets1.txt");
	        InputStream is=new FileInputStream(f);
	        BufferedReader br=new BufferedReader(new InputStreamReader(is)); 
	        String l;
	        while((l=br.readLine())!=null)
	                {
	                 System.out.println(l)   ;
	                 DBObject bson = (DBObject) JSON.parse(l.toString());
	                
	                 c.insert(bson);
	                }
	        is.close();
	        mc.close();
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        } 
	    }  
	
}
