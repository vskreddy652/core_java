import java.sql.*;

class ResultSetMetaDataEg {
	public static void main(String args[]) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3316/abcd", "root", "abcdef");

			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("Total columns: " + rsmd.getColumnCount());
			System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
			System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}