import java.io.*;
import java.sql.*;

public class Example1 {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/emp";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "abcdef";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   java.sql.CallableStatement stmt = null;
	   ResultSet rs = null;
	   
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 
			 
			 BufferedReader br = new BufferedReader(new FileReader("D:/abcdef.txt"));
		        
		        String strf = br.readLine();
		                   
		        System.out.println("Read:"+strf);
		        String[] s2 = strf.split(",");
			 
			 String query = " INSERT into person  values(?,?,?,?,?)" ;
			 
			 PreparedStatement statement = conn.prepareStatement(query);
			  for (int i = 0; i < 15; i=i+5){
			 statement.setString(1,s2[i]);
			 statement.setString(2,s2[i+1]);
			 statement.setString(3,s2[i+2]);
			 statement.setString(4,s2[i+3] );
			 statement.setString(5, s2[i+4]);
			 statement.executeUpdate();
			 }
			
	}catch(Exception e ){
		System.out.println("Exception occurred:"+e.getMessage());
	}
	}

	}