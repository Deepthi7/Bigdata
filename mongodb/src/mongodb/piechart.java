package mongodb;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics2D;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.awt.event.*;
import java.util.regex.Pattern;

public class piechart extends JFrame {
	   private Font         font; 
	   int cur,cur1,cur2, cur3, cur4, cur5, cur6;

	   @SuppressWarnings("deprecation")
	public piechart ()
	   {
	      super( "PieChart" );
	
	      setSize( 600, 400 );
	      setLocation( 70, 70 ) ;
	      show();
	   }

	   public void paint( Graphics g )
	   {
		   Graphics2D g2d = (Graphics2D) g;
		   query();
		   float PercIos, PercWin, PercAndro, PercMac, PercBlack, PercLinux, PercUbun;
		   
		   int Total;// The percentages
		   Total = cur + cur1 + cur2 + cur3+ cur4+ cur5+ cur6;
		   PercWin = (cur * 100.0f) / Total;
		   PercIos = (cur1 * 100.0f) / Total;
		   PercAndro = (cur2 * 100.0f) / Total;
		   PercMac= (cur3 * 100.0f) / Total;
		   PercBlack = (cur4 * 100.0f) / Total;
		   PercLinux = (cur5 * 100.0f) / Total;
		   PercUbun = (cur6 * 100.0f) / Total;
		   
		  int degrees1 = (int)(PercWin * 360 / 100);
		  int degrees2 = (int)(PercIos * 360 / 100);
		  int degrees3 = (int)(PercAndro * 360 / 100);
		  int degrees4 = (int)(PercMac * 360 / 100);
		  int degrees5 = (int)(PercBlack * 360 / 100);
		  int degrees6 = (int)(PercLinux * 360 / 100);
		  int degrees7 = (int)(PercUbun * 360 / 100);
		  
		// Display/output results
		   System.out.println("% Win = " + PercWin);
		   System.out.println("% Ios = " + PercIos);
		   System.out.println("% Andro = " + PercAndro);
		   System.out.println("% Mac = " + PercMac);
		   System.out.println("% Blackberry = " + PercBlack);
		   System.out.println("% Linux = " + PercLinux);
		   System.out.println("% Ubuntu = " + PercUbun);

	      font = new Font("Sanserif", Font.BOLD, 14);
	      // start at 0 and sweep 360 degrees
	     
	      g2d.setColor( Color.orange );

	      g2d.fillArc( 110, 80, 300, 300, 0, degrees1 );
	      g2d.drawString("Windows", 420, 80);

	      g2d.setColor( Color.red );
	      
	      g2d.fillArc( 110, 80, 300, 300, degrees1, degrees2 );
	      g2d.drawString("IOS", 420, 100);

	      g2d.setColor( Color.green );
	      int x = degrees1+degrees2;
	      g2d.fillArc( 110, 80, 300, 300, x, degrees3 );
	      g2d.drawString("Android", 420, 120);
	    
	      
	      g.setColor( Color.blue );
	      int y=degrees1+degrees2+degrees3;
	      g.fillArc( 110, 80, 300, 300, y, degrees4 );
	      g.drawString("Mac", 420, 140);

	      g.setColor( Color.pink );
	      int z=degrees1+degrees2+degrees3+degrees4;
	      g.fillArc( 110, 80, 300, 300, z, degrees5 );
	      g.drawString("Blackberry", 420, 160);
	      
	      g.setColor( Color.lightGray );
	      int z1=degrees1+degrees2+degrees3+degrees4+degrees5;
	      g.fillArc( 110, 80, 300, 300, z1, degrees6);
	      g.drawString("Linux", 420, 180);
	      
	      g.setColor( Color.MAGENTA );
	      int z2=degrees1+degrees2+degrees3+degrees4+degrees5+degrees6;
	      g.fillArc( 110, 80, 300, 300, z2, degrees7 );
	      g.drawString("Ubuntu", 420, 200);
	      
	      g2d.setColor( Color.black );
	      g2d.drawArc( 110, 80, 300, 300, 0, 360 );
	   }

	   public static void main( String args[] )
	   {
	      piechart app = new piechart ();

	      app.addWindowListener(
	         new WindowAdapter() {
	            public void windowClosing( WindowEvent e )
	            {
	               System.exit( 0 );
	            }
	         }
	      );

	   
	   }
	   
	    public   void query() {
	    	 try
		        {
		        

		       MongoClient mongo = new MongoClient("localhost", 27017);
		       DB db = mongo.getDB("BigDataProject");
		       DBCollection collection = db.getCollection("PB"); 
		       	  
		        BasicDBObject query = new BasicDBObject();
		       	Pattern regex = Pattern.compile("Windows"); // should be m in your case
		       	query.put("text", regex);
		        cur = collection.find(query).count();
		           	  	
		        System.out.println("Tot number of Windows Count "+cur);
		       	     
		       	     
		       	  BasicDBObject query1 = new BasicDBObject();
		       	  Pattern regex1 = Pattern.compile("ios");
			      query1.put("text", regex1);
			      cur1 = collection.find(query1).count();
			           	  	
			      System.out.println("Tot number of IOS count: "+cur1);
			       	     
			      BasicDBObject query2 = new BasicDBObject();
				  Pattern regex2 = Pattern.compile("Android"); 
				  query2.put("text", regex2);
				  cur2 = collection.find(query2).count();
				           	  	
				  System.out.println("Tot number of Android Count: "+cur2);
				       	     
				       	     
				  BasicDBObject query3 = new BasicDBObject();
				  Pattern regex3 = Pattern.compile("Mac"); 
				  query3.put("text", regex3);
				  cur3 = collection.find(query3).count();
					           	  	
				  System.out.println("Tot number of Mac Count: "+cur3);
				       	      
					       	     
		       	  BasicDBObject query4 = new BasicDBObject();
		       	  Pattern regex4 = Pattern.compile("Blackberry"); 
		       	  query4.put("text", regex4);
		       	  cur4 = collection.find(query4).count();
						           	  	
		       	  System.out.println("Tot number of Blackberry Count: "+cur4);
					       	     
						       	     
		       	  BasicDBObject query5 = new BasicDBObject();
		       	  Pattern regex5 = Pattern.compile("Linux"); 
		       	  query5.put("text", regex5);
		       	  cur5 = collection.find(query5).count();
							           	  	
		       	  System.out.println("Tot number of Linux Count: "+cur5);
						       	     
							       	     
		       	  BasicDBObject query6 = new BasicDBObject();
		       	  Pattern regex6 = Pattern.compile("Ubuntu"); 
		       	  query6.put("text", regex6);
		       	  cur6 = collection.find(query6).count();
		       	  System.out.println("Tot number of Ubuntu Count: "+cur6);
							       	     
		          }
		       	  
		       	  catch(Exception e)
		          {
		              System.out.println(e);
		          } 
		  }
	   
	   
	}


