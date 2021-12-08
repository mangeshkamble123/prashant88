package ojttask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
		java.sql.PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs = ps.executeQuery();

		Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pqr", "root", "root");
		Statement stmt = con1.createStatement();
		String sql1 = "create table Analytic_sec(eid int,ename varchar(30),ephone int)";
		String sql2 = "create table Admin_sec(eid int,ename varchar(30),ephone int)";
		String sql3 = "create table HR_sec(eid int,ename varchar(30),ephone int)";
		try {
			stmt.execute(sql1);
			stmt.execute(sql2);
			stmt.execute(sql3);

		} catch (Exception e) {

		}

		while (rs.next()) {

			int eid = rs.getInt(1);
			String ename = rs.getString(2);
			int ephone = rs.getInt(3);
			String table_name = rs.getString(4);

			if (table_name.equals("Analytic_sec")) {

				String sql11 = "insert into Analytic_sec values(" + eid + ",'" + ename + "'," + ephone + ")";
				stmt.execute(sql11);
				stmt.execute("commit");

			} else if (table_name.equals("Admin_sec")) {

				String sql22 = "insert into Admin_sec values(" + eid + ",'" + ename + "'," + ephone + ")";
				stmt.execute(sql22);
				stmt.execute("commit");

			} else if (table_name.equals("HR_sec")) {

				String sql33 = "insert into HR_sec values(" + eid + ",'" + ename + "'," + ephone + ")";
				stmt.execute(sql33);
				stmt.execute("commit");

			}

		}
		con.close();
		con1.close();
		System.out.println("task4 completed");
	}
}