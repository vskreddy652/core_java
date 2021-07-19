
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

public class PreparedStatementEg {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3316/emp";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "abcdef";
   
   public static void main(String[] args) {
   Connection conn = null;
   PreparedStatement pstmt = null;
   try{
      //STEP 2: Register and Load JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      //STEP 3: Open a connection to database server
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query 
      System.out.println("Creating statement...");
      pstmt = conn.prepareStatement("insert into employee(eid,ename,esalary) "
      								+ "values(?, ?, ?)");
      
      pstmt.setInt(1, 26);
      
      pstmt.setString(2, "kumar");
      pstmt.setInt(3, 218);
      
      int cnt1 = pstmt.executeUpdate();
      
      
      pstmt.setInt(1, 200);
      
      pstmt.setString(2, "Ravi");
      pstmt.setInt(3, 154);
      
      int cnt2 = pstmt.executeUpdate();
      

      System.out.println("affected rows..."+cnt1+" "+cnt2);
   

      
      //STEP 6: Clean-up environment
      pstmt.close();
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
         if(pstmt!=null)
            pstmt.close();
      }catch(SQLException se2){
      }// nothing we can do
   }//end try
   System.out.println("Done...");
}//end main
}

