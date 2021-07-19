/*
DELIMITER $$
CREATE PROCEDURE getSidCid(INOUT sidcid BIGINT)
BEGIN
SELECT c_id INTO sidcid FROM students WHERE s_id=sidcid;
END$$
DELIMITER ;
*/
//STEP 1. Import required packages
import java.sql.*;

public class CallableStatementInOut {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/wkendbatch";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "abcdfe";
   
   public static void main(String[] args) {
   Connection conn = null;
   java.sql.CallableStatement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      String sql = "{call getSidCid (?)}";
      stmt = conn.prepareCall(sql);
      
      //Bind IN parameter first, then bind OUT parameter
      int student_id = 89;
      stmt.setInt(1, student_id); // This would set ID as 102
      // Because second parameter is OUT so register it
      stmt.registerOutParameter(1, java.sql.Types.BIGINT);
      
      //Use execute method to run stored procedure.
      System.out.println("Executing stored procedure..." );
      stmt.execute();

      //Retrieve employee name with getXXX method
      int course_id = stmt.getInt(1);
      System.out.println("Course ID:"+course_id);
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
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Done!");
}//end main
}//end JDBCExample
