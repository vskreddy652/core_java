import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Employee {
	int id;
	String name;
	float salary;
	Connection con;
	Statement st;

	Employee() {
		id = 0;
		name = "";
		salary = 0;
	}

	Employee(int id, String name, float salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
}

public class RemoveMe {

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3316/test99";
	public static final String JDBC_USER = "root";
	public static final String JDBC_PASSWORD = "abcdef";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement st = null, st1 = null;
		ResultSet rs = null;

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load JDBC Driver, check name... ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Unable to connect to database.." + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			st = con.createStatement();
			st1 = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Unable to create statement.... " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rs = st.executeQuery("select * from employee");
		} catch (SQLException e) {
			System.out.println("Exception while executing query ... " + e.getMessage());
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				int id = rs.getInt("eid");
				String name = rs.getString("ename");
				float sal = rs.getFloat("esalary");

				System.out.println("Emp ID=" + id + ": Emp Name=" + name + ": EmpSalary=" + sal);
			}
		} catch (SQLException e) {
			System.out.println("Caught SQL Exception... " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Updating Employee Salary by 10%.");

		try {
			rs = st.executeQuery("select * from employee");
			while (rs.next()) {
				int id = rs.getInt("eid");
				String name = rs.getString("ename");
				float sal = rs.getFloat("esalary");

				String query = "update employee set ename=\"" + name + "\", esalary=" + (sal + sal * .1) + " where eid="
						+ id + ";";
				System.out.println("QQQQQQQQQQQQQuery is " + query);

				st1.executeUpdate(query);
			}
		} catch (SQLException e) {
			System.out.println("Unabel to get detail for employee and update the salary... " + e.getMessage());
			e.printStackTrace();
		}

		try {
			rs = st.executeQuery("select * from employee");
			while (rs.next()) {
				int id = rs.getInt("eid");
				String name = rs.getString("ename");
				float sal = rs.getFloat("esalary");

				System.out.println("Emp ID=" + id + ": Emp Name=" + name + ": EmpSalary=" + sal);
			}
		} catch (SQLException e) {
			System.out.println("Some execption while retrieving data after update salary... " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Bingo... connection established.... ");
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

