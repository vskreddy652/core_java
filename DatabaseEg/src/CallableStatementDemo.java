/*
DELIMITER $$
CREATE PROCEDURE getEmpName1(IN empid BIGINT, OUT empname VARCHAR(500))
BEGIN
SELECT ename INTO empname FROM employee WHERE eid=empid;
END $$
DELIMITER ;
 */

/**
 *
 * @author ADMIN
 */
//STEP 1. Import required packages
import java.sql.*;

public class CallableStatementDemo {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   
   
   static final String DB_URL = "jdbc:mysql://127.0.0.1:3316/testdb";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "abcdef";
   
   public static void main(String[] args) {
   Connection conn = null;
   CallableStatement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      String sql = "{call getName(?, ?)}";//? is place holder for IN and OUT parameters
      stmt = conn.prepareCall(sql);
      
      //Bind IN parameter first, then bind OUT parameter
      int emp_id = 1;
      stmt.setInt(1/*parameter number*/, emp_id); // This would set ID
      // Because second parameter is OUT so register it
      stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
      
      //Use execute method to run stored procedure.
      System.out.println("Executing stored procedure..." );
      stmt.execute(); //now stored procedure gets executed in the database

      //Retrieve student name with getXXX method
      String emp_name = stmt.getString(2);//2 is OUT parameter number
      
      
      System.out.println("Student with ID:" +emp_id + " is " + emp_name);
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
         conn.close();
      }catch(SQLException se2){
      }// nothing we can do
   }//end try
   System.out.println("Done!");
}//end main
}//end JDBCExample
