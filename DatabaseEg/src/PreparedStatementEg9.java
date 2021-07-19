
//STEP 1: import sql package
import java.sql.*;

public class PreparedStatementEg9 {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3316/abcd";
	// 127.0.0.1

	// Database credentials
	static final String USER = "root";
	static final String PASS = "abcdef";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register and Load JDBC driver
			// JDBC jar can be downloaded from
			// https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.11
			// Class.forName("com.mysql.jdbc.Driver"); //MySQL version 5
			Class.forName("com.mysql.cj.jdbc.Driver");
			// STEP 3: Open a connection to database server
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected to database...");
			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			stmt = conn.createStatement();
		// SQL Injection
			System.out.println("Records before updatign salary");
			displayRecords(stmt);
			
			PreparedStatement pstmt = conn.prepareStatement("update simple set salary = ?");
			pstmt.setInt(1, 11000);
			
			if(pstmt.execute())
			{
				System.out.println("Record successfully updated");
			}
			
			pstmt.setInt(1, 20000);
			
			pstmt.execute();
			
			System.out.println("Records after updatign salary");
			displayRecords(stmt);

			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Done...");
	}// end main
	
	static void  displayRecords(Statement stmt) throws SQLException
	{
		String sql;
		sql = "SELECT * FROM simple";
		ResultSet rs = stmt.executeQuery(sql);

		// STEP 5: Extract data from result set
		while (rs.next()) {
			// Retrieve by column name
			// Can retrieve values with column index also eg. getInt(int
			// column_index);
			int id = 0;

			id = rs.getInt("id");

			String name = rs.getString("name");
			int salary = rs.getInt("salary");

			// Display values
			System.out.print("Row Number:" + rs.getRow());
			System.out.print("ID: " + id);
			System.out.print(", Name: " + name);
			System.out.println(", Salary: " + salary);

			// printDisplayDirection(rs);
		} // STEP 6: Clean-up environment

	}
}
