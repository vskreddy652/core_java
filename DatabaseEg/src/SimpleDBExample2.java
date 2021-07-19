
//STEP 1: import sql package
import java.sql.*;

public class SimpleDBExample2 {
   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/abcd";
	   //127.0.0.1

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "abcdef";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register and Load JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection to database server
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      System.out.println("Connected to database...");
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
     
      String sql;
      sql = "delete from emptable";
      int no_of_affected_rows = stmt.executeUpdate(sql);

      if(no_of_affected_rows>0)
      {
    	  System.out.println("Done Succesfully");
      }
      else
      {
    	  System.out.println("Not done");
      }
     
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   System.out.println("Done...");
}//end main
}

